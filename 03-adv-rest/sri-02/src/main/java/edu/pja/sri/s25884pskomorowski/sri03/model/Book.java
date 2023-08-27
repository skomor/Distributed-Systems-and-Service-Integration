package edu.pja.sri.s25884pskomorowski.sri03.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    @Size(min=2, max=255)
    private String name;

    @ManyToOne
    @JoinColumn(name="mainAuthor_id")
    private Author mainAuthor;

    private String publisher;
    private LocalDate publicationDate;
    private String genre;
    private int borrowedTimes;
}
