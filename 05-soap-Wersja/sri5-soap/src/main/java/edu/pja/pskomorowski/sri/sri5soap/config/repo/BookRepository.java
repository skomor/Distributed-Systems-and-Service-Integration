package edu.pja.pskomorowski.sri.sri5soap.config.repo;


import edu.pja.pskomorowski.sri.sri5soap.config.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findAll();
}
