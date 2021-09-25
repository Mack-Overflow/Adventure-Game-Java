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
    static int xPos = 0; // create coordinate system for player
    static int yPos = 0;
    static String[] valid_commands = new String[3];

    public static void main(String[] args) {

        Adventure.valid_commands[0] = "go";
        Adventure.valid_commands[1] = "inventory";
        Adventure.valid_commands[2] = "quit";
        // Adventure.valid_commands[3] = "help";

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
            go(command[1].toLowerCase());
        } else if (firstChar == 'i') {
            printInventory();
        } else if (firstChar == 'q') {
            quit();
        } // else if (firstChar == 'h') {
          // help();
          // }
    }

    public static void quit() {
        quitProgram = true;
    }

    public static void go(String direction) {
        // User enters 'go' followed by direction
        int x = Adventure.xPos;
        int y = Adventure.yPos;

        if (direction.equals("east")) {
            if (x == 5) {
                System.out.println("Can't move East!");
            } else {
                x++;
                System.out.println("Current position: " + x + ", " + y);
            }
        } else if (direction.equals("west")) {
            if (x == 0) {
                System.out.println("Can't move West!");
            } else {
                x--;
                System.out.println("Current position: " + x + ", " + y);
            }
        } else if (direction.equals("north")) {
            if (y == 5) {
                System.out.println("Can't move North!");
            } else {
                y++;
                System.out.println("Current position: " + x + ", " + y);
            }
        } else if (direction.equals("south")) {
            if (y == 0) {
                System.out.println("Can't move South!");
            } else {
                y--;
                System.out.println("Current position: " + x + ", " + y);
            }
        } else {
            System.out.println("You can't go that direction");
        }

        Adventure.xPos = x;
        Adventure.yPos = y;
    }

    public static void printInventory() {
        for (int i = 0; i < Adventure.inventory.length; i++) {
            System.out.printf(inventory[i] + "\n");
        }
    }

    // public static void help() {
    // for (int i = 0; i < Adventure.valid_commands.length; i++) {
    // System.out.print(valid_commands[i]);
    // }
    // }

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