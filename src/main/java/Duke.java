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
        String checks[] = new String[100];

        int j=0;

        while(true) {
            arr[j] = scan.nextLine();
            checks[j] = "[✘]";
            String[] parts = arr[j].split(" ");

            if(parts[0].equals("done")){
                System.out.println("Nice! I've marked this task as done:");
                checks[Integer.parseInt(parts[1])-1] = "[✓]";
                System.out.println("[✓] "+ arr[Integer.parseInt(parts[1])-1]);
            }

            else if (arr[j].equals("bye")) {
                System.out.println("BYE! See you again!");
                break;
            }

            else if(arr[j].equals("list")) {
                int a = j;
                int b = 0;
                while (a != 0) {
                    System.out.println(b + 1 + ". " + checks[b] + " " + arr[b]);
                    a--;
                    b++;
                }
            }

            else {

                for (int i = 0; i < 85; i++) {
                    System.out.print("_");
                }
                System.out.print("\n");

                System.out.println("added: " + arr[j++]);

                for (int i = 0; i < 85; i++) {
                    System.out.print("_");
                }
                System.out.print("\n");
            }
            
        }
    }
}
