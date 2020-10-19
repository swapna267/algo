package Medium.Medium;

public class SpellChecker {
  static char[] vowels = {'a','e','i','o','u'};
  static TrieNode trieRoot;

  public static void main(String[] args) {
    String[] wordlist = {"uae","iuu"};
    String[] queries = {"ioi"};
    String[] output = spellchecker(wordlist, queries);
    for (String out:output) {
      System.out.println(out);
    }
  }

  public static String[] spellchecker(String[] wordlist, String[] queries) {
    TrieNode trie = buildTrie(wordlist);
    trieRoot = trie;

    for (int index=0;index<wordlist.length;index++) {
      String word = wordlist[index];
      addToInsensitiveIndexes(trie, word.toLowerCase().toCharArray(),0, index);
    }

    String[] queriesOut = new String[queries.length];
    for (int index=0;index<queries.length;index++) {
      int found = getSpellCheckedWord(trie, queries[index].toCharArray(), 0);
      if (found == -1) {
        queriesOut[index] = "";
      } else {
        queriesOut[index] = wordlist[found];
      }
    }

    return queriesOut;
  }

  public static int getSpellCheckedWord(TrieNode root, char[] letters, int index) {
    if (index == letters.length) {
       return root.wordIndex;
    }

    char letter = letters[index];
    TrieNode child = root.getChild(letter);
    int foundIndex = -1;
    if (child != null) {
       foundIndex = getSpellCheckedWord(child, letters, index+1);
    }

    if (foundIndex == -1) {
      int indexWithtransform = getSpellCheckedWordLowerCase(trieRoot, String.valueOf(letters).toLowerCase().toCharArray(), 0,false);
      return indexWithtransform % 5000;
    }

    return foundIndex;
  }

  public static int getSpellCheckedWordLowerCase(TrieNode root, char[] letters, int index, boolean switchVowel) {
    if (index == letters.length) {
       if (!switchVowel) {
         return root.minCaseInsentiveIndex == Integer.MAX_VALUE ? -1 : root.minCaseInsentiveIndex;
       } else {
         return root.minCaseInsentiveIndex == Integer.MAX_VALUE ? -1 : root.minCaseInsentiveIndex+5000;
       }

    }

    char letter = letters[index];
    TrieNode child = root.getChild(letter);
    int foundIndex = -1;
    if (child != null) {
      foundIndex = getSpellCheckedWordLowerCase(child, letters, index+1, switchVowel);
    }

    if (foundIndex < 5000 && foundIndex >-1) {
      return foundIndex;
    }

      if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') {
        for (char vowel: vowels) {
          child = root.getChild(vowel);
          if (child != null) {
            int foundIndexWithChange = getSpellCheckedWordLowerCase(child, letters, index+1, true);
            if (foundIndex == -1) {
              foundIndex = foundIndexWithChange;
            }
            if (foundIndexWithChange != -1) {
              foundIndex = Math.min(foundIndex, foundIndexWithChange);
            }
          }
        }
      }


    return foundIndex;
  }

  public static void addToInsensitiveIndexes(TrieNode root, char[] letters, int index, int wordIndex) {
    if (index == letters.length) {
      root.addTocaseInsentiveIndex(wordIndex);
      return;
    }

    TrieNode child = root.getChild(letters[index]);
    if (child != null) {
      addToInsensitiveIndexes(child, letters, index+1, wordIndex);
    } else {
      child = root.addChild(letters[index]);
      addToInsensitiveIndexes(child, letters, index+1, wordIndex);
    }
  }



  public static TrieNode buildTrie(String[] wordlist) {
    TrieNode trie = new TrieNode();

    for (int index=0;index<wordlist.length;index++) {
      TrieNode root = trie;
      char[] letters = wordlist[index].toCharArray();

      for (char letter: letters) {
        TrieNode child = root.getChild(letter);

        if (child == null) {
          root = root.addChild(letter);
        } else {
          root = child;
        }
      }
      root.setWord(index);
    }
    return trie;
  }

  static class TrieNode {
    TrieNode[] child;
    int wordIndex = -1;
    int minCaseInsentiveIndex;
    //List of indexes matching with this path in lowercase manner.

    public TrieNode() {
      child = new TrieNode[52];
      minCaseInsentiveIndex = Integer.MAX_VALUE;
    }

    public TrieNode addChild(char c) {
      int pos = c - 'a';

      if (pos >=0 && pos<26) {
        child[pos] = new TrieNode();
        return child[pos];
      } else {
        pos = (c - 'A')+26;
        child[pos] = new TrieNode();
        return child[pos];
      }
    }

    public TrieNode getChild(char c) {
      int pos = c - 'a';

      if (pos >=0 && pos<26) {
        return child[pos];
      } else {
        pos = (c - 'A')+26;
        return child[pos];
      }
    }

    public void setWord(int wordIndex) {
      this.wordIndex = wordIndex;
    }

    public void addTocaseInsentiveIndex(int wordIndex) {
       this.minCaseInsentiveIndex = Math.min(minCaseInsentiveIndex, wordIndex);
    }
  }


}
