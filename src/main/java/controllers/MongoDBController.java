package controllers;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import model.Book;
import org.bson.Document;

import java.util.logging.Logger;

public class MongoDBController {
    private static final Logger LOGGER = Logger.getLogger(MongoDBController.class.getName());
    MongoCollection<Document> collection;
    DBCollection table;
    static final String ID = "Book ID";
    static final String TITLE = "Book Title";
    static final String PRICE = "Book Price";


    //method to create connection
    public MongoDBController() {

        MongoClient mongo = new MongoClient("localhost", 27017);
        DB db = mongo.getDB("testdb");
        table = db.getCollection("items");
        LOGGER.info("MongoDb Connected ");

    }

    //method to add a book to the mongo database
    public void add(Book book) {
        BasicDBObject item = new BasicDBObject()
                .append(ID,book.getBookID() )
                .append(TITLE, book.getBookTitle())
                .append(PRICE, book.getBookPrice());
        table.insert(item);
        LOGGER.info("MongoDb 1 Row added.....");

    }
    //method to delete a book from the mongo database
    public void delete(Book book) {

        BasicDBObject delete = new BasicDBObject();
        delete.put(ID, book.getBookID());
        table.remove(delete);
        LOGGER.info("MongoDb 1 Row deleted ");
    }

    //method to update book details on the mongo database
    public void update(Book book) {

        BasicDBObject old = new BasicDBObject(ID, book.getBookID());
        BasicDBObject newData = new BasicDBObject().append(TITLE, book.getBookTitle())
                .append(PRICE, book.getBookPrice());
        BasicDBObject updateDoc = new BasicDBObject("$set", newData);
        table.update(old, updateDoc);
        LOGGER.info("MongoDb 1 Row updated ");
    }

}
