package edu.pja.sri.s25884pskomorowski.sri02.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String authorName;
    private String publisher;
    private LocalDate publicationDate;
    private String genre;
    private int borrowedTimes;
}
