import java.util.Scanner;

public class Duke {

    static final int LINES = 85;
    static final int INPUTS = 100;

    public static Task[] tasks = new Task[INPUTS];

    public static void main(String[] args) {

        printWelcomeMessage();
        printDivider();
        greetUserForTask();
        receiveInputs();

    }

    public static void printWelcomeMessage() {

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        System.out.print("Hello from\n" + logo);

    }

    public static void printDivider() {
        for (int i = 0; i < LINES; i++) {
            System.out.print("_");
        }
        System.out.print("\n");

    }

    public static void greetUserForTask() {
        System.out.print("Hello! I'm Duke\n");
        System.out.print("What can I do for you?\n");

    }

    public static void receiveInputs() {

        int index = 0;
        int done = 0;

        while (true) {

            Scanner scan = new Scanner(System.in);
            String line = scan.nextLine();

            if (line.equals("bye")) {
                System.out.print("Bye. Hope to see you again soon!\n");
                break;
            } else if (line.startsWith("done")) {
                done = Integer.parseInt(line.substring(5));
                tasks[done-1].markAsDone();
                System.out.print("Nice! I've marked this task as done:\n" +
                        tasks[done-1].print());

            } else if (line.equals("list")) {
                System.out.print("Here are the tasks in your list:\n");
                for (int i = 0; i < index; i++) {
                    System.out.printf("%d." + tasks[i].print(),i+1);
                }
            } else {

                tasks[index++] = new Task(line);
            }

        }

    }
}



