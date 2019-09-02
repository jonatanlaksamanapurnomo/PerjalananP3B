package com.example.t0216025;

public class Food {
    protected String title;
    protected String detail;
    public boolean isFavorite;

    public Food(String title, String detail)
    {
        this.title=title;
        this.detail=detail;
        this.isFavorite=false;
    }

    public String getTitle()
    {
        return this.title;
    }

    public void setTitle(String title)
    {
        this.title=title;
    }
    public String getDetail()
    {
        return this.detail;
    }
    public void setDetail(String detail)
    {
        this.detail=detail;
    }

}
