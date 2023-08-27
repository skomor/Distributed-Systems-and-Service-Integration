package edu.pja.sri.s25884pskomorowski.sri03.dto;

import edu.pja.sri.s25884pskomorowski.sri03.model.Book;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorDto extends RepresentationModel<AuthorDto> {
    private Long id;

    private String name;
}
