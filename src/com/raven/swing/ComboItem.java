package com.raven.swing;

public class ComboItem {
    private final String id;
    private final String name;

    public ComboItem(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return name; // This is what will be displayed in the combo box
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
