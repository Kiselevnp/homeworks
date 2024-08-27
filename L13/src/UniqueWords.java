import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Arrays;

public class UniqueWords {
    public static void main(String[] args) {
        String[] words = {"apple", "banana", "apple", "orange", "banana", "kiwi", "pear", "apple", "kiwi", "melon"};

        // Найти уникальные слова
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
        System.out.println("Уникальные слова: " + uniqueWords);

        // Посчитать количество каждого слова
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        System.out.println("Количество каждого слова: " + wordCount);
    }
}
