package queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FirstNonRepeatingCharacter {

    public static void findFirstNonRepeating(String stream) {
        Map<Character, Integer> charCount = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < stream.length(); i++) {
            char currentChar = stream.charAt(i);

            charCount.put(currentChar, charCount.getOrDefault(currentChar, 0) + 1);

            queue.offer(currentChar);

            while (!queue.isEmpty() && charCount.get(queue.peek()) > 1) {
                queue.poll();
            }

            if (!queue.isEmpty()) {
                System.out.println("First non-repeating character after processing " + (i + 1) + " characters: " + queue.peek());
            } else {
                System.out.println("No non-repeating character after processing " + (i + 1) + " characters.");
            }
        }
    }

    public static void main(String[] args) {
        String stream = "aabcdbec";
        System.out.println("Stream: " + stream);
        findFirstNonRepeating(stream);
    }
}

