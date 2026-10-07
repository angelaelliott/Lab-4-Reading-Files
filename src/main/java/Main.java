import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            ReadFile fileRes = new ReadFile("data/GettysburgAddress.txt");
            ArrayList<String> lines = fileRes.getLines();

            List<Paragraph> paragraphs = new ArrayList<>();
            Paragraph currentParagraph = new Paragraph();

            for (String line : lines) {

                // at the end of a paragraph, add current paragraph to the list and move onto a new paragraph
                if (line.isEmpty()) {

                    //check to make sure the paragraph has words
                    if (!currentParagraph.isEmpty()) {
                        paragraphs.add(currentParagraph);
                        currentParagraph = new Paragraph();
                    }
                } else {
                    // split at space to create a string of words
                    String[] words = line.split(" ");
                    for (String word : words) {
                        // add words to the paragraph
                        currentParagraph.addWord(word);
                    }
                }
            }

            // add the last paragraph in case the file doesn't end with an empty line
            if (!currentParagraph.isEmpty()) {
                paragraphs.add(currentParagraph);
            }

            // print all paragraphs
            printParagraphs(paragraphs);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    //print method to show that paragraphs are made up of words
    private static void printParagraphs(List<Paragraph> paragraphs) {
        int paragraphNumber = 1;
        for (Paragraph p : paragraphs) {

            //reconstruct the paragraph text string by joining words together
            String paragraphText = String.join(" ", p.getWords());
            int wordCount = p.getWords().size();

            // I included a word count and paragraph number to show how I have represented the data as paragraphs made up of words
            System.out.println("Paragraph " + paragraphNumber + ": " + paragraphText);
            System.out.println("Word Count: " + wordCount);
            System.out.println();
            paragraphNumber = paragraphNumber+1;
        }
    }
}