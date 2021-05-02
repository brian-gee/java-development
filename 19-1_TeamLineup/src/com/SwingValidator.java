package com;

import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

public class SwingValidator {
    private final Component parentComponent;

    public SwingValidator(Component parent) {
        this.parentComponent = parent;
    }

    private void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(parentComponent, message,
                "Invalid Entry", JOptionPane.ERROR_MESSAGE);
    }

    public boolean isPresent(JTextComponent c) {
        if (c.getText().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isInteger(JTextComponent c) {
        try {
            Integer.parseInt(c.getText());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isDouble(JTextComponent c) {
        try {
            Double.parseDouble(c.getText());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}