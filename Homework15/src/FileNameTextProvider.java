import java.io.File;

public class FileNameTextProvider extends FileTextProvider {

    public FileNameTextProvider(File input) {
        super(input);
    }

    @Override
    public String getText() {
        String filename = input.getName();
        String text = super.getText();
        return filename + ": " + text;
    }

}
