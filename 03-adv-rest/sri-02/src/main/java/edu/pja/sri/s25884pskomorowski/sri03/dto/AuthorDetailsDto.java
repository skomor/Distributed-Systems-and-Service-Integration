package edu.pja.sri.s25884pskomorowski.sri03.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorDetailsDto extends RepresentationModel<AuthorDetailsDto> {
    private Long id;

    private String name;
    private Set<BookDto> books;
}
