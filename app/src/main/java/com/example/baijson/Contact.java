package com.example.baijson;

public class Contact {
    private int id;
    private String url,title;

    public Contact(int id, String url, String title) {
        this.id = id;
        this.url = url;
        this.title = title;
    }

    public Contact() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
