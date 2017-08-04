package com.twu.biblioteca.domain;

public class Media {
    protected final String title;
    protected final int year;
    protected boolean checked;

    public Media(String title, int year) {
        this.title = title;
        this.year = year;
        this.checked = false;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean checkout() {
        if (!isChecked()) {
            setChecked(true);
            return true;
        }
        return false;
    }
}
