package edu.pja.sri.s25884pskomorowski.sri03.rest;

import edu.pja.sri.s25884pskomorowski.sri03.dto.AuthorDetailsDto;
import edu.pja.sri.s25884pskomorowski.sri03.dto.AuthorDto;
import edu.pja.sri.s25884pskomorowski.sri03.dto.BookDto;
import edu.pja.sri.s25884pskomorowski.sri03.dto.mapper.AuthorDtoMapper;
import edu.pja.sri.s25884pskomorowski.sri03.model.Author;
import edu.pja.sri.s25884pskomorowski.sri03.model.Book;
import edu.pja.sri.s25884pskomorowski.sri03.repo.AuthorRepository;
import edu.pja.sri.s25884pskomorowski.sri03.repo.BookRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final AuthorDtoMapper authorDtoMapper;
    private final ModelMapper modelMapper;

  /*  public BookController(BookRepository bookRepository, ModelMapper modelMapper) {
        this.authorRepository = bookRepository;
        this.authorDtoMapper = modelMapper;
    }*/


    @GetMapping
    public ResponseEntity<Collection<AuthorDto>> getAuthors() {
        List<Author> authors = authorRepository.findAll();
        List<AuthorDto> result = authors.stream()
                .map(authorDtoMapper::convertToDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{authorId}")
    public ResponseEntity<AuthorDetailsDto>
    getBookById(@PathVariable Long authorId) {
        Optional<Author> author = authorRepository.findById(authorId);
        if(author.isPresent()) {
            AuthorDetailsDto authorDetailsDto = authorDtoMapper.convertToDetailsDto(author.get());
           // Link linkSelf = new Link("http://localhost:8080/api/authors/"+authorId);
            Link link = linkTo(methodOn(AuthorController.class).getBookById(authorId)).withSelfRel();
            authorDetailsDto.add(link);
            return new ResponseEntity<>(authorDetailsDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null,
                    HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{authorId}/books")
    public ResponseEntity<List<BookDto>>
    getBooksByAuthorId(@PathVariable Long authorId) {
        List<Book> author = bookRepository.findBooksByAuthorId(authorId);
        List<BookDto> result = author.stream().map(this::convertToDto).collect(Collectors.toList());
        return  new ResponseEntity<>(result, HttpStatus.OK);
    }

   /* @PostMapping()
    public ResponseEntity saveNewBook(@RequestBody BookDto bookDto) {
        Book entity = convertToEntity(bookDto);
        authorRepository.save(entity);
        HttpHeaders headers = new HttpHeaders();
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(entity.getId())
                .toUri();
        headers.add("Location", location.toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }*/
    /*
    @PutMapping("/{bookId}")
    public ResponseEntity updateBook(@PathVariable Long bookId, @RequestBody BookDto bookDto) {
        Optional<Book> currentEmp =
                authorRepository.findById(bookId);
        if(currentEmp.isPresent()) {
            bookDto.setId(bookId);
            Book entity = convertToEntity(bookDto);
            authorRepository.save(entity);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{bookId}")
    public ResponseEntity deleteBook(@PathVariable Long bookId)
    {
        authorRepository.deleteById(bookId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }*/
    private BookDto convertToDto(Book e){
        return modelMapper.map(e, BookDto.class);
    }
    private Book convertToEntity(BookDto dto) {
        return modelMapper.map(dto, Book.class);
    }
}
