package algo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class UniqueEmails {

  public int numUniqueEmails(String[] emails) {
    // 28 ms
    List<String> res = new ArrayList<>(emails.length);

    for (String email : emails) {
      int indexOfAt = email.indexOf("@");
      String localName = email.substring(0, indexOfAt);
      int indexOfPlus = localName.indexOf("+");
      localName = localName.substring(0, indexOfPlus == -1 ? localName.length() : indexOfPlus).replaceAll("\\.", "");
      res.add(localName + email.substring(indexOfAt));
    }

    return new HashSet<>(res).size();

  // 86 ms
//    return Arrays.stream(emails).parallel().map(email -> {
//      int indexOfAt = email.indexOf("@");
//      String localName = email.substring(0, indexOfAt);
//      int indexOfPlus = localName.indexOf("+");
//      localName = localName.substring(0, indexOfPlus == -1 ? localName.length() : indexOfPlus).replaceAll("\\.", "");
//      return localName + email.substring(indexOfAt);
//    }).collect(Collectors.toSet()).size();
  }
}



/*
Every email consists of a local name and a domain name, separated by the @ sign.

For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.

Besides lowercase letters, these emails may contain '.'s or '+'s.

If you add periods ('.') between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name.  For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.  (Note that this rule does not apply for domain names.)

If you add a plus ('+') in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com.  (Again, this rule does not apply for domain names.)

It is possible to use both of these rules at the same time.

Given a list of emails, we send one email to each address in the list.  How many different addresses actually receive mails?



Example 1:

Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
Output: 2
Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails


Note:

1 <= emails[i].length <= 100
1 <= emails.length <= 100
Each emails[i] contains exactly one '@' character.
 */