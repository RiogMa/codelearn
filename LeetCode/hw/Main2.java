package hw;

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String rule = in.nextLine();
        String target = in.nextLine();

        try {
            String regex = convert(rule);
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(target);

            if (matcher.find()) {
                System.out.println(matcher.group(0));
            } else {
                System.out.println("!");
            }
        } catch (Exception e) {
            System.out.println("Invalid rule or failed to convert the rule to regex.");
        }
    }

    public static String convert(String rule) {
        StringBuilder regex = new StringBuilder();
        Stack<Integer> multiplierStack = new Stack<>();
        Stack<StringBuilder> patternStack = new Stack<>();
        StringBuilder current = new StringBuilder();

        int i = 0;
        while (i < rule.length()) {
            char c = rule.charAt(i);
            if (Character.isDigit(c)) {
                int start = i;
                while (i < rule.length() && Character.isDigit(rule.charAt(i))) i++;
                int multiplier = Integer.parseInt(rule.substring(start, i));
                multiplierStack.push(multiplier);
                patternStack.push(current);
                current = new StringBuilder();
                i++; // Skip the '(' following the digit(s)
            } else if (c == ')') {
                String repeatedPattern = current.toString();
                current = patternStack.pop();
                int times = multiplierStack.pop();
                current.append(String.format("(?:%s){%d}", repeatedPattern, times));
                i++;
            } else {
                if (c == 'N') {
                    current.append("[0-9]");
                } else if (c == 'A') {
                    current.append("[a-zA-Z]");
                }
                i++;
            }
        }

        return current.toString();
    }
}

