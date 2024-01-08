package org.grostarin.springboot.demorest.services;

import org.grostarin.springboot.demorest.domain.Book;
import org.grostarin.springboot.demorest.domain.BookBanned;
import org.grostarin.springboot.demorest.dto.BookSearch;
import org.grostarin.springboot.demorest.exceptions.*;
import org.grostarin.springboot.demorest.repositories.BookBannedRepository;
import org.grostarin.springboot.demorest.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class BookServices {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookBannedRepository bookbannedRepository;


    public boolean IsBanned(String title, String authors){
        BookBanned bookBanned = bookbannedRepository.findByTitleAndAuthor(title, authors);
        System.out.println("ISBANNED");
        return bookBanned != null;
    }
    
    public Iterable<Book> findAll(BookSearch bookSearchDTO) {
        if(bookSearchDTO!=null && StringUtils.hasText(bookSearchDTO.title())) {
            return bookRepository.findByTitle(bookSearchDTO.title());  
        }
        return bookRepository.findAll();
    }

    public Book findOne(long id) {
        return bookRepository.findById(id)
          .orElseThrow(BookNotFoundException::new);
    }

    public Book create(Book book) {
        if (IsBanned(book.getTitle(),book.getAuthor())){
            System.out.println("IF YES");
            throw new BannedBookException();
        }
        System.out.println("IF NO");
        return bookRepository.save(book);
    }

    public void delete(long id) {
        bookRepository.findById(id)
          .orElseThrow(BookNotFoundException::new);
        bookRepository.deleteById(id);
    }

    public Book updateBook(Book book, long id) {
        if (book.getId() != id) {
            throw new BookIdMismatchException();
        }
        bookRepository.findById(id)
          .orElseThrow(BookNotFoundException::new);
        return bookRepository.save(book);
    }
}
