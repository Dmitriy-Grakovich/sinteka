package reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * @author Grakovich 17.03.2023
 */
public class ReadInFile implements ReadIn {
    private final String fileName;

    public ReadInFile(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<List<String>> getReader() {
        List<List<String>> result = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNext()) {
                List<String> st = new ArrayList<>();
                int temp = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < temp; i++) {
                    st.add(scanner.nextLine());
                }
                result.add(st);
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(fileName + " не найден");
        }

        return result;
    }
}
