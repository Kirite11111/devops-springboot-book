package org.grostarin.springboot.demorest.services;

import org.grostarin.springboot.demorest.domain.BookBanned;
import org.grostarin.springboot.demorest.dto.BookBannedSearch;
import org.grostarin.springboot.demorest.exceptions.BookBannedIdMismatchException;
import org.grostarin.springboot.demorest.exceptions.BookBannedNotFoundException;
import org.grostarin.springboot.demorest.repositories.BookBannedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class BookBannedServices {    

    @Autowired
    private BookBannedRepository bookbannedRepository;
    
    public Iterable<BookBanned> findAll(BookBannedSearch bookbannedSearchDTO) {
        if(bookbannedSearchDTO!=null && StringUtils.hasText(bookbannedSearchDTO.title())) {
            return bookbannedRepository.findByTitle(bookbannedSearchDTO.title());  
        }
        return bookbannedRepository.findAll();
    }

    public BookBanned findOne(long id) {
        return bookbannedRepository.findById(id)
          .orElseThrow(BookBannedNotFoundException::new);
    }

    public BookBanned create(BookBanned bookbanned) {
        return bookbannedRepository.save(bookbanned);
    }

    public void delete(long id) {
        bookbannedRepository.findById(id)
          .orElseThrow(BookBannedNotFoundException::new);
        bookbannedRepository.deleteById(id);
    }

    public BookBanned updateBookBanned(BookBanned bookbanned, long id) {
        if (bookbanned.getId() != id) {
            throw new BookBannedIdMismatchException();
        }
        bookbannedRepository.findById(id)
          .orElseThrow(BookBannedNotFoundException::new);
        return bookbannedRepository.save(bookbanned);
    }
}
