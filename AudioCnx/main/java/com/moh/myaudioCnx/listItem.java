package com.moh.myaudioCnx;

public class listItem {
    public String Title;
    public String img;
    public String sound;

    public listItem(String title, String img, String sound) {
        Title = title;
        this.img = img;
        this.sound = sound;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }
}
