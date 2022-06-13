package ecommerce.cartservice.repository;

import ecommerce.cartservice.model.Candidate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

//@Testcontainers
@DataMongoTest
        //excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
public class CandidateRepositoryTest {

/*    @Container
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.2");

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
    }*/

    @Autowired
    private CandidateRepository candidateRepository;

/*    @Before
    public void setUp(){
        Candidate candidate =  Candidate.builder().email("houssem.eleuch@gmail.com").name("houssem").id("id").build();
        candidateRepository.save(candidate);
    }*/

    @AfterEach
    void cleanUp() {
        this.candidateRepository.deleteAll();
    }

    @Test
    public void whenFindOneCandidate_shouldReturnCandidateDetails(){
        //given
        Candidate candidate =  Candidate.builder().email("houssem.eleuch@gmail.com").name("houssem").id("id").build();
        //when
        Candidate candidateResponse = candidateRepository.findById("id").get();
        //then
        assertThat(candidateResponse.getEmail()).isEqualTo("houssem.eleuch@gmail.com");
        assertThat(candidateResponse.getName()).isEqualTo("houssem");
    }

    @Test
    public void whenFindAllCandidates_shouldReturnAllCandidatesDetails(){
        List<Candidate> persons = candidateRepository.findAll();
        assertThat(persons)
                .hasSize(2);
                //.contains(new Candidate("fakhri.amri@softylis.tn", "amri", "fakhri"));

    }

    @Rollback()
    @Test
    public void whenDeleteCandidateById_ShouldVerifyCandidateDeleted(){
        Optional<Candidate> candidate = candidateRepository.findById("fakhri.amri@softylis.tn");
        if(candidate.isPresent())
            candidateRepository.deleteById(candidate.get().getId());
        verify(candidateRepository , times(1)).deleteById(candidate.get().getId());
    }
    @Test
    public void whenSaveCandidate_ShouldReturnAddedPerson(){
        Candidate candidate =  Candidate.builder().email("houssem.eleuch@gmail.com").name("houssem").build();
        candidateRepository.save(candidate);
        verify(candidateRepository , times(1)).save(candidate);
    }

    @Test
    public void whenSaveCandidate_ShouldReturnModifiedCandidate(){

    }
}
