package com.twu.biblioteca.domain;

import java.util.Arrays;
import java.util.Optional;

public class BookList extends MediaList{

    public BookList() {
        this.mediaList = Arrays.asList(new Book("Book 1", "author 1", 2017),
                                        new Book("Book 2", "author 2", 1994));
    }

    public boolean returnByTitle(String title) {
        Optional<Media> bookToReturn = mediaList.stream().filter(x -> x.getTitle().equalsIgnoreCase(title)).findFirst();
        return bookToReturn.isPresent() && ((Book) (bookToReturn.get())).returnBook();
    }
}
