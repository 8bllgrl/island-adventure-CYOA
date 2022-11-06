package bare;

import java.util.ArrayList;

public class Page {
    private String text;
    private ArrayList<String> dialogue;
    private ArrayList<String> choices; //list of all of the choices.
    private ArrayList<Page> nextPages; //list of all of the pages.

    private int endType;

    //THESE ARE ENUM PLACEHOLDERS:
    public static final int NOT_ENDING = 0;
    public static final int WIN = 1;
    public static final int LOSE = 2;

    private String endingName = "N/A";


    public Page(String pageText, int endType) {
        this.text = pageText;
        this.choices = new ArrayList<>();
        this.nextPages = new ArrayList<>();
        this.endType = endType;
    }

    public Page(int endType) {
        this.dialogue = new ArrayList<>();
        this.choices = new ArrayList<>();
        this.nextPages = new ArrayList<>();
        this.endType = endType;
    }

    public void displayText() {
        System.out.println(text);
    }

    public void displayEndingName() {
        System.out.println(getEndingName());
    }

    public void displayChoices() {
        System.out.println("Type the number for the choice that you want.");
        for (int location = 0; location < choices.size(); location++) {
            System.out.print(location);
            String choice = choices.get(location);
            System.out.println(". " + choice);
        }
    }

    //way to add another option.
    public void addChoice(String choiceText, Page nextPage) {
        choices.add(choiceText);
        nextPages.add(nextPage);
    }

    //way to add chat bubbles inside of the dialogue array.
    public void addChatBubbleToDialogue(String chatBubbleText){
        dialogue.add(chatBubbleText);
    }

    public String displayChatBox(int chatBoxNumber) {
        return dialogue.get(chatBoxNumber);
    }

    public Page getNextPageForChoice(String userChoice) {
        int choice = -1;
        try {
            choice = Integer.parseInt(userChoice);

        } catch (Exception e) {
            System.out.println("Please type the NUMBER of your choice.");
            return this;
        }

        if (choice >= 0 && choice <= nextPages.size()) {
            return nextPages.get(choice);
        }

        System.out.println("Your number isn't a valid choice!");
        return this; // returning THIS allows the user to type the same thing again, because it is looping back into the current page :)
    }

    public String getEndingName() {
        return endingName;
    }

    public void setEndingName(String endingName) {
        this.endingName = endingName;
    }

    public int getEnding() {
        return this.endType;
    }

    public ArrayList<String> getDialogue(){
        return dialogue;
    }


}
