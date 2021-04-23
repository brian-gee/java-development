package com;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;


@SuppressWarnings("serial")
class StudentRegistrationApp extends JFrame {

    private JTextField firstName;
    private JTextField lastName;
    private JTextField yearOfBirth;
    private JTextField temporaryPassword;
    private JLabel printLabel;

    public StudentRegistrationApp() {
        initComponents();
    }

    private void initComponents() {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException |
                IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.println(e);
        }

        setTitle("Student Registration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        firstName = new JTextField();
        lastName = new JTextField();
        yearOfBirth = new JTextField();
        temporaryPassword = new JTextField();
        temporaryPassword.setEditable(false);
        printLabel = new JLabel();

        Dimension dim = new Dimension(155, 20);
        firstName.setPreferredSize(dim);
        lastName.setPreferredSize(dim);
        yearOfBirth.setPreferredSize(dim);
        temporaryPassword.setPreferredSize(dim);
        printLabel.setPreferredSize(dim);
        firstName.setMinimumSize(dim);
        lastName.setMinimumSize(dim);
        yearOfBirth.setMinimumSize(dim);
        temporaryPassword.setMinimumSize(dim);
        printLabel.setMinimumSize(dim);



        JButton calculateButton = new JButton("Register");
        JButton exitButton = new JButton("Exit");

        calculateButton.addActionListener(e -> registerButtonClicked());
        exitButton.addActionListener(e -> exitButtonClicked());

        // button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(calculateButton);
        buttonPanel.add(exitButton);

        // main panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.add(new JLabel("First Name:"), getConstraints(0, 0));
        panel.add(firstName, getConstraints(1, 0));
        panel.add(new JLabel("Last Name:"), getConstraints(0, 1));
        panel.add(lastName, getConstraints(1, 1));
        panel.add(new JLabel("Year of Birth:"), getConstraints(0, 2));
        panel.add(yearOfBirth, getConstraints(1, 2));
        panel.add(new JLabel("Temporary Password:"), getConstraints(0, 3));
        panel.add(temporaryPassword, getConstraints(1, 3));
        GridBagConstraints label = getConstraints(0, 4);
        label.gridwidth = 2;
        label.fill = GridBagConstraints.HORIZONTAL;
        panel.add(printLabel, label);

        // add button panel to last row of main panel
        GridBagConstraints c = getConstraints(0, 5);
        c.anchor = GridBagConstraints.LINE_END;
        c.gridwidth = 2;
        panel.add(buttonPanel, c);

        add(panel, BorderLayout.CENTER);

        setSize(new Dimension(320, 180));
        setVisible(true);
    }

    // helper method for getting a GridBagConstraints object
    private GridBagConstraints getConstraints(int x, int y) {
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(5, 5, 0, 5);
        c.gridx = x;
        c.gridy = y;
        return c;
    }

    private void registerButtonClicked() {
        SwingValidator sv = new SwingValidator(this);
        if (sv.isPresent(firstName, "First Name") &&
                sv.isPresent(lastName, "Last Name") &&
                sv.isPresent(yearOfBirth, "Year of Birth")) {

            String f = firstName.getText();
            String l = lastName.getText();
            String y = yearOfBirth.getText();


            temporaryPassword.setText(f + "*" + y);
            printLabel.setText("Welcome " + f + " " + l + "!");
        } else {
            temporaryPassword.setText("");
            printLabel.setText("Please enter first name, last name, and year of birth.");
        }
    }

    private void exitButtonClicked() {
        System.exit(0);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            @SuppressWarnings("unused")
            JFrame frame = new StudentRegistrationApp();
        });
    }
}