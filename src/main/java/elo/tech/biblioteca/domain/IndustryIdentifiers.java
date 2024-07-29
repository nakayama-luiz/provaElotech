package elo.tech.biblioteca.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class IndustryIdentifiers {

    @JsonProperty("type")
    private String type;
    @JsonProperty("identifier")
    private String identifier;
}
