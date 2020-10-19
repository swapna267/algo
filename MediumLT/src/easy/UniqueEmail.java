package easy;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmail {
  public int numUniqueEmails(String[] emails) {
    Set<String> unqiueAdrr = new HashSet<>();

    for (int i=0;i< emails.length;i++) {
      String email = emails[i];
      char[] chars = email.toCharArray();
      StringBuilder builder = new StringBuilder();
      boolean foundPlus = false;
      boolean domainStart = false;
      for (int j=0; j<chars.length; j++) {
        if (domainStart) {
          builder.append(chars[j]);
          continue;
        }

        if (chars[j] == '@') {
          domainStart = true;
          builder.append(chars[j]);
        }

        if (chars[j] == '.') {
          continue;
        }

        if (chars[j] == '+') {
          foundPlus = true;
        }

        if (!foundPlus) {
          builder.append(chars[j]);
        }
      }
      unqiueAdrr.add(builder.toString());
    }
    return unqiueAdrr.size();
  }
}
