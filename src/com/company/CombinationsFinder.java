package com.company;

import java.util.ArrayList;
import java.util.List;

public class CombinationsFinder {

    private static class Combination {
        private List<String> elements = new ArrayList<>();

        private Combination() {
        }

        private Combination(List<String> elements) {
            this.elements = elements;
        }

        private void add(String element) {
            elements.add(element);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            String separator = "";
            for (String element : elements) {
                sb.append(separator).append(element);
                separator = " ";
            }
            return sb.toString();
        }

        @Override
        protected Combination clone() {
            return new Combination(new ArrayList<>(elements));
        }
    }

    private ArrayList<Combination> combinations = new ArrayList<>();

    public List<String> findCombinations(String[] dictionary, String target) {
        combinations.clear();
        processSearch(dictionary, new Combination(), target);
        List<String> result = new ArrayList<>();
        for (Combination combination : combinations) {
            result.add(combination.toString());
        }
        return result;
    }

    private void processSearch(String[] dictionary, Combination combination, String tail) {
        if (tail.isEmpty()) {
            combinations.add(combination);
            return;
        }
        for (String element : dictionary) {
            if (tail.startsWith(element)) {
                Combination newCombination = combination.clone();
                newCombination.add(element);
                String newTail = tail.substring(element.length());
                processSearch(dictionary, newCombination, newTail);
            }
        }
    }

}
