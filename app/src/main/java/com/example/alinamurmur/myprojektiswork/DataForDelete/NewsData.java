package com.example.alinamurmur.myprojektiswork.DataForDelete;

/**
 * Created by Alina on 14.07.2017.
 */

public class NewsData {
    String title,time;
    int img;

    public NewsData(String title, int img, String time) {
        this.title = title;
        this.img = img;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
