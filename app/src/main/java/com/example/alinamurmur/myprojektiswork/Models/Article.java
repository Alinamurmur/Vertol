package com.example.alinamurmur.myprojektiswork.Models;

public class Article {
    int id;
    int section;
    String title;
    String text;
    String img;
    String date;

    public Article() {

    }

    public Article(int id, int section, String title, String img, String date) {
        this.id = id;
        this.title = title;
        this.img = img;
        this.section = section;
        this.date = date;
    }

    public Article(String name, String date, String img) {
        this.title = name;
        this.date = date;
        this.img = img;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
