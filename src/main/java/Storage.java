
/*
import java.io.File;
import java.util.Scanner;

public class Storage {

    protected String filepath;

    public Storage(String filepath) {

    }

    public Task load() {
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
*/
