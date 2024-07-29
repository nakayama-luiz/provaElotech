package elo.tech.biblioteca.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class BookItem {
    @JsonProperty("volumeInfo")
    private VolumeInfo volumeInfo;
}
