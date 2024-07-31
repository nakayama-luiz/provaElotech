package elo.tech.biblioteca.controller;

import elo.tech.biblioteca.domain.GoogleBookDataResponse;
import elo.tech.biblioteca.service.IntegracaoGoogleBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/integracao")
@CrossOrigin
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
