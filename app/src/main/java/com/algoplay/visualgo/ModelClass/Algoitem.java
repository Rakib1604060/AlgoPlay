package com.algoplay.visualgo.ModelClass;

public class Algoitem {
    int value;
    String itemvalue;
    int colorcode;

    public Algoitem(int value, String itemvalue, int colorcode) {
        this.value = value;
        this.itemvalue = itemvalue;
        this.colorcode = colorcode;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getItemvalue() {
        return itemvalue;
    }

    public void setItemvalue(String itemvalue) {
        this.itemvalue = itemvalue;
    }

    public int getColorcode() {
        return colorcode;
    }

    public void setColorcode(int colorcode) {
        this.colorcode = colorcode;
    }
}
