package Medium.Medium;

public class LongestPalinSubstring {
    public static String longestPalindrome(String s) {
      if(s==null||s.length()<=1) return s;
      int left = 0, right = 0;
      for(int i=0;i<s.length();i++){
        int len1 = extendCheckPali(s,i,i);
        int len2 = extendCheckPali(s,i,i+1);
        int len = Math.max(len1,len2);
        if(len>right-left){
          left = i-(len-1)/2;
          right = i+len/2;
        }
      }
      return s.substring(left,right+1);
    }
    public static int extendCheckPali(String s, int start, int end){
      System.out.println("s:"+start+"e:"+end);
      while(start>=0&&end<s.length()&&s.charAt(start)==s.charAt(end)){
        start--;
        end++;
      }
      return end-start-1;
    }

    public static void main(String[] args) {
      System.out.println(longestPalindrome("bacddcab"));
    }

}
