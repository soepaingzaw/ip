import java.util.Scanner;

public class Duke {

    static final int LINES = 85;

    public static void main(String[] args) {

        printWelcomeMessage();
        printDivider();



    }

    public static void printWelcomeMessage() {

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        System.out.println("Hello from\n" + logo);


    }

    public static void printDivider() {
        for (int i = 0; i < LINES; i++) {
            System.out.print("_");
        }

    }



}
