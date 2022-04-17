package com.anshu.lms.librarian;

import com.anshu.lms.domain.Book;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LibrarianController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello Spring";
    }


    @GetMapping("/book/search/{isbn}")
    public String getBook(@PathVariable String isbn) {
        //search this book2 with provided isbn from the DB and create book objects

        Book book1 = new Book();
        book1.setAuthorName("APJ Abdul Kalaam");
        book1.setName("The great India");
        book1.setIsbn("ISBN343423");

        Book book2 = new Book();
        book2.setAuthorName("R.D. Sharma");
        book2.setName("The Engineering Mathematics");
        book2.setIsbn("ISBN123");

        List<Book> allBooks = new ArrayList<>();
        allBooks.add(book1);
        allBooks.add(book2);

        Book foundBook = null;
        for (Book book : allBooks) {
            if (book.getIsbn().equals(isbn)) {
                foundBook = book;
                break;
            }
        }
        if (foundBook != null) {
            return new Gson().toJson(foundBook);
        }

        return "No such book found with provided ISBN: " + isbn;
    }

}
