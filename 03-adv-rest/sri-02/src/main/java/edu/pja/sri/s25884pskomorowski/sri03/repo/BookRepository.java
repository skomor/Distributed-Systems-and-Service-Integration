package edu.pja.sri.s25884pskomorowski.sri03.repo;

import edu.pja.sri.s25884pskomorowski.sri03.model.Author;
import edu.pja.sri.s25884pskomorowski.sri03.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findAll();

    @Query("select a.authoredBooks from Author as a where a.id=:authorId")
    List<Book> findBooksByAuthorId(@PathVariable Long authorId);
}
