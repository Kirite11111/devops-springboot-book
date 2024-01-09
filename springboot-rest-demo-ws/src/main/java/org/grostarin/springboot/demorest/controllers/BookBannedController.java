package org.grostarin.springboot.demorest.controllers;

import javax.validation.Valid;

import org.grostarin.springboot.demorest.annotations.LogExecutionTime;
import org.grostarin.springboot.demorest.domain.BookBanned;
import org.grostarin.springboot.demorest.dto.BookBannedSearch;
import org.grostarin.springboot.demorest.services.BookBannedServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookbanned")
public class BookBannedController {

    @Autowired
    private BookBannedServices bookbannedServices;

    @GetMapping
    @LogExecutionTime
    public Iterable<BookBanned> findAll(@Valid BookBannedSearch bookbannedSearchDTO) {
        return bookbannedServices.findAll(bookbannedSearchDTO);
    }

    @GetMapping("/{id}")
    public BookBanned findOne(@PathVariable long id) {
        return bookbannedServices.findOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody BookBanned bookbanned) {
        return new ResponseEntity<>(bookbannedServices.create(bookbanned), HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        bookbannedServices.delete(id);
    }

    @PutMapping("/{id}")
    public BookBanned updateBookBanned(@RequestBody BookBanned bookbanned, @PathVariable long id) {
        return bookbannedServices.updateBookBanned(bookbanned, id);
    }
}
