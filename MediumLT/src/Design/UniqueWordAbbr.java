package Design;


import java.util.BitSet;

public class UniqueWordAbbr {

  public static void main(String[] args) {
    String[] dict = new String[]{"deer", "door", "cake", "card"};

    BitSet[] startLetterBitMaps = new BitSet[26];
    BitSet[] endLetterBitMaps = new BitSet[26];

    for (int index=0;index<26;index++) {
      startLetterBitMaps[index] = new BitSet();
      endLetterBitMaps[index] = new BitSet();
    }

    for (int index=0;index<dict.length;index++) {
      String s = dict[index];
      char sc = s.charAt(0);
      char ec = s.charAt(s.length()-1);
      startLetterBitMaps[sc-'a'].set(index);
      endLetterBitMaps[ec-'a'].set(index);
    }

    System.out.println(isUnique(dict, startLetterBitMaps, endLetterBitMaps, "dear"));
    System.out.println(isUnique(dict, startLetterBitMaps, endLetterBitMaps, "cart"));
    System.out.println(isUnique(dict, startLetterBitMaps, endLetterBitMaps, "cane"));
    System.out.println(isUnique(dict, startLetterBitMaps, endLetterBitMaps, "make"));
  }


  public static boolean isUnique(String[] dict, BitSet[] startLetterBitMaps, BitSet[] endLetterBitMaps, String word) {
    char sc = word.charAt(0);
    char ec = word.charAt(word.length()-1);

    BitSet set  = (BitSet) startLetterBitMaps[sc-'a'].clone();
    set.and(endLetterBitMaps[ec-'a']);

    for (int index=0;index<set.size();index++) {
        if (set.get(index)) {
          if (!dict[index].equals(word)) {
            return false;
          }
        }
    }
    return true;
  }

}
