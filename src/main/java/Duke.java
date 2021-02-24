import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Duke {

    static final int LINES = 85;
    public static int index = 0;
    public static String line;
    public static boolean continueInputs = true;
    public static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {

        printWelcomeMessage();
        printDivider();
        greetUserForTask();

        try{
            loadFromFile("mytasks.txt");
        } catch (FileNotFoundException e) {
            System.out.print("Warning!!! No file found to import. Creating new file...\n");
        }
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
                    System.out.print("Here are the tasks in your list:\n" + list());
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

                default:
                    throw new DukeException();
                }

                writeToFile();

            } catch (DukeException e) {
                System.out.print(e.getMessage());
            } catch (IOException e) {
                System.out.print("File ERRORRR!!\n");
            }


        } while (continueInputs);

    }

    public static void todo() throws DukeException {
        if (line.length() == 4) {
            throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.\n");
        }
        tasks.add(new Todo(line.substring(5)));
        addToTaskMessage();
        printNumberOfTask();
    }

    public static void deadline() throws DukeException {
        int indexOfSlash = line.indexOf('/');
        if (line.length() == 8) {
            throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.\n");
        } else if (!(indexOfSlash > -1)) {
            throw new DukeException("☹ ERROR!! Please input TASK, DAY and TIME using the following format:\n" +
                    "deadline [TASK] /by [DAY] [TIME].\n");
        }

        tasks.add(new Deadline(line.substring(9, indexOfSlash), line.substring(indexOfSlash + 3)));
        addToTaskMessage();
        printNumberOfTask();
    }

    public static void event() throws DukeException {
        int indexOfSlash = line.indexOf('/');
        if (line.length() == 5) {
            throw new DukeException("☹ OOPS!!! The description of a event cannot be empty.\n");
        } else if (!(indexOfSlash > -1)) {
            throw new DukeException("☹ ERROR!! Please input TASK, DAY and TIME using the following format:\n" +
                    "event [TASK] /at [DAY] [TIME].\n");
        }

        tasks.add(new Event(line.substring(6, indexOfSlash), line.substring(indexOfSlash + 3)));
        addToTaskMessage();
        printNumberOfTask();
    }


    public static String list() {
        StringBuilder listOfTasks = new StringBuilder();
        for (int i = 0; i < index; i++) {
            listOfTasks.append(i + 1).append(".").append(tasks.get(i).toString()).append("\n");
        }

        return listOfTasks.toString();
    }

    public static void done() {
        int order = Integer.parseInt(line.substring(5));
        tasks.get(order - 1).markAsDone();
        System.out.print("Nice! I've marked this task as done:\n" +
                tasks.get(order - 1).toString() + "\n");
    }

    public static void bye() {
        System.out.print("Bye. Hope to see you again soon!\n");
        continueInputs = false;
    }

    public static void addToTaskMessage() {
        index++;
        System.out.print("Got it! I have added this task:\n" + tasks.get(index - 1).toString() + "\n");
    }

    public static void printNumberOfTask() {
        System.out.printf("Now you have %d task(s) in the list.\n", index);
    }

    public static void writeToFile() throws IOException {
        FileWriter fw = new FileWriter("mytasks.txt");
        fw.write(list());
        fw.close();
    }

    public static void loadFromFile(String filepath) throws FileNotFoundException {
        File f = new File(filepath);
        Scanner scan = new Scanner(f);

        while (scan.hasNext()) {
            String textString = scan.nextLine();
            char taskType = textString.charAt(3);
            char doneOrNot = textString.charAt(6);
            int indexOfOpenBracket = textString.indexOf('(');
            int indexOfCloseBracket = textString.indexOf(')');

            switch (taskType) {

            case 'T':
                tasks.add(new Todo(textString.substring(9)));
                break;
            case 'E':
                tasks.add(new Event(textString.substring(9, indexOfOpenBracket),
                        textString.substring(indexOfOpenBracket + 4, indexOfCloseBracket)));
                break;
            case 'D':
                tasks.add(new Deadline(textString.substring(9, indexOfOpenBracket),
                        textString.substring(indexOfOpenBracket + 4, indexOfCloseBracket)));
                break;
            default:
                break;
            }

            if (doneOrNot == '\u2713') {
                tasks.get(index).markAsDone();
            }
            index++;
        }
    }
}




