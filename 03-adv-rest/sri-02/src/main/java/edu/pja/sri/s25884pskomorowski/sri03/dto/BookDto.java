package edu.pja.sri.s25884pskomorowski.sri03.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private Long id;

    @NotBlank
    @Size(min=2, max=255)
    private String name;
    private String authorName;
    private String publisher;
    private String genre;
}
