package edu.pja.sri.s25884pskomorowski.sri02.repo;

import edu.pja.sri.s25884pskomorowski.sri02.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findAll();
}
