package com.home.restspringboot.domain.builder;

import com.home.restspringboot.domain.Book;
import com.home.restspringboot.domain.dto.BookDTO;

public class BookBuilder {

    public BookDTO toBookDTO(Book book){
        return BookDTO.builder()
                .key(book.getId())
                .author(book.getAuthor())
                .price(book.getPrice())
                .launchDate(book.getLaunchDate())
                .title(book.getTitle())
                .build();
    }

    public Book toBook(BookDTO bookDto){
        return Book.builder()
                .id(bookDto.getKey())
                .author(bookDto.getAuthor())
                .price(bookDto.getPrice())
                .launchDate(bookDto.getLaunchDate())
                .title(bookDto.getTitle())
                .build();
    }

}
