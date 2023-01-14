package com.gomez.androidapplicationproject;

public class Menu {
    private Integer menu_id, item_id;

    public Menu(){

    }

    @Override
    public String toString() {
        return "Menu{" +
                "menu_id=" + menu_id +
                ", item_id=" + item_id +
                '}';
    }

    public Integer getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(Integer menu_id) {
        this.menu_id = menu_id;
    }

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }
}

