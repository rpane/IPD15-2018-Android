package com.example.roberto.listview;

public class Drink {

    private String name;
    private String description;
    private int imageResourceId;

    public Drink(String name, String description, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public static final Drink[] drinks = {
            new Drink("Latte","A couple of espressp shotts with steamed milk", R.drawable.latte),
            new Drink("Cappucino", "Espresso, hot milk and a steamed milk foam",R.drawable.cappucino),
            new Drink("Filter","Highest quality beans rested and brewed fresh",R.drawable.filter2)
    };
}
