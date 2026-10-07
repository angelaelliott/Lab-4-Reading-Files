import java.util.ArrayList;
import java.util.List;

public class Paragraph {
    private List<String> words;

    public Paragraph() {
        this.words = new ArrayList<>();
    }

    public void addWord(String word) {
        words.add(word);
    }

    public List<String> getWords() {
        return words;
    }

    public boolean isEmpty() {
        return words.isEmpty();
    }
}