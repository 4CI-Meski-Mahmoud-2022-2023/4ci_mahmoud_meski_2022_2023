import java.io.*;
import java.util.*;
public class TestCalculator {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        LibriCalculator calculator = new LibriCalculator();
        calculator.start("libri.txt");
    }
}