package com.sam.test;

import com.sam.pojo.Book;
import com.sam.pojo.Page;
import com.sam.service.BookService;
import com.sam.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookServiceTest {

    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null, "原子習慣", 300, "詹姆斯‧克利爾", 500, 999, null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(46);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(54, "原子習慣", 310, "詹姆斯‧克利爾", 600, 9999, null));

    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(54));
    }

    @Test
    public void queryBooks() {
        for(Book book : bookService.queryBooks()){
            System.out.println(book);
        }
    }

    @Test
    public void page(){
        System.out.println(bookService.page(3, Page.PAGE_SIZE));
    }

    @Test
    public void pageByPrice(){
        System.out.println(bookService.pageByPrice(1, Page.PAGE_SIZE, 0, 80));
    }
}