package elo.tech.biblioteca.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class GoogleBookDataResponse {

    @JsonProperty("items")
    private List<BookItem> items;

}
