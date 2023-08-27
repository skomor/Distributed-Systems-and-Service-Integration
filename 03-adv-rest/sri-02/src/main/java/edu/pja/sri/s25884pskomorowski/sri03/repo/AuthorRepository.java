package edu.pja.sri.s25884pskomorowski.sri03.repo;

import edu.pja.sri.s25884pskomorowski.sri03.model.Author;
import edu.pja.sri.s25884pskomorowski.sri03.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    List<Author> findAll();

    @Query("from Author as a left join fetch a.authoredBooks where a.id=:authorId")
    Optional<Author> getAuthorDetailsByID(@Param("authorId") long authorId);
}
