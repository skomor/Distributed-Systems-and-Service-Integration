package edu.pja.pskomorowski.sri.sri5soap;

import edu.pja.pskomorowski.sri.sri5soap.config.model.Book;
import edu.pja.pskomorowski.sri.sri5soap.config.repo.BookRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger LOG = LoggerFactory.getLogger(DataInitializer.class);

    private final BookRepository bookRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
initData();
    }

    private void initData() {
        Book b1 = Book.builder().name("ok").authorName("Sapkowski").publisher("WSK").publicationDate(LocalDate.now())
                .genre("Fiction").borrowedTimes(1).build();
        bookRepository.saveAll(Arrays.asList(b1));
        LOG.info("Data init");
    }
}
