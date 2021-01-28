
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        for (int i = 0; i < 85; i++) {
            System.out.print("_");

        }
        System.out.print("\n");
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I  do for you?");
        for (int i = 0; i < 85; i++) {
            System.out.print("_");

        }
        System.out.print("\n");

        Scanner scan = new Scanner(System.in);

        String arr[]= new String[100];

        int j=0;

        while(true) {


            arr[j] = scan.nextLine();

            if (arr[j].equals("bye")) {
                System.out.println("BYE! See you again!");
                break;
            }
            /*
            else if(arr[j].equals("list")) {
                int a = j;
                int b = 0;
                while (a != 0) {
                    System.out.println(b + 1 + ". " + arr[b++]);
                    a--;
                }

            }

             */
            else {
                for (int i = 0; i < 85; i++) {
                    System.out.print("_");
                }
                System.out.print("\n");

                System.out.println(arr[j++]);
                //System.out.println("added:" + arr[j++]);
                for (int i = 0; i < 85; i++) {
                    System.out.print("_");
                }
                System.out.print("\n");
            }
        }
    }
}
