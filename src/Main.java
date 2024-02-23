import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        SavedFile save = new SavedFile("words.txt");

        String currentRecord = "";
        ArrayList<String> input = save.Read();
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).length() > currentRecord.length()) {
                currentRecord = input.get(i);
            }
        }

        System.out.println(currentRecord);
    }
}