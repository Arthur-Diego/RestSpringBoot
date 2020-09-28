package com.home.restspringboot.controller;

import com.home.restspringboot.domain.dto.BookDTO;
import com.home.restspringboot.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/v1/book")
public class BookRestController {

    private final BookService bookService;

    @GetMapping("/listAll")
    public ResponseEntity<List<BookDTO>> listAll(){
        List<BookDTO> books =  bookService.findAll();
        books.stream()
                .forEach(p -> p.add(
                        linkTo(methodOn(BookRestController.class).listAll()).withSelfRel()
                        )
                );
        return ResponseEntity.ok(books);
    }

}
