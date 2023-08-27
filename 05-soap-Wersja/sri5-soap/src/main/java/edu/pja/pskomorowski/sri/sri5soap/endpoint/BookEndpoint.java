package edu.pja.pskomorowski.sri.sri5soap.endpoint;

import edu.pja.pskomorowski.sri.sri5soap.config.SoapWSConfig;
import edu.pja.pskomorowski.sri.sri5soap.config.model.Book;
import edu.pja.pskomorowski.sri.sri5soap.config.repo.BookRepository;
import edu.pja.sri.pskomorowski.sri5soapps.books.*;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Endpoint
@RequiredArgsConstructor
public class BookEndpoint {
    private final BookRepository bookRepository;

    @PayloadRoot(namespace = SoapWSConfig.BOOKS_SCHEMA, localPart= "getBooksRequest")
    @ResponsePayload
    public GetBooksResponse getBooks(@RequestPayload GetBooksRequest req){
        List<Book> bookList = bookRepository.findAll();
        List<BookDto> dtoList = bookList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        GetBooksResponse res = new GetBooksResponse();
        res.getBooks().addAll(dtoList);
        return res;
    }

    private BookDto convertToDto(Book b) {
        if (b == null) {
            return null;
        }
        try {
            BookDto dto = new BookDto();
            dto.setId(new BigDecimal(b.getId()));
            dto.setAuthorName(b.getAuthorName());
            dto.setGenre(b.getGenre());
            XMLGregorianCalendar publicationDate = null;
            publicationDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(b.getPublicationDate().toString());
            dto.setPublicationDate(publicationDate);
            dto.setBorrowedTimes(b.getBorrowedTimes());
            return dto;
        } catch (DatatypeConfigurationException datatypeConfigurationException) {
            datatypeConfigurationException.printStackTrace();
            return null;
        }
    }
    private Book convertToEntity (BookDto dto) {
        LocalDate publicationDate = LocalDate.of(
                dto.getPublicationDate().getYear(),
                dto.getPublicationDate().getMonth(),
                dto.getPublicationDate().getDay());
        return Book.builder()
                .id(dto.getId() != null ? dto.getId().longValue(): null)
                .authorName (dto.getAuthorName())
                .genre(dto.getGenre())
                .borrowedTimes(dto.getBorrowedTimes())
                .publicationDate(publicationDate)
                .publisher(dto.getPublisher())
                .build();
    }

    @PayloadRoot (namespace = SoapWSConfig.BOOKS_SCHEMA, localPart= "getBookByIdRequest")
    @ResponsePayload
    public GetBookByIdResponse GetBookByIdResponse(@RequestPayload GetBookByIdRequest req) {
        Long bookId = req.getBookId().longValue();
        Optional<Book> bk = bookRepository.findById(bookId);
        GetBookByIdResponse res = new GetBookByIdResponse();
        res.setBook(convertToDto(bk.orElse(null)));
        return res;
    }

    @PayloadRoot (namespace = SoapWSConfig.BOOKS_SCHEMA, localPart= "addBookRequest")
    @ResponsePayload
    public AddBookResponse addBook (@RequestPayload AddBookRequest req) {
        BookDto bookDto = req.getBook();
        Book emp = convertToEntity(bookDto);
        bookRepository.save(emp);
        AddBookResponse response = new AddBookResponse();
        response.setBookId(new BigDecimal(emp.getId()));
        return response;
    }

    @PayloadRoot (namespace = SoapWSConfig.BOOKS_SCHEMA, localPart= "increaseBookBorrowsRequest")
    @ResponsePayload
    public IncreaseBookBorrowsResponse increaseBookBorrows (@RequestPayload IncreaseBookBorrowsRequest req) {
        Long bookId = req.getBookId().longValue();
        Optional<Book> bk = bookRepository.findById(bookId);
        bk.ifPresent(book -> {
            book.setBorrowedTimes(book.getBorrowedTimes() + 1);
            bookRepository.save(book);
        });
        IncreaseBookBorrowsResponse res = new IncreaseBookBorrowsResponse();
        res.setBook(convertToDto(bk.orElse(null)));
        return res;
    }

}