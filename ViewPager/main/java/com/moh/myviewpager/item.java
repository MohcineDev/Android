package com.moh.myviewpager;

public class item {
    String string;
    int anInt;

    public item(String string, int anInt) {
        this.string = string;
        this.anInt = anInt;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public int getAnInt() {
        return anInt;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }
}
