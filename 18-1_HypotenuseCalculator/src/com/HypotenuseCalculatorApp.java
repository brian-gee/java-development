package com;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


@SuppressWarnings("serial")
class HypotenuseCalculatorApp extends JFrame {

    private JTextField sideA;
    private JTextField sideB;
    private JTextField sideC;

    public HypotenuseCalculatorApp() {
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

        setTitle("Right Triangles");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        sideA = new JTextField();
        sideB = new JTextField();
        sideC = new JTextField();

        Dimension dim = new Dimension(150, 20);
        sideA.setPreferredSize(dim);
        sideB.setPreferredSize(dim);
        sideC.setPreferredSize(dim);
        sideA.setMinimumSize(dim);
        sideB.setMinimumSize(dim);
        sideC.setMinimumSize(dim);

        JButton calculateButton = new JButton("Calculate");
        JButton exitButton = new JButton("Exit");

        calculateButton.addActionListener(e -> calculateButtonClicked());
        exitButton.addActionListener(e -> exitButtonClicked());

        // button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(calculateButton);
        buttonPanel.add(exitButton);

        // main panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.add(new JLabel("Side A:"), getConstraints(0, 0));
        panel.add(sideA, getConstraints(1, 0));
        panel.add(new JLabel("Side B:"), getConstraints(0, 1));
        panel.add(sideB, getConstraints(1, 1));
        panel.add(new JLabel("Side C:"), getConstraints(0, 2));
        panel.add(sideC, getConstraints(1, 2));

        // add button panel to last row of main panel
        GridBagConstraints c = getConstraints(0, 4);
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

    private void calculateButtonClicked() {
        SwingValidator sv = new SwingValidator(this);
        if (sv.isPresent(sideA, "Side A") &&
                sv.isDouble(sideA, "SideA") &&
                sv.isPresent(sideB, "Side B") &&
                sv.isDouble(sideB, "Side B")) {

            double a = Double.parseDouble(sideA.getText());
            double b = Double.parseDouble(sideB.getText());

            String pattern="#.###";
            DecimalFormat df = new DecimalFormat(pattern);
            double c = Math.sqrt((Math.pow(a, 2)) + (Math.pow(b, 2)));
            String formattedC = df.format(c);

            sideC.setText(formattedC);
        }
    }

    private void exitButtonClicked() {
        System.exit(0);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            @SuppressWarnings("unused")
            JFrame frame = new HypotenuseCalculatorApp();
        });
    }
}