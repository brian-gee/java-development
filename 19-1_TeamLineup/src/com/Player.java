package com;

public class Player {
    private String playerName;
    private String playerPosition;


    public Player(){
        this("", "");

    }

    public Player(String playerName, String playerPosition){
        this.playerName = playerName;
        this.playerPosition = playerPosition;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(String playerPosition) {
        this.playerPosition = playerPosition;
    }

    public int getPositionIndex(Player p) {
        int i = 0;
        switch (p.getPlayerPosition()) {
            case "(home team)":
                i = 0;
                break;
            case "(visitor team)":
            case "Pitcher":
                i = 1;
                break;
            case "Catcher":
                i = 2;
                break;
            case "First base":
                i = 3;
                break;
            case "Second base":
                i = 4;
                break;
            case "Third base":
                i = 5;
                break;
            case "Short stop":
                i = 6;
                break;
            case "Left field":
                i = 7;
                break;
            case "Center field":
                i = 8;
                break;
            case "Right field":
                i = 9;
                break;
        }
        return i;
    }
}