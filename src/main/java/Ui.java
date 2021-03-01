public class Ui {

    public Ui() {
        printWelcomeMessage();
        greetUserForTask();
    }

    public static void printWelcomeMessage() {

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        System.out.print("Hello from\n" + logo);

    }

    public static void greetUserForTask() {
        System.out.print("Hello! I'm Duke\n");
        System.out.print("What can I do for you?\n");

    }

    public static void showLoadingError() {
        System.out.print("Warning!!! No file found to import. Creating new file...\n");
    }
}
