import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {
    private ArrayList<String> lines;
    public ArrayList<String> getLines() { return lines; }
    public Boolean doReadFile(String fname) {
        lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fname))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            return true;
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return false;
    }
    private ReadFile() {}
    public ReadFile(String fname) throws FileNotFoundException {
        if (!doReadFile(fname)) {
            throw new FileNotFoundException("Error reading file: " + fname);
        }
    }
}
