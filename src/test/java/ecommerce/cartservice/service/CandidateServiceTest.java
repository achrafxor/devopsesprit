package ecommerce.cartservice.service;

import ecommerce.cartservice.model.Candidate;
import ecommerce.cartservice.repository.CandidateRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.Rollback;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CandidateServiceTest {

    @InjectMocks
    private CandidateService candidateService;
    @Mock
    private CandidateRepository candidateRepository;
/*
    @Test
    void getPerson_returnPersonDetails() throws Exception{
        Mockito.when(candidateRepository.findById(Mockito.anyString())
                .thenReturn(new Candidate("houssem.eleuch@softylis.tn","Eleuch","Houssem"));
        assertThat(candidateService.getCandidateById(Mockito.anyString()))
                .isEqualToComparingFieldByField(candidateRepository.getOne(Mockito.anyString()));

    }

    @Test
    void getAllCandidates_returnAllCandidatesDetails(){
        when(candidateRepository.findAll())
                .thenReturn(Stream.of(new Candidate("houssem.eleuch@softylis.tn", "Eleuch", "Houssem"), new Person("fakhri.amri@softylis.tn", "amri", "fakhri"))
                        .collect(Collectors.toList()));
        assertThat(candidateService.getCandidateById("id"))
                .isNotEmpty()
                .hasSize(2)
                .contains(new Person("fakhri.amri@softylis.tn", "amri", "fakhri"));
    }
    @Rollback()
    @Test
    void deletePerson_returnDeletedPerson(){
        //assertThat(candidateService.deleteCandidate("houssem.eleuch@softylis.tn")).isEqualTo("personne supprimé");
    }

 */
}
