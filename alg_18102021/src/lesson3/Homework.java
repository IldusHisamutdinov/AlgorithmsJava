package lesson3;

import java.util.Stack;
//программа, которая переворачивает вводимые строки (читает справа налево)
public class Homework {
    public static String reverseString(String line) {
        MyStack<Character> stack = new MyStack<>();
        for (Character ch : line.toCharArray()) {
            stack.push(ch);
        }
        String reversed = "";
        while (!stack.isEmpty()) {
            reversed = reversed + stack.pop();
        }
        return reversed;
    }
}
