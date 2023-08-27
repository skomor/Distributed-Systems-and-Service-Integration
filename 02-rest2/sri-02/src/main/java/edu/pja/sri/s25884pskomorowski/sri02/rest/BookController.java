package edu.pja.sri.s25884pskomorowski.sri02.rest;

import edu.pja.sri.s25884pskomorowski.sri02.dto.BookDto;
import edu.pja.sri.s25884pskomorowski.sri02.model.Book;
import edu.pja.sri.s25884pskomorowski.sri02.repo.BookRepository;
import org.modelmapper.ModelMapper;
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

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    public BookController(BookRepository bookRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }
    private BookDto convertToDto(Book e){
        return modelMapper.map(e, BookDto.class);
    }
    private Book convertToEntity(BookDto dto) {
        return modelMapper.map(dto, Book.class);
    }

    @GetMapping
    public ResponseEntity<Collection<BookDto>> getBooks() {
        List<Book> allBooks = bookRepository.findAll();
        List<BookDto> result = allBooks.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookDto>
    getBookById(@PathVariable Long bookId) {
        Optional<Book> book =
                bookRepository.findById(bookId);
        if(book.isPresent()) {
            BookDto bookDto = convertToDto(book.get());
            return new ResponseEntity<>(bookDto,
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null,
                    HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity saveNewBook(@RequestBody BookDto bookDto) {
        Book entity = convertToEntity(bookDto);
        bookRepository.save(entity);
        HttpHeaders headers = new HttpHeaders();
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(entity.getId())
                .toUri();
        headers.add("Location", location.toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }
    @PutMapping("/{bookId}")
    public ResponseEntity updateBook(@PathVariable Long bookId, @RequestBody BookDto bookDto) {
        Optional<Book> currentEmp =
                bookRepository.findById(bookId);
        if(currentEmp.isPresent()) {
            bookDto.setId(bookId);
            Book entity = convertToEntity(bookDto);
            bookRepository.save(entity);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{bookId}")
    public ResponseEntity deleteBook(@PathVariable Long bookId)
    {
        bookRepository.deleteById(bookId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
