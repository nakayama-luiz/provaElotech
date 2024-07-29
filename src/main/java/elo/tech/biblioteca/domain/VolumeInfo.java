package elo.tech.biblioteca.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class VolumeInfo {
    @JsonProperty("title")
    private String title;

    @JsonProperty("authors")
    private List<String> authors;

    @JsonProperty("publishedDate")
    private String publishedDate;

    @JsonProperty("categories")
    private List<String> categories;

    @JsonProperty("industryIdentifiers")
    private List<IndustryIdentifiers> industryIdentifiers;


}
