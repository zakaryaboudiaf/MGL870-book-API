package com.mgl870springbootapi;

import com.mgl870springbootapi.repository.BookRepository;
import com.mgl870springbootapi.entity.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookApplication.class);
    }

    @Bean
    public CommandLineRunner sampleData(BookRepository repository) {
        return (args) -> {
            repository.save(new Book("Ce que le jour doit à la nuit", "Yasmina Khadra", "descreption 1"));
            repository.save(new Book("L'Étranger", "Albert Camus", "descreption 2"));
            repository.save(new Book("La Bâtarde d'Istanbul", "Elif Shafak", "descreption 3"));
        };
    }


}
