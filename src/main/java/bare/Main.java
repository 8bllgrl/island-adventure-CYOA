package bare;

import java.util.Locale;
import java.util.Scanner;

public class Main{


    static Page currentPage;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        initializationMethod();

        while (currentPage.getEnding()== Page.NOT_ENDING){
            currentPage.displayText();
            currentPage.displayChoices();

            String response1 = input.nextLine().toLowerCase(Locale.ROOT);
            currentPage = currentPage.getNextPageForChoice(response1);

            if (currentPage.getEnding()== Page.WIN){
                currentPage.displayText();
                System.out.println("Congrats! you have won.");
                System.out.println(currentPage.getEndingName());
            } else if (currentPage.getEnding()== Page.LOSE){
                currentPage.displayText();
                System.out.println("Sorry. You have died.");
                System.out.println(currentPage.getEndingName());
            }


        }

    }


    //This is where customization happens.
    public static void initializationMethod(){
        //bare.Page initialization.
        Page start = new Page("You are stranded on an island.\n" +
                "There is a beach, with a clear view of \n" +
                "the endless sea, and there is a jungle\n" +
                "in the middle of the island that looks\n" +
                "luscious,green and foreboding. \n" +
                "\n" +
                "What will you do?" +
                "\n",0);
        Page beach = new Page("You decide to walk along the beach.\n" +
                "You feel hopeless, and scared, and very\n" +
                "very thirsty.You find a bit of debris, \n" +
                "looks like a wooden barrel of some sort.\n" +
                "\n" +
                "What will you do?\n",0);
        Page jungle = new Page("now you are in the jungle.\n" +
                "You stumble across some tree roots\n" +
                "and you have found yourself\n" +
                "face to face with a tiger.\n" +
                "\n" +
                "What will you do?\n",0);

        Page openBarrel = new Page("You find some wine, or.. something.\n" +
                "You don't know. You are dehydrated.\n" +
                "You are so thirsty.\n" +
                "You need to drink some. So, you do.\n" +
                "You have been poisoned.", Page.LOSE);
        Page ignoreBarrel = new Page("You ignore the barrel and walk along\n" +
                "the beach.\n" +
                "You can either go into the jungle, or\n" +
                "you can write SOS on the sand and\n" +
                "hope someone sees.",0);
        Page writeSOS = new Page("You write SOS on the sand.\n" +
                "A helicopter comes and saves you.", Page.WIN);

        Page fightTiger = new Page("You kill the tiger successfully and then\n" +
                "miraculously, a sexy lady comes out of\n" +
                "the jungle.\n" +
                "You get with her and run deep into\n" +
                "the jungle and start a family.", Page.WIN);
        Page runFromTiger = new Page("The tiger catches you.\n" +
                "You have died.", Page.LOSE);


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


        currentPage = start;
    }


}
