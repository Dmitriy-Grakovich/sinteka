import reader.ReadIn;
import reader.ReadInFile;
import service.ServiceImpl;
import writer.WriteOut;
import writer.WriteOutFile;


public class Main {
    public static void main(String[] args) {
        String in = args.length > 0 ? args[0] : "input.txt";
        String out = args.length > 1 ? args[1] : "output.txt";

        ReadIn rearIn = new ReadInFile(in);
        WriteOut writeOut = new WriteOutFile(new ServiceImpl(rearIn), out);
        writeOut.writerStringTo();

    }
}