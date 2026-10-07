import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            ReadFile fileRes = new ReadFile("data/GettysburgAddress.txt");
            ArrayList<String> lines = fileRes.getLines();

            List<Paragraph> paragraphs = parseParagraphs(lines);

            // print all paragraphs
            printParagraphs(paragraphs);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static List<Paragraph> parseParagraphs(List<String> lines) {
        List<Paragraph> paragraphs = new ArrayList<>();
        Paragraph currentParagraph = new Paragraph();

        for (String line : lines) {
            // when line is empty, add current paragraph to ArrayList and create a new paragraph
            if (line.isEmpty()) {
                if (!currentParagraph.isEmpty()) {
                    paragraphs.add(currentParagraph);
                    currentParagraph = new Paragraph();
                }
            } else {
                // split at space to create a string of words
                String[] words = line.split(" ");
                for (String word : words) {
                    currentParagraph.addWord(word);
                }
            }
        }

        // Save the final paragraph if the file doesn't end with an empty line
        if (!currentParagraph.isEmpty()) {
            paragraphs.add(currentParagraph);
        }

        return paragraphs;
    }

    private static void printParagraphs(List<Paragraph> paragraphs) {
        int paragraphNum = 1;
        for (Paragraph p : paragraphs) {
            String paragraphText = String.join(" ", p.getWords());
            int wordCount = p.getWords().size();

            System.out.println("Paragraph " + paragraphNum + ": " + paragraphText);
            System.out.println("Word Count: " + wordCount);
            System.out.println();
            paragraphNum = paragraphNum + 1;
        }
    }
}