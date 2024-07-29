package elo.tech.biblioteca.service;

import elo.tech.biblioteca.config.IntegracaoApiGoogleBooksConfig;
import elo.tech.biblioteca.domain.GoogleBookDataResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class IntegracaoGoogleBooksService {

    private static final String  URL="https://www.googleapis.com/books/v1/volumes";
    private final IntegracaoApiGoogleBooksConfig apiGoogleBooksConfig;

    private final RestTemplate restTemplate;

    public IntegracaoGoogleBooksService(IntegracaoApiGoogleBooksConfig apiGoogleBooksConfig) {
        this.restTemplate = new RestTemplate();
        this.apiGoogleBooksConfig = apiGoogleBooksConfig;
    }

    public GoogleBookDataResponse searchBook(String query) {
        RestTemplate restTemplate = new RestTemplate();

        URI uri = UriComponentsBuilder.fromHttpUrl(URL)
                .queryParam("q", query)
                .queryParam("key", apiGoogleBooksConfig.getApiKey())
                .build()
                .toUri();

        GoogleBookDataResponse googleBook = this.restTemplate.getForObject(uri, GoogleBookDataResponse.class);
        return this.restTemplate.getForObject(uri, GoogleBookDataResponse.class);
    }

    public GoogleBookDataResponse findBookByTitle(String title) {
        RestTemplate restTemplate = new RestTemplate();

        URI uri = UriComponentsBuilder.fromHttpUrl(URL)
                .queryParam("q", "intitle:" + title)
                .queryParam("key", apiGoogleBooksConfig.getApiKey())
                .build()
                .toUri();


        return this.restTemplate.getForObject(uri, GoogleBookDataResponse.class);
    }

}
