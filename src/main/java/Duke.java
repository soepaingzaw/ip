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

        //new String[numRowsofData]
        String[] tasks= new String[25];
        String[] checks = new String[25];
       // String type[]=new String[25];
        String[] parts;

        int index=0;
        int count;
        int num;

        while(true) {
            tasks[index] = scan.nextLine();
            checks[index] = "[✘]";
            parts = tasks[index].split(" ");//splits string into separate parts

            if(parts[0].equals("done")) {
                System.out.println("Nice! I've marked this task as done:");
                checks[Integer.parseInt(parts[1]) - 1] = "[✓]";
                System.out.println("[✓] " + tasks[Integer.parseInt(parts[1]) - 1]);
            }

            else if (tasks[index].equals("bye")) {
                System.out.println("BYE! See you again!");
                break;
            }

            else if(tasks[index].equals("list")) {
                count = index;
                num = 0;
                while (count != 0) {
                    System.out.println(num + 1 + ". " + checks[num] + " " + tasks[num]);
                    count--;
                    num++;
                }
            }

            //Below code increments index as tasks are being added
            else {

/*
                if(parts[0].equals("todo")){
                    type[index]="[T]";
                    tasks[index]=tasks[index].delete(0,4)];
                }
*/
                for (int i = 0; i < 85; i++) {
                    System.out.print("_");
                }
                System.out.print("\n");


                System.out.println("added: " + tasks[index++]);

                for (int i = 0; i < 85; i++) {
                    System.out.print("_");
                }
                System.out.print("\n");
            }
            
        }
    }
}
