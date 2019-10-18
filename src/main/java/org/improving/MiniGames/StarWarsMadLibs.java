package org.improving.MiniGames;


import org.improving.ConsoleInputOutput;
import org.improving.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class StarWarsMadLibs implements MiniGame {
    InputOutput io;

    public StarWarsMadLibs(InputOutput io) {
        this.io = io;
    }

    public void run(){
        io.displayText("You travel long through the wasteland until coming across what appears to be a life size replica of the Millennium Falcon. " +
                "\nThe ship is covered in weathered rust spots, various dings, scratches, minor superficial damage and is currently listing to port side. " +
                "\nAs the ship sags, a short, portly man begins to saunter down the walk way calling out. " +
                "\n'Listen here, kid. I've been from one side of the galaxy to the other and I've never found someone " +
                "\nthat can help me complete this here madlibs I got from the back seat pocket of a 1982 Volvo 200.' " +
                "\nHe looks fairly dishevelled and like he's been living in this deteriorating ship for a little too long.. He smells like " +
                "\nmicrowaved frozen food and regret. You're not sure if you should follow him in but some unknown force compels you... " +
                "\n " +
                "\nYou would later find out that this unknown force is called 'The continuation of the plot' " +
                "\n " +
                "\nHe ushers you inside, pours you a glass of blue milk, and kicks his feet up on the circular table between you. ");
        io.displayText("'Alright, give me an area of the office.' ");
        io.displayPrompt("> ");
        String area1 = io.receiveInput();
        io.displayText("'Alright, give me an adverb. No colors. Looking at you, Zach.'");
        io.displayPrompt("> ");
        String adverb1 = io.receiveInput();
        io.displayText("'Now, give me an adjective.' ");
        io.displayPrompt("> ");
        String adjective1 = io.receiveInput();
        io.displayText("'Without thinking too hard, give me the last drink you regretted having.\n \n Look, that's what it says. Quit giving me that look.' ");
        io.displayPrompt("> ");
        String booze1 = io.receiveInput();
        io.displayText("'This is fun, just asking people questions. I should have been a therapist. \nHow does giving me a verb ending with 'ing' make you feel?'");
        io.displayPrompt("> ");
        String verbing1 = io.receiveInput();
        io.displayText("'Adverb me, bro.' ");
        io.displayPrompt("> ");
        String adverb2 = io.receiveInput();
        io.displayText("Adjectives all day! Sorry, I got excited. Ahem. I need an adjective. ");
        io.displayPrompt("> ");
        String adjective2 = io.receiveInput();
        io.displayText("Another location, please. Someplace nice. Or not. It's your madlibs, I'm not the boss of you.");
        io.displayPrompt("> ");
        String location1 = io.receiveInput();
        io.displayText("This is gonna sound strange but.. A liquid. \nI'm trusting you on this one. ");
        io.displayPrompt("> ");
        String liquid1 = io.receiveInput();
        io.displayText("I'm extending a lot of trust with this one too. Name a body part. Don't be nasty, ya'll. ");
        io.displayPrompt("> ");
        String bodypart = io.receiveInput();
        io.displayText("Ok, you can't mess this one up too bad. A verb.  ");
        io.displayPrompt("> ");
        String verb1 = io.receiveInput();



        io.displayText("'If you are traveling through the " + area1 + " and find yourself having to wade through a swathe of Bootcampers, here's how to do it " + adverb1 + ": " +
                "\n 1. Bootcampers are more " +adjective1 + " during the day, so cross the area at night. " +
                "\n 2. Avoid areas of the " + area1+ "if there are empty " +booze1+ " bottles nearby. This is self explanatory. " +
                "\n 3. When " +verbing1+ " the area, move " +adverb2+". You don't want to agitate them and make them " +adjective2+ "! " +
                "\n 4. Whatever you do, if you have an open wound try to find another way back to " +location1+". Bootcampers are attracted to fresh" +
                "\n" +liquid1+ " and will most likely try to take a bite out of your "+bodypart+" if you " +verb1+" in the office!' " +
                "\n \n \n Han Incredibly Solo uses the madlibs to knock some hot pocket crumbs off of his chest, kicking his feet off the table and looking at the small piece of paper " +
                "\n with a sour look on his face. 'Man, it sounds like someone just googled a madlibs, found one about piranhas and just " +
                "\n replaced the word 'piranha' with the word 'bootcamper' to make it somewhat relevant. Meh. Whatever, here, take this.'" +
                "\n The lonely Han gives you a Hokey Religion." );
    }


}
