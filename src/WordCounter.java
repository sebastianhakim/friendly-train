import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;

public class WordCounter {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a name for the input file: ");
        String fileName = scan.nextLine();
        String[] words = {"computer", "soccer", "class", "paper"};
        Random random = new Random();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            int numLines = 100;
            for (int i = 0; i < numLines; i ++) {
                bufferedWriter.write(words[random.nextInt(words.length)] + "\n");

            }
        }
        String line;
        Map<String, Integer> count = new TreeMap<>();
               try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {  
                   while ((line = bufferedReader.readLine()) != null) {
                            line = line.toLowerCase();
                            if (count.containsKey(line)) {
                               count.put(line, count.get(line) + 1);
                            } else {
                                count.put(line, 1);
                            }
                   }
            }

            System.out.println("Please enter a name for the output file: ");
            String outFileName = scan.nextLine();
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outFileName))) {
                for (Entry<String, Integer> entry: count.entrySet()) {
                    bufferedWriter.write(entry.getKey() + " " + entry.getValue() + "\n");
                }
            }
    }

}