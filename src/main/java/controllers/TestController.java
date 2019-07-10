package controllers;

import model.Book;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class TestController {

    @RequestMapping(path = "/add/{id}/{title}/{price}", method = RequestMethod.GET)
    public String addBook(@PathVariable String id, @PathVariable String title, @PathVariable String price) {

        Book book = new Book(id, title, price);
        new MongoDBController().add(book);
        new MySqlController().add(book);
        return "Book ID " + id + " Book Title " + title + " Book Price " + price;

    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable String id) {

        Book book = new Book(id);
        new MongoDBController().delete(book);
        new MySqlController().delete(book);
        return "Book ID " + id;

    }

    @RequestMapping(path = "/update/{id}/{title}/{price}", method = RequestMethod.GET)
    public String updateBook(@PathVariable String id, @PathVariable String title, @PathVariable String price) {

        Book book = new Book(id, title, price);
        new MongoDBController().update(book);
        new MySqlController().update(book);
        return "Book ID " + id + " Book Title " + title + " Book Price " + price;

    }
}