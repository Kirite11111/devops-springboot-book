package org.grostarin.springboot.demorest.repositories;

import java.util.List;

import org.grostarin.springboot.demorest.domain.BookBanned;
import org.springframework.data.repository.CrudRepository;

public interface BookBannedRepository extends CrudRepository<BookBanned, Long> {
    List<BookBanned> findByTitle(String title);

    BookBanned findByTitleAndAuthor(String title, String authors);
}
