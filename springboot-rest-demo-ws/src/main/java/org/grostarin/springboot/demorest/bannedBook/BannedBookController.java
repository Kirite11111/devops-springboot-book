package org.grostarin.springboot.demorest.bannedBook;

import org.grostarin.springboot.demorest.domain.Book;
import org.grostarin.springboot.demorest.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// BookBannedController.java
@RestController
@RequestMapping("/api/banned-books")
public class BookBannedController {

    private final BookServices bookBannedService;

    @Autowired
    public BookBannedController(BookServices bookBannedService) {
        this.bookBannedService = bookBannedService;
    }

    @PostMapping("/check")
    public ResponseEntity<String> checkIfBookIsBanned(@RequestBody Book book) {
        boolean isBanned = bookBannedService.isBookBanned(book);
        if (isBanned) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Ce livre est banni.");
        } else {
            return ResponseEntity.ok("Ce livre n'est pas banni.");
        }
    }
}
