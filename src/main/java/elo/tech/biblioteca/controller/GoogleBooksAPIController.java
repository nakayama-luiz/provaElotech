package elo.tech.biblioteca.controller;

import elo.tech.biblioteca.domain.GoogleBookDataResponse;
import elo.tech.biblioteca.service.IntegracaoGoogleBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/integracao")
public class GoogleBooksAPIController {
    @Autowired
    private IntegracaoGoogleBooksService googleBooksService;

    @GetMapping("/search")
    public GoogleBookDataResponse searchBook(@RequestParam String query) {
        return googleBooksService.searchBook(query);
    }

    @GetMapping("/titulo")
    public GoogleBookDataResponse findBookByTitle(@RequestParam String titulo){
        GoogleBookDataResponse dataResponse = this.googleBooksService.findBookByTitle(titulo);

        return googleBooksService.findBookByTitle(titulo);
    }
}
