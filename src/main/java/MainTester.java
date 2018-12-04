import algo.JewelsInStones;
import algo.ToLowerCase;
import algo.UniqueEmails;
import algo.UniqueMorseRepresentations;

public class MainTester {

  public static void main (String[] args) {
    int count = new JewelsInStones().numJewelsInStones("aA", "aAAzz");
    System.out.println(count);

    count = new UniqueEmails().numUniqueEmails(new String[] {
        "test.email+alex@leetcode.com",
        "test.e.mail+bob.cathy@leetcode.com",
        "testemail+david@lee.tcode.com"});
    System.out.println(count);

    System.out.println(new ToLowerCase().toLowerCase("Hello"));
    System.out.println(new ToLowerCase().toLowerCase("here"));
    System.out.println(new ToLowerCase().toLowerCase("LOVELY"));

    count = new UniqueMorseRepresentations().uniqueMorseRepresentations(new String[] {"gin", "zen", "gig", "msg"});
    System.out.println(count);
  }
}