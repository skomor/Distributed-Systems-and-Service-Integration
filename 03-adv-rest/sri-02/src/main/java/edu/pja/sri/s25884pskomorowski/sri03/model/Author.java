package edu.pja.sri.s25884pskomorowski.sri03.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private LocalDate DoB;
    private LocalDate DoD;

    @OneToMany(mappedBy = "mainAuthor")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Book> authoredBooks;

}
