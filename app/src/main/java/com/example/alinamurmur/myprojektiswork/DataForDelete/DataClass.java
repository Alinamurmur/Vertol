package com.example.alinamurmur.myprojektiswork.DataForDelete;

/**
 * Created by Alina on 17.07.2017.
 */

public class DataClass {
    String name,text, img;

    public DataClass(String name, String text, String img) {
        this.name = name;
        this.text = text;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
