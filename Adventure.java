import java.util.Arrays;
import java.util.Scanner;

import java.lang.System;
import java.util.HashMap;

public class Adventure {
    /**
     * Adventure class Part 1. Demonstrates the following: Using Scanner class for
     * text input, String n
     */
    static String[] inventory = new String[4];
    static boolean quitProgram = false; // changed to true when exit entered

    public static void main(String[] args) {
        int[][] position = new int[0][0]; // coordinates of player

        String[] valid_commands = new String[3];
        valid_commands[0] = "go";
        valid_commands[1] = "inventory";
        valid_commands[2] = "quit";

        Adventure.inventory[0] = "brass lantern";
        Adventure.inventory[1] = "rope";
        Adventure.inventory[2] = "rations";
        Adventure.inventory[3] = "staff";

        Scanner scanner = new Scanner(System.in); // Start user input
        String input = "";

        do {
            System.out.println("What will you do next?");
            input = scanner.nextLine();
            while (!check(valid_commands, input)) {
                System.out.printf("\"%s\" is not a valid command. Enter a valid command \n", input);
                input = scanner.nextLine();
            }

            String command = input;
            String[] arrOfCommands = command.split("\\s+");
            runCommand(arrOfCommands);

        } while (!quitProgram);

        System.out.println("program exited");
    }

    public static void runCommand(String[] command) {
        String cm = command[0].toLowerCase();
        char firstChar = cm.charAt(0);

        if (firstChar == 'g') {
            go(command[0]);
        } else if (firstChar == 'i') {
            printInventory();
        } else if (firstChar == 'q') {
            quit();
        }
    }

    public static void quit() {
        quitProgram = true;
    }

    public static void go(String direction) {

    }

    public static void printInventory() {
        for (int i = 0; i < Adventure.inventory.length; i++) {
            System.out.printf(inventory[i] + "\n");
        }
    }

    private static boolean check(String[] arr, String element) {
        String[] arrOfEl = element.split("\\s+");
        HashMap<Character, String> comms = new HashMap<Character, String>();

        String cm = arrOfEl[0].toLowerCase();
        char firstChar = cm.charAt(0);
        boolean validCommand = false;

        if (firstChar == 'g') {
            validCommand = true;
        } else if (firstChar == 'i') {
            validCommand = true;
        } else if (firstChar == 'q') {
            validCommand = true;
        }

        return validCommand;
    }
}