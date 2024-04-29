import java.util.Scanner;
public class TypingSpeedTest {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
System.out.println("Welcome to Typing Speed Test!");
System.out.println("Type the following text:");
String testText = "The quick brown fox jumps over the lazy dog.";
System.out.println(testText);
System.out.println("\nPress Enter when you're ready to start...");
scanner.nextLine();
long startTime = System.currentTimeMillis();
System.out.println("Start typing:");
String userTypedText = scanner.nextLine();
long endTime = System.currentTimeMillis();
long elapsedTime = endTime - startTime;
double wordsPerMinute = calculateWordsPerMinute(testText, userTypedText,
elapsedTime);
System.out.println("\nTyping speed: " + wordsPerMinute + " words per minute");
System.out.println("Thank you for taking the Typing Speed Test!");
}
private static double calculateWordsPerMinute(String originalText, String typedText, long
elapsedTime) {
String[] originalWords = originalText.split("\s+");
String[] typedWords = typedText.split("\s+");
int correctWords = 0;
for (int i = 0; i < Math.min(originalWords.length, typedWords.length); i++) {
if (originalWords[i].equals(typedWords[i])) {
correctWords++;
}
}
double accuracy = ((double) correctWords / originalWords.length) * 100;
double minutes = elapsedTime / 60000.0; // Convert milliseconds to minutes
return (correctWords / minutes);
}
}
