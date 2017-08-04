package com.twu.biblioteca.domain;

import java.util.List;
import java.util.Optional;

public class MediaList {
    protected List<Media> mediaList;

    public String printAvailableMedia() {
        String list = "";
        for (Media media : mediaList) {
            if (!media.isChecked()) {
                list += media.toString() + "\n";
            }
        }
        return list;
    }

    public List<Media> getMediaList() {
        return mediaList;
    }

    public boolean checkoutByTitle(String title) {
        Optional<Media> mediaToCheckout = mediaList.stream().filter(x -> x.getTitle().equalsIgnoreCase(title)).findFirst();
        return mediaToCheckout.isPresent() && mediaToCheckout.get().checkout();
    }
}
