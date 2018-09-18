import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


public class webScraper {

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
    public static void main(String[] unused){
        System.out.println("Run");
        String text = urlToString("http://erdani.com/tdpl/hamlet.txt");
        String[] lines = text.split("\n");
        int number_of_lines = lines.length;
        //System.out.println(text.split("\n")[]);
        int totalWords = 0;
        int occurencesOfWordToLookFor = 0;
        int numberOfWordsInLine;
        String line;
        String[] words;
        String stringToLookFor = "prince";
        for (int line_index = 0; line_index < number_of_lines; line_index++) {
            line = lines[line_index];
            words = line.split(" ");
            numberOfWordsInLine = words.length;
            totalWords += numberOfWordsInLine;
            for (int word_index = 0; word_index < numberOfWordsInLine; word_index++) {
                if (words[word_index].toLowerCase().equals(stringToLookFor)) {
                    occurencesOfWordToLookFor++;
                }
            }
        }
        System.out.println("Total number of words: " + totalWords); //prints the occurences of a specific word
        System.out.println("Number of occurences of the word we're looking for: " + occurencesOfWordToLookFor);
        //the above code counts the number of words in the document. Now I will count the number of occurences "prince"
        //my program can be improved by accounting for times when a comma appears at the end of the word
    }
}