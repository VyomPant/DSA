import java.util.HashMap;

public class Main {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> characterFrequencyMap1 = new HashMap<>();
        HashMap<Character, Integer> characterFrequencyMap2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            characterFrequencyMap1.put(s.charAt(i), characterFrequencyMap1.getOrDefault(s.charAt(i), 0) + 1);
            characterFrequencyMap2.put(t.charAt(i), characterFrequencyMap2.getOrDefault(t.charAt(i), 0) + 1);
        }
/*        if (areMapsEqual(characterFrequencyMap1, characterFrequencyMap2)) {
            return true;
        }*/
        if (characterFrequencyMap1.equals(characterFrequencyMap2)) {
            return true;
        }
        return false;
    }

    public static boolean areMapsEqual(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2) {
        if (map1.size() != map2.size())
            return false;

        for (Character key : map1.keySet()) {
            if (!map2.containsKey(key) || !map1.get(key).equals(map2.get(key))) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println(isAnagram("nagaram", "anagram"));
    }
}
