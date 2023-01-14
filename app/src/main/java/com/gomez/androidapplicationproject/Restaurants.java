package com.gomez.androidapplicationproject;

public class Restaurants {
    private Integer res_id;
    private String res_name;

    public Restaurants(Integer res_id, String res_name) {
        this.res_id = res_id;
        this.res_name = res_name;
    }

    @Override
    public String toString() {
        return "Restaurants{" +
                "res_id=" + res_id +
                ", res_name='" + res_name + '\'' +
                '}';
    }

    public Integer getRes_id() {
        return res_id;
    }

    public void setRes_id(Integer res_id) {
        this.res_id = res_id;
    }

    public String getRes_name() {
        return res_name;
    }

    public void setRes_name(String res_name) {
        this.res_name = res_name;
    }
}
