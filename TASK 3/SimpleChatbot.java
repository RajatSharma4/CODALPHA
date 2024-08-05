import java.util.Scanner;

public class SimpleChatbot {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! I am a chatbot. How can I help you today?");
        
        while (true) {
            String userInput = scanner.nextLine().toLowerCase();
            
            if (userInput.equals("exit")) {
                System.out.println("Goodbye! Have a great day!");
                break;
            }
            
            String response = getResponse(userInput);
            System.out.println(response);
        }
        
        scanner.close();
    }

    private static String getResponse(String input) {
        if (input.contains("hello") || input.contains("hi")) {
            return "Hello! How can I assist you?";
        } else if (input.contains("how are you")) {
            return "I'm just a computer program, but thanks for asking!";
        } else if (input.contains("your name")) {
            return "I am a simple chatbot created to help you.";
        } else if (input.contains("what can you do")) {
            return "I can answer simple questions and chat with you!";
        } else if (input.contains("help")) {
            return "Sure! You can ask me about my capabilities or just say hi.";
        } else {
            return "I'm sorry, I didn't understand that. Can you please rephrase?";
        }
    }
}
