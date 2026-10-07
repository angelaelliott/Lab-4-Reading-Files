import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    public void testOneParagraph() {
        ArrayList<String> lines = new ArrayList<>();
        lines.add("Paragraph one");

        List<Paragraph> result = Main.parseParagraphs(lines);
        assertEquals(1, result.size());
        assertEquals(2, result.get(0).getWords().size());
    }

    @Test
    public void testTwoParagraphs() {
        ArrayList<String> lines = new ArrayList<>();
        lines.add("Paragraph one");
        lines.add("");
        lines.add("Paragraph two");

        List<Paragraph> result = Main.parseParagraphs(lines);
        assertEquals(2, result.size());
    }

    @Test
    public void testEmptyFile() {
        ArrayList<String> lines = new ArrayList<>();
        List<Paragraph> result = Main.parseParagraphs(lines);
        assertEquals(0, result.size());
    }
}