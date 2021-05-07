package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Collections;
import java.util.List;

public class GroceryListApp extends JDialog {
    private JPanel contentPane;
    private JButton clearButton;
    private JList groceryList;
    private JTextField itemTextField;
    private JButton addButton;
    private JLabel itemLabel;
    private JLabel listLabel;
    private JButton removeButton;
    DefaultListModel model = (DefaultListModel) groceryList.getModel();
    GroceryListTextFile gl = new GroceryListTextFile();
    private List<Item> items = gl.getAll();

    public GroceryListApp() {
        Collections.reverse(items);
        for (Item i : items) {
            model.add(0, i.getName());
        }
        setContentPane(contentPane);
        setModal(true);
        addButton.addActionListener(e -> onAdd());
        removeButton.addActionListener(e -> onRemove());
        clearButton.addActionListener(e -> onClear());

        // make enter key run onAdd
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onAdd();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        // make backspace key run onRemove
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onRemove();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

    }

    private void onAdd() {
        if (!itemTextField.getText().strip().equals("")) {
            model.add(0, itemTextField.getText());
            itemTextField.setText("");
            saveFile();
        } else {
            JOptionPane.showMessageDialog(null, "You must type in an item to add.");
            itemTextField.setText("");
        }
    }

    private void onRemove() {
        while(groceryList.getSelectedIndex() > -1) {
            model.remove(groceryList.getSelectedIndex());
            saveFile();
        }
        if (groceryList.getSelectedIndex() <= -1) {
            JOptionPane.showMessageDialog(null, "You must select an item to remove.");
        }
    }

    private void onClear() {
        model.removeAllElements();
        saveFile();
    }

    private void saveFile() {
        String s = "";
        for (int i = 0; i < model.getSize(); i++) {
            s = s + model.get(i).toString() + "\n";
        }
        gl.saveAll(s);
    }


    public static void main(String[] args) {
        GroceryListApp dialog = new GroceryListApp();
        dialog.pack();
        dialog.setSize(new Dimension(280, 250));
        dialog.setVisible(true);
        System.exit(0);
        dialog.dispose();
    }
}