import java.util.Scanner;

public class AdvancedJavaQuiz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Questions, expected answers, and explanations
        String[] questions = {
            "1. Is Java platform-independent? (yes/no): ",
            "2. Does Java support multiple inheritance through classes? (yes/no): ",
            "3. Is 'int' a primitive data type in Java? (yes/no): ",
            "4. Can Java applications run without a JVM? (yes/no): ",
            "5. Is 'String' a primitive type in Java? (yes/no): ",
            "6. Is Java case-sensitive? (yes/no): ",
            "7. Does Java have a 'goto' statement? (yes/no): ",
            "8. Can Java arrays be resized dynamically? (yes/no): ",
            "9. Are all Java methods virtual by default? (yes/no): ",
            "10. Does Java support operator overloading? (yes/no): ",
            "11. Is 'final' keyword used to declare constants in Java? (yes/no): ",
            "12. Can you override a private method in Java? (yes/no): ",
            "13. Is 'null' a valid value for any reference type in Java? (yes/no): ",
            "14. Does Java support checked exceptions? (yes/no): ",
            "15. Is Java's 'String' immutable? (yes/no): "
        };

        String[] correctAnswers = {
            "yes", "no", "yes", "no", "no",
            "yes", "no", "no", "yes", "no",
            "yes", "no", "yes", "yes", "yes"
        };

        String[] explanations = {
            "Correct! Java is platform-independent due to the JVM.",
            "Incorrect. Java does not support multiple inheritance through classes.",
            "Correct! 'int' is a primitive data type.",
            "Incorrect. Java applications require a JVM to run.",
            "Incorrect. 'String' is a class, not a primitive type.",
            "Correct! Java is case-sensitive.",
            "Incorrect. Java does not have a 'goto' statement.",
            "Incorrect. Java arrays have fixed size once created.",
            "Correct! All non-static, non-final methods are virtual by default.",
            "Incorrect. Java does not support operator overloading.",
            "Correct! 'final' is used to declare constants.",
            "Incorrect. Private methods cannot be overridden.",
            "Correct! 'null' can be assigned to any reference type.",
            "Correct! Java supports checked exceptions.",
            "Correct! Strings in Java are immutable."
        };

        boolean playAgain;

        do {
            int score = 0;
            String[] userAnswers = new String[questions.length];

            System.out.println("Welcome to the Advanced Java Quiz!");
            System.out.println("Please answer each question with 'yes' or 'no'.\n");

            for (int i = 0; i < questions.length; i++) {
                String userAnswer;
                while (true) {
                    System.out.print(questions[i]);
                    userAnswer = scanner.nextLine().trim().toLowerCase();
                    if (userAnswer.equals("yes") || userAnswer.equals("no")) {
                        break;
                    } else {
                        System.out.println("Invalid input. Please answer with 'yes' or 'no'.");
                    }
                }
                userAnswers[i] = userAnswer;

                if (userAnswer.equals(correctAnswers[i])) {
                    score++;
                    System.out.println("Correct!\n");
                } else {
                    System.out.println("Incorrect. " + explanations[i] + "\n");
                }
            }

            // Show summary
            System.out.println("Quiz completed!");
            System.out.println("Your score: " + score + " out of " + questions.length);
            double percentage = (score * 100.0) / questions.length;
            System.out.printf("Percentage: %.2f%%\n\n", percentage);

            System.out.println("Summary:");
            for (int i = 0; i < questions.length; i++) {
                System.out.printf("%s Your answer: %s | Correct answer: %s\n",
                        questions[i].substring(0, questions[i].indexOf('(')).trim(),
                        userAnswers[i], correctAnswers[i]);
            }

            // Ask if user wants to play again
            System.out.print("\nDo you want to retake the quiz? (yes/no): ");
            String again = scanner.nextLine().trim().toLowerCase();
            playAgain = again.equals("yes");

            System.out.println();

        } while (playAgain);

        System.out.println("Thank you for taking the quiz!");
        scanner.close();
    }
}
