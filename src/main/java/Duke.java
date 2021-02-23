import java.util.Scanner;
import java.util.ArrayList;

public class Duke {

    static final int LINES = 85;
    static final int LENGTH_OF_TODO = 4;
    static final int LENGTH_OF_DEADLINE = 8;
    static final int LENGTH_OF_EVENT = 5;
    static final int LENGTH_OF_DONE = 4;
    static final int SPACES_AFTER_SLASH = 3;
    static final int LENGTH_OF_DELETE = 6;

    public static int index = 0;
    public static String line;
    public static boolean continueInputs = true;

    public static ArrayList<Task> tasks = new ArrayList<>();

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

        do {
            printDivider();

            Scanner scan = new Scanner(System.in);
            line = scan.nextLine();
            String[] word = line.split(" ");

            try {

                switch (word[0]) {

                case "bye":
                    bye();
                    break;
                case "done":
                    done();
                    break;
                case "list":
                    list();
                    break;
                case "todo":
                    todo();
                    break;
                case "deadline":
                    deadline();
                    break;
                case "event":
                    event();
                    break;
                case "delete":
                    delete();
                    break;

                default:
                    throw new DukeException();
                }

            } catch (DukeException e) {
                System.out.print(e.getMessage());
            }


        } while (continueInputs);

    }

    public static void todo() throws DukeException {
        if (line.length() == LENGTH_OF_TODO) {
            throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.\n");

        }
        tasks.add(new Todo(line.substring(LENGTH_OF_TODO + 1)));
        addToTaskMessage();
        printNumberOfTask();
    }

    public static void deadline() throws DukeException {
        int indexOfSlash = line.indexOf('/');

        if (line.length() == LENGTH_OF_DEADLINE) {
            throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.\n");

        } else if (indexOfSlash == -1) {
            throw new DukeException("☹ ERROR!! Please input TASK, DAY and TIME using the following format:\n" +
                    "deadline [TASK] /by [DAY] [TIME].\n");

        }
        tasks.add(new Deadline(line.substring(LENGTH_OF_DEADLINE + 1, indexOfSlash), line.substring(indexOfSlash + SPACES_AFTER_SLASH)));
        addToTaskMessage();
        printNumberOfTask();
    }

    public static void event() throws DukeException {
        int indexOfSlash = line.indexOf('/');
        if (line.length() == LENGTH_OF_EVENT) {
            throw new DukeException("☹ OOPS!!! The description of a event cannot be empty.\n");

        } else if (indexOfSlash == -1) {
            throw new DukeException("☹ ERROR!! Please input TASK, DAY and TIME using the following format:\n" +
                    "event [TASK] /at [DAY] [TIME].\n");

        }

        tasks.add(new Event(line.substring(LENGTH_OF_EVENT + 1, indexOfSlash), line.substring(indexOfSlash + SPACES_AFTER_SLASH)));
        addToTaskMessage();
        printNumberOfTask();
    }

    public static void list() {
        System.out.print("Here are the tasks in your list:\n");

        for (int i = 0; i < index; i++) {
            System.out.printf("%d." + tasks.get(i).toString() + "\n", i + 1);
        }

    }

    public static void done() {
        int order = Integer.parseInt(line.substring(LENGTH_OF_DONE + 1));
        tasks.get(order - 1).markAsDone();
        System.out.print("Nice! I've marked this task as done:\n" +
                tasks.get(order - 1).toString() + "\n");
    }

    public static void bye() {
        System.out.print("Bye. Hope to see you again soon!\n");
        continueInputs = false;
    }

    public static void addToTaskMessage() {
        System.out.print("Got it! I have added this task:\n" + tasks.get(index).toString() + "\n");
        index++;

    }

    public static void printNumberOfTask() {
        System.out.printf("Now you have %d task(s) in the list.\n", index);

    }

    public static void delete() {
        int order = Integer.parseInt(line.substring(LENGTH_OF_DELETE + 1));
        System.out.print("Noted. I've removed this task:\n" +
                tasks.get(order - 1).toString() + "\n");

        tasks.remove(order - 1);
        index--;
        printNumberOfTask();

    }

}



