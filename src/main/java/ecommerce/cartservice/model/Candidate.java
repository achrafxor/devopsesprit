package ecommerce.cartservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Candidate {
        @Id
        private String id;
        private String name;
        private String phone;
        private String email;
        @JsonProperty
        private List<String> skills;
        @JsonProperty
        private List<Education> education ;
        @JsonProperty
        private List<Experience> experience ;

}
