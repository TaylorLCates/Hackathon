package org.improving.MiniGames;

import org.improving.ConsoleInputOutput;
import org.improving.domain.Item;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class AppeaseMasterHand {

    ConsoleInputOutput io;
    Collections collections;

    private Random rand = new Random();
    private ArrayList<String> itemList = new ArrayList<>();

    private Item d20 = Item.A_D20;
    private Item canOfDew = Item.CAN_OF_MOUNTAIN_DEW;
    private Item hkBackpack = Item.HELLO_KITTY_BACK_PACK;
    private Item hokeyReligion = Item.HOKEY_RELIGION;
    private Item replicaArmor = Item.REPLICA_ARMOR;


    public AppeaseMasterHand(ConsoleInputOutput io) {
        this.io = io;
    }

    public ArrayList<String> addItemsToList(ArrayList<String> list) {
        list.add(d20.getName());
        list.add(canOfDew.getName());
        list.add(hkBackpack.getName());
        list.add(hokeyReligion.getName());
        list.add(replicaArmor.getName());

        return list;
    }


    public ArrayList<String> orderItems(ArrayList<String> itemList) {

        Integer[] order = {1, 2, 3, 4, 5};
        List<Integer> orderList = new ArrayList<>();
        Collections.addAll(orderList, order);
        Collections.shuffle(orderList);

        ArrayList<String> randomItems = new ArrayList<>();

        randomItems.add(itemList.get(orderList.get(0)));
        randomItems.add(itemList.get(orderList.get(1)));
        randomItems.add(itemList.get(orderList.get(2)));
        randomItems.add(itemList.get(orderList.get(3)));
        randomItems.add(itemList.get(orderList.get(4)));

        return randomItems;
    }

    public void run() {

        AppeaseMasterHand appeaseMasterHand = new AppeaseMasterHand(io);
        boolean masterHandAppeased = false;
        appeaseMasterHand.addItemsToList(itemList);
        appeaseMasterHand.orderItems(itemList);

        io.displayText("The Master Hand wants your stuff.  Give him something.");

        while (masterHandAppeased == false) {

            boolean correctGuess = true;
            while (correctGuess) {
                Integer index = 0;
                io.displayText("");
                io.displayPrompt("What item do you want to give Master Hand?");
                String input = io.receiveInput();

                for (String item : itemList) {
                    if (input.equalsIgnoreCase(item)) {
                        io.displayText("");
                        io.displayPrompt("Master Hand approves of your offering.  Give it another!");
                    } else {
                        io.displayText("");
                        io.displayPrompt("Master Hand throws everything back at you. It didn't want that item yet.");
                        correctGuess = false;
                    }
                }
            }
        }
        io.displayPrompt("Your generosity has appeased Master Hand.  It give you a giant thumbs up!");
    }
}