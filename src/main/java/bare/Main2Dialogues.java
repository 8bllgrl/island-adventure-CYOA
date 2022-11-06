package bare;

import java.util.Locale;
import java.util.Scanner;

public class Main2Dialogues {

    static Page currentPage;
    static int currentChatBox = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String response = " ";

        initializePagesMethod();

        boolean loopswitch = true;
        while (loopswitch) {
            for (int i = 0; i < currentPage.getDialogue().size(); i++) {
                System.out.println(currentPage.getDialogue().get(i));
                response = input.nextLine().toLowerCase(Locale.ROOT);
            }
            loopswitch = false;

        }


    }

    public static void initializePagesMethod() {

        Page start = new Page(Page.WIN);
        start.addChatBubbleToDialogue("Hello there.");
        start.addChatBubbleToDialogue("I'd like you to know..");
        start.addChatBubbleToDialogue("That this is a test.");
        start.addChatBubbleToDialogue("And when I am done talking..");
        start.addChatBubbleToDialogue("I will cease to exist.");

        currentPage = start;
    }
}
