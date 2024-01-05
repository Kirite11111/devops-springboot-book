package org.grostarin.springboot.demorest.tests;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.grostarin.springboot.demorest.domain.Book;
import org.grostarin.springboot.demorest.services.BookServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

@SpringBootTest
public class BookServiceTests {
    @Autowired
    private BookServices bookService;
    
    @Test
    public void testCreationNoAttributes() {
        Book toCreate = new Book();
        assertThatExceptionOfType(DataIntegrityViolationException.class).isThrownBy( () -> bookService.create(toCreate));
    }

    @Test
    void whenCreatingBannedBook_thenThrowException() {
        Book bannedBook = new Book("Banned Title", "Author");
        bannedBook.setIsBanned(true);

        assertThatExceptionOfType(DataIntegrityViolationException.class).isThrownBy( () -> bookService.create(bannedBook));
    }
}


