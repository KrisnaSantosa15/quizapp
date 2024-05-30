package com.raven.swing;

import javax.swing.JComboBox;

public class ComboItem {
    private String id;
    private String name;

    public ComboItem(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name; // This will display the name in the combo box
    }
    
    public static String getSelectedId(JComboBox<ComboItem> comboBox) {
        ComboItem selectedItem = (ComboItem) comboBox.getSelectedItem();
        if (selectedItem != null) {
            return selectedItem.getId();
        }
        return null;
    }
    
    public static void setComboBoxSelectedItem(JComboBox<ComboItem> comboBox, String id) {
    for (int i = 0; i < comboBox.getItemCount(); i++) {
        ComboItem item = comboBox.getItemAt(i);
        if (item.getId().equals(id)) {
            comboBox.setSelectedItem(item);
            return;
        }
    }
}
}