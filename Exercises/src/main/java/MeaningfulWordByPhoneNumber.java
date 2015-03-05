import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MeaningfulWordByPhoneNumber {

    char[] ltod = new char[256];
    private Map<String, List<String>> lookupTable = new HashMap<String, List<String>>();


    public MeaningfulWordByPhoneNumber(String dictPath) throws IOException {
        // Load letters to digits map
        ltod['a'] = '2';
        ltod['b'] = '2';
        ltod['c'] = '2';
        ltod['d'] = '3';
        ltod['e'] = '3';
        ltod['f'] = '3';
        ltod['g'] = '4';
        ltod['h'] = '4';
        ltod['i'] = '4';
        ltod['j'] = '5';
        ltod['k'] = '5';
        ltod['l'] = '5';
        ltod['m'] = '6';
        ltod['n'] = '6';
        ltod['o'] = '6';
        ltod['p'] = '7';
        ltod['q'] = '7';
        ltod['r'] = '7';
        ltod['s'] = '7';
        ltod['t'] = '8';
        ltod['u'] = '8';
        ltod['v'] = '8';
        ltod['w'] = '9';
        ltod['x'] = '9';
        ltod['y'] = '9';
        ltod['z'] = '9';

        BufferedReader br = new BufferedReader(new FileReader(dictPath));
        String word;
        while ((word = br.readLine()) != null) {
            word = word.toLowerCase();
            String number = wordToNumber(word);
            List<String> words = lookupTable.get(number);
            if( words == null ) {
                words = new ArrayList<String>();
                lookupTable.put(number, words);
            }

            words.add(word);
        }
        br.close();
    }


    private String wordToNumber(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            char d = ltod[ch];
            sb.append(d);
        }
        return sb.toString();
    }

    private String[] lookupWord(String number) {
        List<String> words = lookupTable.get(number);
        if( words != null && words.size()>0 )
            return words.toArray(new String[words.size()]);
        else
            return null;
    }

    static public void main(String[] args) {
        try {
            MeaningfulWordByPhoneNumber dict = new MeaningfulWordByPhoneNumber("/usr/share/dict/words");
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(System.in));

            String number;

            System.out.println("Enter phone#: ");
            while ((number = br.readLine()) != null) {
                String[] words = dict.lookupWord(number);
                if (words != null && words.length > 0) {
                    System.out.print(String.format("Meaningful words for '%s': ", number));
                    for (String w : words) {
                        System.out.print(w + " ");
                    }
                    System.out.println("\n---");
                }
                else {
                    System.out.println("No meaningful words found. Try another number");
                }
                System.out.println("Enter phone#: ");
            }

        } catch (IOException io) {
            io.printStackTrace();
        }



    }

}
