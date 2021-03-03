import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Duke {

    static final int LINES = 85;
    static final int LENGTH_OF_TODO = 4;
    static final int LENGTH_OF_DEADLINE = 8;
    static final int LENGTH_OF_EVENT = 5;
    static final int LENGTH_OF_DONE = 4;
    static final int SPACES_AFTER_SLASH = 3;
    static final int LENGTH_OF_DELETE = 6;
    static final int LENGTH_OF_FIND = 4;

    public static int index = 0;
    public static String line;
    public static boolean continueInputs = true;


    public static ArrayList<Task> tasks = new ArrayList<>();

    private Ui ui;



    public Duke(String filePath) {
        ui = new Ui();
        try {
            loadFromFile(filePath);

        } catch (FileNotFoundException e) {
            ui.showLoadingError();

        }

    }

    public static void main(String[] args) {

        new Duke("mytasks.txt").run();
    }

    /**Prints a line divider for every command
     * entered by the user*/
    public static void printDivider() {
        for (int i = 0; i < LINES; i++) {
            System.out.print("_");
        }
        System.out.print("\n");

    }

    /**run the code indefinitely and take in multiple inputs from the user
     * until "bye" is entered*/
    public static void run() {

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
                case "delete":
                    delete();
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

    /**deadline creates a new todo object. The todo class
     * is the subclass of the Task class
     * it takes in the description of the todo
     *
     * @throws DukeException whenever input format is invalid
     */
    public static void todo() throws DukeException {
        if (line.length() == LENGTH_OF_TODO) {
            throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.\n");

        }
        tasks.add(new Todo(line.substring(LENGTH_OF_TODO + 1)));
        addToTaskMessage();
        printNumberOfTask();
    }


    /**deadline creates a new deadline object. The deadline class
     * is the subclass of the Task class
     * it takes in the description of the deadline as well as the
     * Day and time from line
     *
     * @throws DukeException whenever input format is invalid
     */
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

    /**event creates a new Event object. The event class
     * is the subclass of the Task class
     * it takes in the description of the Event as well as the
     * Day and time period from line
     *
     * @throws DukeException whenever input format is invalid
     */
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

    public static String list() {
        StringBuilder listOfTasks = new StringBuilder();
        for (int i = 0; i < index; i++) {
            listOfTasks.append(i + 1).append(".").append(tasks.get(i).toString()).append("\n");
        }

        return listOfTasks.toString();
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

    /**delete and remove task from list
     * based on the numeration given
     */
    public static void delete() {
        int order = Integer.parseInt(line.substring(LENGTH_OF_DELETE + 1));
        System.out.print("Noted. I've removed this task:\n" +
                tasks.get(order - 1).toString() + "\n");

        tasks.remove(order - 1);
        index--;
        printNumberOfTask();
    }



    /**Saves current state of tasks in a textfile
     *
     * @throws IOException as a safe guard
     */
    public static void find() throws DukeException {

        int numeration = 0;
        String listOfTasks;
        String matchingWord = line.substring(LENGTH_OF_FIND + 1);

        ArrayList<String> matchedTask = new ArrayList<>();

        for (int i = 0; i < index; i++) {

            listOfTasks = tasks.get(i).toString();

            if (listOfTasks.contains(matchingWord)) {
                numeration++;
                matchedTask.add(listOfTasks);
            }

        }
        if (numeration == 0) {
            throw new DukeException("There are no matching tasks found\n");
        }
        System.out.print("Here are the matching tasks in your list:\n");

        for (int order = 0; order < numeration; order++) {
            System.out.printf("%d." + matchedTask.get(order) + "\n", order + 1);
        }


    }

    public static void writeToFile() throws IOException {
        FileWriter fw = new FileWriter("mytasks.txt");
        fw.write(list());
        fw.close();
    }

    /**
     * The filepath argument should be a relative {@link String}.
     * When the app is starting, this method finds the file
     * based on the relative filepath and compile them into a list
     * of tasks within program.
     *
     * @param filepath a relative filepath giving the base location of the
     * file to be imported
     * @throws  FileNotFoundException If the file does not exist it throws
     * a warning message
     */
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


