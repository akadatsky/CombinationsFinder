package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        CombinationsFinder finder = new CombinationsFinder();

        String[] dictionary = {"a", "b", "c", "ab", "abc"};
        String target = "aabc";
        List<String> result = finder.findCombinations(dictionary, target);
        System.out.println(result);

        target = "aabcx";
        result = finder.findCombinations(dictionary, target);
        System.out.println(result);

        dictionary = new String[]{"a", "aa", "aaa"};
        target = "aaa";
        result = finder.findCombinations(dictionary, target);
        System.out.println(result);
    }
}
