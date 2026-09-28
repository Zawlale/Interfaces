import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ShortLister {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(null);

        if (result != JFileChooser.APPROVE_OPTION) {
            System.out.println("No file selected.");
            return;
        }

        File file = chooser.getSelectedFile();
        Filter filter = new ShortWordFilter();
        int count = 0;

        System.out.println("Short words in " + file.getName() + ":");

        try (Scanner input = new Scanner(file)) {
            input.useDelimiter("[^\\p{L}]+");

            while (input.hasNext()) {
                String word = input.next();

                if (filter.accept(word)) {
                    System.out.println(word + " (" + word.length() + " letters)");
                    count++;
                }
            }

            System.out.println("Total short words: " + count);
        } catch (FileNotFoundException e) {
            System.out.println("Could not open the selected file.");
        }
    }
}