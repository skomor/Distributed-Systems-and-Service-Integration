package edu.pja.sri.s25884pskomorowski.sri03.dto.mapper;

import edu.pja.sri.s25884pskomorowski.sri03.dto.AuthorDetailsDto;
import edu.pja.sri.s25884pskomorowski.sri03.dto.AuthorDto;
import edu.pja.sri.s25884pskomorowski.sri03.dto.BookDto;
import edu.pja.sri.s25884pskomorowski.sri03.model.Author;
import edu.pja.sri.s25884pskomorowski.sri03.model.Book;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class AuthorDtoMapper {
    private ModelMapper modelMapper;

    public AuthorDetailsDto convertToDetailsDto(Author e) {
        return modelMapper.map(e, AuthorDetailsDto.class);
    }

    public AuthorDto convertToDto(Author e) {
        return modelMapper.map(e, AuthorDto.class);
    }

    public Author convertToEntity(AuthorDto dto) {
        return modelMapper.map(dto, Author.class);
    }
}
