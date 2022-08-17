package com.sam.service.impl;

import com.sam.dao.BookDao;
import com.sam.dao.impl.BookDaoImpl;
import com.sam.pojo.Book;
import com.sam.pojo.Page;
import com.sam.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {

        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {

        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {

        Page<Book> page = new Page<>();

        //設置當前頁資料數量
        page.setPageSize(pageSize);

        //求總記錄數並設置
        Integer pageTotalCount = bookDao.queryForTotalCount();
        page.setPageTotalCount(pageTotalCount);

        //求總頁碼並設置
        Integer pageTotal = pageTotalCount / pageSize;
        if(pageTotalCount % pageSize > 0){
            pageTotal += 1;
        }
        page.setPageTotal(pageTotal);

        //設置當前頁碼(必須放到總頁碼之後)
        page.setPageNo(pageNo);

        //設置當前頁的索引值
        int begin = (pageNo - 1) * pageSize;
        //查詢當前頁的資料
        List<Book> list = bookDao.queryForPageItems(begin, pageSize);
        page.setItems(list);

        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<>();

        //設置當前頁資料數量
        page.setPageSize(pageSize);

        //透過價格來求總記錄數並設置
        Integer pageTotalCount = bookDao.queryForPageTotalCountByPrice(min, max);
        page.setPageTotalCount(pageTotalCount);

        //求總頁碼並設置
        Integer pageTotal = pageTotalCount / pageSize;
        if(pageTotalCount % pageSize > 0){
            pageTotal += 1;
        }
        page.setPageTotal(pageTotal);

        //設置當前頁碼(必須放到總頁碼之後)
        page.setPageNo(pageNo);

        //設置當前頁的索引值
        int begin = (pageNo - 1) * pageSize;
        //透過價格查詢當前頁的資料
        List<Book> list = bookDao.queryForPageItemsByPrice(begin, pageSize, min, max);
        page.setItems(list);

        return page;
    }
}
