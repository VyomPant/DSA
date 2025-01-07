package neetCode150.arraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://neetcode.io/problems/string-encode-and-decode
public class EncodeDecode {
    /* Time complexity: O(m) for encode() and decode()
       Space complexity: O(1) for encode() and decode() */
    private static String encode(List<String> strs) {
        // strs = [hello,tom]
        StringBuilder encodedString = new StringBuilder();
        for (String str : strs) {
            encodedString.append(str.length()).append("#").append(str);
        }
        return encodedString.toString(); // 5#hello3#tom
        /*using length of the string plus # as a delimiter helps the edge case when the string itself contains # as a character
         eg for word "hello" delimiter was 5#
         */
    }

    private static List<String> decode(String str) {
        List<String> decodedList = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int delimiterIndex = str.indexOf("#", i);//first occurence of # from ith index
            int length = Integer.parseInt(str.substring(i, delimiterIndex));
            i = delimiterIndex + 1 + length;
            decodedList.add(str.substring(delimiterIndex + 1, i));
        }
        return decodedList;
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList("neet", "code", "love", "you");
        System.out.println("Input : " + input);
        String encodedString = encode(input);
        System.out.println("Encoded String: " + encodedString);
        System.out.println("Decoded String: " + decode(encodedString));
    }

}
