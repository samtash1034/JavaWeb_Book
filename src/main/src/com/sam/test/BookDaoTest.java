package com.sam.test;

import com.sam.dao.BookDao;
import com.sam.dao.impl.BookDaoImpl;
import com.sam.pojo.Book;
import com.sam.pojo.Page;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookDaoTest {

    private BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        System.out.println(bookDao.addBook(new Book(null, "被討厭的勇氣", 280, " 岸見一郎", 10, 500, null)));
    }

    @Test
    public void deleteBookById() {
        System.out.println(bookDao.deleteBookById(32));
    }

    @Test
    public void updateBook() {
        System.out.println(bookDao.updateBook(new Book(53, "被討厭的勇氣", 300, "岸見一郎", 100, 1000, null)));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(53));
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookDao.queryBooks();
        for(Book book : books){
            System.out.println(book);
        }
    }

    @Test
    public void queryForTotalCount(){
        System.out.println(bookDao.queryForTotalCount());
    }

    @Test
    public void queryForPageItems(){
        for (Book book : bookDao.queryForPageItems(2, Page.PAGE_SIZE)) {
            System.out.println(book);
        }
    }

    @Test
    public void queryForPageTotalCountByPrice(){
        System.out.println(bookDao.queryForPageTotalCountByPrice(0, 90));
    }

    @Test
    public void queryForPageItemsByPrice(){
        for (Book book : bookDao.queryForPageItemsByPrice(6, Page.PAGE_SIZE, 10, 90)) {
            System.out.println(book);
        }
    }
}