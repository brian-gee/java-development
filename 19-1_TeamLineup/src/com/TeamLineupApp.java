package com;

import java.awt.*;
import java.util.List;
import javax.swing.*;

@SuppressWarnings("serial")
public class TeamLineupApp extends JFrame {
    private static TeamLineupTextFile tl = new TeamLineupTextFile();
    private static List<Player> players = tl.getAll();


    private JTextField teamNameField;
    private JRadioButton homeRadioButton;
    private JRadioButton visitorRadioButton;
    private JTextField player1;
    private JTextField player2;
    private JTextField player3;
    private JTextField player4;
    private JTextField player5;
    private JTextField player6;
    private JTextField player7;
    private JTextField player8;
    private JTextField player9;
    private JComboBox<String> position1;
    private JComboBox<String> position2;
    private JComboBox<String> position3;
    private JComboBox<String> position4;
    private JComboBox<String> position5;
    private JComboBox<String> position6;
    private JComboBox<String> position7;
    private JComboBox<String> position8;
    private JComboBox<String> position9;




    public TeamLineupApp() {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException |
                IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.println(e);
        }
        initComponents();
    }

    private void initComponents() {
        setTitle("Lineup");
        setLocationByPlatform(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        homeRadioButton = new JRadioButton("Home");
        homeRadioButton.setSelected(true);
        visitorRadioButton = new JRadioButton("Visitor");
        teamNameField = new JTextField();
        teamNameField.setPreferredSize(new Dimension(150, 20));

        ButtonGroup sizeGroup = new ButtonGroup();
        sizeGroup.add(homeRadioButton);
        sizeGroup.add(visitorRadioButton);

        JPanel teamInfoPanel = new JPanel();
        teamInfoPanel.setBorder(BorderFactory.createTitledBorder("Team Information"));
        teamInfoPanel.setLayout(new FlowLayout());
        teamInfoPanel.add(new JLabel("Team name:"));
        teamInfoPanel.add(teamNameField);
        teamInfoPanel.add(homeRadioButton);
        teamInfoPanel.add(visitorRadioButton);

        player1 = new JTextField();
        player2 = new JTextField();
        player3 = new JTextField();
        player4 = new JTextField();
        player5 = new JTextField();
        player6 = new JTextField();
        player7 = new JTextField();
        player8 = new JTextField();
        player9 = new JTextField();

        String[] positions = {"Choose a selection", "Pitcher", "Catcher", "First base",
                "Second base", "Third base", "Short stop", "Left field", "Center field", "Right field"};
        position1 = new JComboBox(positions);
        position2 = new JComboBox(positions);
        position3 = new JComboBox(positions);
        position4 = new JComboBox(positions);
        position5 = new JComboBox(positions);
        position6 = new JComboBox(positions);
        position7 = new JComboBox(positions);
        position8 = new JComboBox(positions);
        position9 = new JComboBox(positions);


        // set the correct length for textField
        Dimension dim = new Dimension(170, 20);
        player1.setPreferredSize(dim);
        player2.setPreferredSize(dim);
        player3.setPreferredSize(dim);
        player4.setPreferredSize(dim);
        player5.setPreferredSize(dim);
        player6.setPreferredSize(dim);
        player7.setPreferredSize(dim);
        player8.setPreferredSize(dim);
        player9.setPreferredSize(dim);

        // add all components to the playerPanel
        JPanel playerPanel = new JPanel();
        playerPanel.setLayout(new GridBagLayout());
        playerPanel.add(new JLabel("1:"), getConstraints(0,0));
        playerPanel.add(player1, getConstraints(1,0));
        playerPanel.add(position1, getConstraints(2,0));
        playerPanel.add(new JLabel("2:"), getConstraints(0,1));
        playerPanel.add(player2, getConstraints(1,1));
        playerPanel.add(position2, getConstraints(2,1));
        playerPanel.add(new JLabel("3:"), getConstraints(0,2));
        playerPanel.add(player3, getConstraints(1,2));
        playerPanel.add(position3, getConstraints(2,2));
        playerPanel.add(new JLabel("4:"), getConstraints(0,3));
        playerPanel.add(player4, getConstraints(1,3));
        playerPanel.add(position4, getConstraints(2,3));
        playerPanel.add(new JLabel("5:"), getConstraints(0,4));
        playerPanel.add(player5, getConstraints(1,4));
        playerPanel.add(position5, getConstraints(2,4));
        playerPanel.add(new JLabel("6:"), getConstraints(0,5));
        playerPanel.add(player6, getConstraints(1,5));
        playerPanel.add(position6, getConstraints(2,5));
        playerPanel.add(new JLabel("7:"), getConstraints(0,6));
        playerPanel.add(player7, getConstraints(1,6));
        playerPanel.add(position7, getConstraints(2,6));
        playerPanel.add(new JLabel("8:"), getConstraints(0,7));
        playerPanel.add(player8, getConstraints(1,7));
        playerPanel.add(position8, getConstraints(2,7));
        playerPanel.add(new JLabel("9:"), getConstraints(0,8));
        playerPanel.add(player9, getConstraints(1,8));
        playerPanel.add(position9, getConstraints(2,8));

        JButton acceptButton = new JButton("Accept");
        acceptButton.addActionListener(e -> {
            acceptButtonClicked();
        });
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> {
            exitButtonClicked();
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(acceptButton);
        buttonPanel.add(exitButton);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(teamInfoPanel);
        panel.add(playerPanel);

        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setSize(380, 350);

        readLineup();

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

    private void acceptButtonClicked() {
        SwingValidator sv = new SwingValidator(this);
        if (sv.isPresent(teamNameField) && sv.isPresent(player1) &&
                sv.isPresent(player2) && sv.isPresent(player3) &&
                sv.isPresent(player4) && sv.isPresent(player5) &&
                sv.isPresent(player6) && sv.isPresent(player7) &&
                sv.isPresent(player8) && sv.isPresent(player9)){
            String team = "";
            if (homeRadioButton.isSelected()) {
                team = "home";
            } else if (visitorRadioButton.isSelected()) {
                team = "visitor";
            }

            // validate that no positions are the same
            Boolean valid = true;
            JComboBox[] positions = {position1, position2, position3, position4,
                    position5, position6, position7, position8, position9};
            for (int i = 0; i < positions.length; i++)
                for (int j = i+1; j < positions.length; j++) {
                    if (positions[i].getSelectedItem().equals(positions[j].getSelectedItem())) {
                        valid = false;
                    }
                }

            // if all fields are entered and no positions are the same
            if (valid) {
                String output = teamNameField.getText() + ", (" + team + " team)\n" +
                        player1.getText() + ", " + position1.getSelectedItem().toString() + "\n" +
                        player2.getText() + ", " + position2.getSelectedItem().toString() + "\n" +
                        player3.getText() + ", " + position3.getSelectedItem().toString() + "\n" +
                        player4.getText() + ", " + position4.getSelectedItem().toString() + "\n" +
                        player5.getText() + ", " + position5.getSelectedItem().toString() + "\n" +
                        player6.getText() + ", " + position6.getSelectedItem().toString() + "\n" +
                        player7.getText() + ", " + position7.getSelectedItem().toString() + "\n" +
                        player8.getText() + ", " + position8.getSelectedItem().toString() + "\n" +
                        player9.getText() + ", " + position9.getSelectedItem().toString() + "\n";
                JOptionPane.showMessageDialog(null, output);
                tl.saveAll(output);
            } else {
                JOptionPane.showMessageDialog(null, "Positions cannot be the same.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "You must enter all fields.");
        }
    }

    private void exitButtonClicked() {
        System.exit(0);
    }

    private void readLineup() {
        if (!players.isEmpty()) {
            // create teamName as first entry in file
            Player teamName = players.get(0);

            // set team name & home/visitor button
            teamNameField.setText(teamName.getPlayerName());
            if (teamName.getPositionIndex(teamName) == 0) {
                homeRadioButton.setSelected(true);
                visitorRadioButton.setSelected(false);
            } else if (teamName.getPositionIndex(teamName)== 1) {
                homeRadioButton.setSelected(false);
                visitorRadioButton.setSelected(true);
            }
            // set player names & positions
            for (int i = 0; i < 9; i++) {
                JTextField[] playerArray = {player1, player2, player3, player4,
                        player5, player6, player7, player8, player9};
                JComboBox[] positionArray = {position1, position2, position3, position4,
                        position5, position6, position7, position8, position9};
                Player p = players.get(i + 1);
                playerArray[i].setText(p.getPlayerName());
                positionArray[i].setSelectedIndex(p.getPositionIndex(p));
            }
        }
    }


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            TeamLineupApp frame = new TeamLineupApp();
            frame.setVisible(true);
        });
    }
}