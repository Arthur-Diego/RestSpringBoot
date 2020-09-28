package com.home.restspringboot.service;

import com.home.restspringboot.domain.Book;
import com.home.restspringboot.domain.builder.BookBuilder;
import com.home.restspringboot.domain.dto.BookDTO;
import com.home.restspringboot.exception.ResourceNotFoundException;
import com.home.restspringboot.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    
    private final BookRepository repository;

    public BookDTO create(BookDTO bookDto) {
        Book entity = new BookBuilder().toBook(bookDto);
        return new BookBuilder().toBookDTO(repository.save(entity));
    }

    public List<BookDTO> findAll() {
        List<BookDTO> bookDTOList = new ArrayList<>();
        repository.findAll().stream().forEach(
                b -> bookDTOList.add(new BookBuilder().toBookDTO(b))
        );
        return bookDTOList;
    }

    public BookDTO findById(Long id) {

        Book entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        return new BookBuilder().toBookDTO(entity);
    }

    public BookDTO update(BookDTO book) {
        Book entity = repository.findById(book.getKey())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setAuthor(book.getAuthor());
        entity.setLaunchDate(book.getLaunchDate());
        entity.setPrice(book.getPrice());
        entity.setTitle(book.getTitle());

        return new BookBuilder().toBookDTO(repository.save(entity));
    }

    public void delete(Long id) {
        Book entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(entity);
    }
    
}
