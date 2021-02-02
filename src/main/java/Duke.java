import java.util.Scanner;

public class Duke {

    static final int ITEMS = 25;
    static final int LINES = 85;

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        System.out.println("Hello from\n" + logo);

        for (int i = 0; i < LINES; i++) {
            System.out.print("_");
        }

        System.out.print("\n");
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I  do for you?");

        for (int i = 0; i < LINES; i++) {
            System.out.print("_");
        }

        System.out.print("\n");
        Scanner scan = new Scanner(System.in);

        //new String[numRowsofData]
        String[] tasks= new String[ITEMS];
        String[] checks = new String[ITEMS];
        String[] type=new String[ITEMS];
        String[] deadline=new String[ITEMS];
        String[] parts;

        int index=0;
        int count;
        int num;
        int temp;

        while(true) {

            tasks[index] = scan.nextLine();
            checks[index] = "[ ]";
            parts = tasks[index].split(" ");//splits string into separate parts

            if(parts[0].equals("done")) {
                temp=Integer.parseInt(parts[1]) - 1;
                System.out.println("Nice! I've marked this task as done:");
                checks[temp] = "[✓]";
                System.out.println(type[temp] + checks[temp] + " " + tasks[temp]);
            }

            else if (tasks[index].equals("bye")) {
                System.out.println("BYE! See you again!");
                break;
            }

            else if(tasks[index].equals("list")) {
                count = index;
                num = 0;

                while (count != 0) {

                    System.out.println(num + 1 + ". " +
                            type[num]+ checks[num] + " " + tasks[num]
                    +deadline[num]);
                    count--;
                    num++;
                }
            }

            //Below code increments index as tasks are being added
            else {

                //initialise deadline as empty space
                deadline[index]=" ";

                if(parts[0].equals("todo")){
                    //substring to extract out string in concern
                    tasks[index] = tasks[index].substring(5, tasks[index].length());
                    type[index]="[T]";
                }

                else if(parts[0].equals("deadline")){

                    tasks[index] = tasks[index].substring(9, tasks[index].length());

                    type[index]="[D]";

                    temp=tasks[index].indexOf('/');

                    deadline[index]="(by:"+tasks[index].substring(temp+3,
                            tasks[index].length()) + ")";
                    tasks[index]=tasks[index].substring(0, temp);

                }
                else if(parts[0].equals("event")){

                    tasks[index] = tasks[index].substring(6, tasks[index].length());

                    type[index]="[E]";

                    temp=tasks[index].indexOf('/');

                    deadline[index]="(at:"+tasks[index].substring(temp+3,
                            tasks[index].length()) + ")";
                    tasks[index]=tasks[index].substring(0, temp);

                }

                for (int i = 0; i < LINES; i++) {
                    System.out.print("_");
                }

                System.out.print("\n");

                System.out.println("Got it. I've added this task:\n  "
                        + type[index] + checks[index] + " "
                        + tasks[index] + " " + deadline[index++] +"\n"
                + "Now you have " + index + " task(s) in the list"  );

                for (int i = 0; i < LINES; i++) {
                    System.out.print("_");
                }

                System.out.print("\n");

            }
        }
    }
}
