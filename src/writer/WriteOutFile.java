package writer;


import service.MyService;

import java.io.*;
import java.util.List;
/**
 * @author Grakovich 17.03.2023
 */
public class WriteOutFile implements WriteOut {

    private final MyService service;
    private final String fileName;

    public WriteOutFile(MyService service, String fileName) {
        this.service = service;
        this.fileName = fileName;
    }

    @Override
    public void writerStringTo() {
        List<String> list = service.arrays();
        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(list.get(0));
            for (int i = 1; i < list.size(); i++) {
                writer.append("\n");
                writer.append(list.get(i));
            }
            writer.close();
        } catch (IOException e) {
            throw new IllegalArgumentException(fileName + " не удалось создать");
        }
    }
}
