package combination;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    static Page currentPage;
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String response1;


        initializationMethod();

        while (currentPage.getEnding()== Page.NOT_ENDING){
            for (int i = 0; i < currentPage.getDialogue().size(); i++) {
                System.out.println(currentPage.getDialogue().get(i));
                response1 = input.nextLine().toLowerCase(Locale.ROOT);
            }

            currentPage.displayChoices();

            response1 = input.nextLine().toLowerCase(Locale.ROOT);
            currentPage = currentPage.getNextPageForChoice(response1);

            if (currentPage.getEnding()== Page.ENDING){
                for (int i = 0; i < currentPage.getDialogue().size(); i++) {
                    System.out.println(currentPage.getDialogue().get(i));
                    response1 = input.nextLine().toLowerCase(Locale.ROOT);
                }
                System.out.println("The end.");
                System.out.println(currentPage.getEndingName());
            }


        }

    }

    public static void initializationMethod(){
        Page start = new Page(Page.NOT_ENDING);
        Page beach = new Page(Page.NOT_ENDING);
        Page jungle = new Page(Page.NOT_ENDING);
        Page openBarrel = new Page(Page.ENDING);
        Page ignoreBarrel = new Page(Page.NOT_ENDING);
        Page writeSOS = new Page(Page.ENDING);
        Page fightTiger = new Page(Page.ENDING);
        Page runFromTiger = new Page(Page.ENDING);

        start.addChoice("go to the beach",beach);
        start.addChoice("go to the jungle",jungle);

        beach.addChoice("open the barrel",openBarrel);
        beach.addChoice("ignore the barrel", ignoreBarrel);
        ignoreBarrel.addChoice("go to the jungle",jungle);
        ignoreBarrel.addChoice("write SOS in the sand and hope someone comes", writeSOS);

        jungle.addChoice("fight the tiger",fightTiger);
        jungle.addChoice("run!", runFromTiger);

        writeSOS.setEndingName("GAME OVER. Ending: SOS");
        openBarrel.setEndingName("GAME OVER. Ending: Poisoned.");
        runFromTiger.setEndingName("GAME OVER. Ending: Mauled to death.");
        fightTiger.setEndingName("GAME OVER. Ending: Starting a family.");

        //dialogue:
        //This COULD be turned into a text file that can be read from an IO.

        start.addChatBubbleToDialogue("You are stranded on an island.");
        start.addChatBubbleToDialogue("There is a beach, with a clear view of the endless sea.");
        start.addChatBubbleToDialogue("there is a jungle in the middle of the island");
        start.addChatBubbleToDialogue("that looks luscious,green and foreboding.");
        start.addChatBubbleToDialogue("What will you do?");

        beach.addChatBubbleToDialogue("You decide to walk along the beach.");
        beach.addChatBubbleToDialogue("You feel hopeless, and scared, and very, very thirsty.");
        beach.addChatBubbleToDialogue("...");
        beach.addChatBubbleToDialogue("Hm?");
        beach.addChatBubbleToDialogue("What's this?");
        beach.addChatBubbleToDialogue("You find a bit of debris.");
        beach.addChatBubbleToDialogue("Looks like a barrel of some sort.");
        beach.addChatBubbleToDialogue("What will you do?");

        openBarrel.addChatBubbleToDialogue("You find some wine, or.. something.");
        openBarrel.addChatBubbleToDialogue("You don't know. You are dehydrated.");
        openBarrel.addChatBubbleToDialogue("You are so thirsty.");
        openBarrel.addChatBubbleToDialogue("You need to drink some. So, you do.");
        openBarrel.addChatBubbleToDialogue("...");
        openBarrel.addChatBubbleToDialogue("Mm..");
        openBarrel.addChatBubbleToDialogue("ACK!");
        openBarrel.addChatBubbleToDialogue("You have been poisoned.");

        ignoreBarrel.addChatBubbleToDialogue("You ignore the barrel and walk along the beach.");
        ignoreBarrel.addChatBubbleToDialogue("You can either go into the jungle, or you can write SOS on the sand and hope someone sees");

        jungle.addChatBubbleToDialogue("Now you are in the jungle.");
        jungle.addChatBubbleToDialogue("Ow!");
        jungle.addChatBubbleToDialogue("You trip on some tree roots.");
        jungle.addChatBubbleToDialogue("Uh oh.");
        jungle.addChatBubbleToDialogue("You have found yourself face to face with a ferocious tiger.");
        jungle.addChatBubbleToDialogue("What will you do?");

        fightTiger.addChatBubbleToDialogue("You kill the tiger successfully.");
        fightTiger.addChatBubbleToDialogue("What's that?");
        fightTiger.addChatBubbleToDialogue("Miraculously, a sexy lady comes out of the thick jungle bushes.");
        fightTiger.addChatBubbleToDialogue("You get with her and run deep into the jungle and start a family.");

        runFromTiger.addChatBubbleToDialogue("The tiger catches you.");
        runFromTiger.addChatBubbleToDialogue("You have died.");
        //////////////////////////
        currentPage = start;
    }
}
