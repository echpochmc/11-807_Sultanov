import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class FileTextProvider implements TextProvider {
    private static final int MAX_SYMBOLS_NUM = 100;
    protected File input;

    public FileTextProvider(File input) {
        this.input = input;
    }

    @Override
    public String getText() {
        StringBuilder sb = new StringBuilder();
        Scanner sc = null;
        try {
            sc = new Scanner(input);
            while (sc.hasNextLine()) {
                sb.append(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        String strToReturn;
        String text = getText();
        if (text.length() <= MAX_SYMBOLS_NUM) {
            strToReturn = text;
        } else {
            strToReturn = text.substring(0, MAX_SYMBOLS_NUM - 1);
        }
        return "SimpleTextProvider{" +
                "text='" + strToReturn + '\'' +
                '}';
    }

}
