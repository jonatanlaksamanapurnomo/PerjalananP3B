package com.example.labftis.p02;

public class Food {
    protected String title;
    protected String details;
    protected boolean isFavourite;

    public Food(String title, String details) {
        this.title = title;
        this.details = details;
        this.isFavourite = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }
}
