package controllers;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class TestController {

   @RequestMapping(path = "/add/{id}/{title}/{price}", method = RequestMethod.GET)
   public String addBook(@PathVariable String id, @PathVariable String title,  @PathVariable String price) {
       // code here
       MongoDBController obj = new MongoDBController();
       obj.add(id,title,price);
       return "Book ID "+id+" Book Title "+title+" Book Price "+price;

   }
    @RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable String id) {
        // code here
        MongoDBController obj = new MongoDBController();
        obj.delete(id);
        return "Book ID "+id;

    }
    @RequestMapping(path = "/update/{id}/{title}/{price}", method = RequestMethod.GET)
    public String updateBook(@PathVariable String id, @PathVariable String title,  @PathVariable String price) {
        // code here
        MongoDBController obj = new MongoDBController();
        obj.update(id,title,price);
        return "Book ID "+id+" Book Title "+title+" Book Price "+price;

    }
}