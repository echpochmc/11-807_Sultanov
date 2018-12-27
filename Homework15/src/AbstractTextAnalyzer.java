import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTextAnalyzer implements TextAnalyzer {
    @Override
    abstract public double analyze(TextProvider te1, TextProvider te2);

    /**
     * Returns a list of unique words found in an input text.
     * Words in the text can be delimited by one space or a space with a comma
     */

    protected List<String> tokenizeUnique(String text) {
        text = text.replace(",", "");
        String[] words = text.split(" ");
        List<String> uniqueWords = new ArrayList<>();
        for (String word : words) {
            word = word.toLowerCase();
            if (!uniqueWords.contains(word))
                uniqueWords.add(word);
        }
        return uniqueWords;
    }
}
