package com.twu.biblioteca.domain;

import java.util.Arrays;

public class MovieList extends MediaList{

    public MovieList() {
        this.mediaList = Arrays.asList(new Movie("Movie 1", "director 1", 2017, 10),
                new Movie("Movie 2", "director 2", 1994, 9));
    }
}
