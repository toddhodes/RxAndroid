
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

public class WordBreak {

  public static void main(String[] args) {
    if (args.length < 2) {
      System.out.println("Usage: WordBreak <word,word,word> <stringtosplit>");
      return;
    }
    Set<String> dict = new HashSet<String>();
    dict.addAll(Arrays.asList(args[0].split(",")));
    System.out.println(args[0] + " --> " + new WordBreak().segmentString(args[1], dict));
  }

  Map<String,String> memoized = new HashMap<String,String>();

  String segmentString(String input, Set<String> dict) {
    if (dict.contains(input)) return input;
    if (memoized.containsKey(input)) {
      return memoized.get(input);
    }
    int len = input.length();
    for (int i = 1; i < len; i++) {
      String prefix = input.substring(0, i);
      if (dict.contains(prefix)) {
        String suffix = input.substring(i, len);
        String segSuffix = segmentString(suffix, dict);
        if (segSuffix != null) {
          //memoized.put(input, prefix + " " + segSuffix);
          return prefix + " " + segSuffix;
        }
      }
    }
    memoized.put(input, null);
    return null;
  }

}
