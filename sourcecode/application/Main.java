package application;

import application.controllers.MainScreenController;

public class Main {
    public static MainScreenController mainMenu;
    public static void main(String[] args) {
        showMainMenu();
    }

    public static void showMainMenu(){
        mainMenu = new MainScreenController();
    }
 }
