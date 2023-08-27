package edu.pja.sri.s25884pskomorowski.sri02.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private Long id;

    private String name;
    private String authorName;
    private String publisher;
    private String genre;
}
