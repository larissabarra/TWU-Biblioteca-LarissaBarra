package com.twu.biblioteca.domain;

import com.twu.biblioteca.domain.Book;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class BookList {
    private List<Book> bookList;

    public BookList() {
        this.bookList = Arrays.asList(new Book("Book 1", "author 1", 2017),
                                        new Book("Book 2", "author 2", 1994));
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public String printBookList() {
        String list = "";
        for (Book book : bookList) {
            list += book.toString() + "\n";
        }
        return list;
    }

    public String printAvailableBooks() {
        String list = "";
        for (Book book : bookList) {
            if (!book.isChecked()) {
                list += book.toString() + "\n";
            }
        }
        return list;
    }

    public boolean checkoutByTitle(String title) {
        Optional<Book> bookToCheckout = bookList.stream().filter(x -> x.getTitle().equalsIgnoreCase(title)).findFirst();
        return bookToCheckout != null && bookToCheckout.get().checkOut();
    }
}
