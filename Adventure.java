import java.util.Arrays;
import java.util.Scanner;
import java.lang.System;

public class Adventure {
    /**
     * Adventure class Part 1. Demonstrates the following: Using Scanner class for
     * text input, String n
     */
    static String[] inventory = new String[10];

    public static void main(String[] args) {
        boolean exitProgram = false; // changed to true when exit entered
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
        String command = "";

        do {
            System.out.println("Enter a command");
            while (!check(valid_commands, scanner.nextLine())) {
                String input = scanner.next();
                System.out.printf("\"%s\" is not a valid command. \n", input);
            }

            command = scanner.nextLine();
            String[] arrOfCommands = command.split("\\s+");
            runCommand(arrOfCommands);

        } while (!exitProgram);

        System.out.println(command);

    }

    public static void runCommand(String[] command) {
        String cm = command[0];
        if (cm == "go") {
            go(command[0]);
        } else if (cm == "inventory") {
            printInventory();
        }
    }

    public void exit(boolean exitProgram) {
        exitProgram = true;
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
        // System.out.print(arrOfEl[0] + element + "\n");
        System.out.print(Arrays.asList(arr));
        boolean validCommand = Arrays.asList(arr).stream().anyMatch(arrOfEl[0]);
        System.out.print(Arrays.asList(arr));
        return validCommand;
    }
}