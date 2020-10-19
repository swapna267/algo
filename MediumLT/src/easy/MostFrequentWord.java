package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.
 */
public class MostFrequentWord {

  public static void main(String[] args) {
    String para = "Bob hit a ball, the hit BALL flew far after it was hit.";
    String[] banned = {"hit"};
    System.out.println(getMostFrequentWord(para, banned));
  }

  public static String getMostFrequentWord(String paragraph ,String[] banned) {
    Map<String,Integer> occurrences = new HashMap();
    Set<String> bannedWords = new HashSet<String>();
    for (String bannedWord: banned) {
      bannedWords.add(bannedWord);
    }

    Pattern pattern = Pattern.compile("[!?',;.]");
    String[] words = paragraph.split("\\s+");
    for (String word: words) {
       Matcher matcher = pattern.matcher(word);
       String cleanWord = matcher.replaceAll("").toLowerCase();
      if (!bannedWords.contains(cleanWord)) {
        Integer occ = occurrences.getOrDefault(cleanWord,0);
        occurrences.put(cleanWord, occ+1);
      }
    }

    int max = 0;
    String mostFrequent = "";
    for (Map.Entry<String,Integer> entry : occurrences.entrySet()) {
      if (entry.getValue() > max) {
        max = entry.getValue();
        mostFrequent = entry.getKey();
      }
    }

    return mostFrequent;
  }
}
