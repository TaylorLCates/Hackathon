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
    private ArrayList<String> allItems = new ArrayList<>();

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


    public ArrayList<String> randomizeItems(ArrayList<String> itemList) {


        Integer[] order = {0, 1, 2, 3, 4};
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
        allItems = itemList;
        ArrayList<String> randomList = itemList;
        randomList = appeaseMasterHand.randomizeItems(randomList);
        int index = 0;

        io.displayText("The Master Hand wants your stuff.  Give him something.");

        while (masterHandAppeased == false) {



        io.displayText("");
            io.displayText("Here is what you can give him:");

            int i = 1;
            for (String item : itemList) {
                io.displayText(i + ": " + item);
                i++;
            }
            io.displayText("");
            io.displayPrompt("What item do you want to give Master Hand? Type the item number:");

            int input = io.getInteger();

            while (input> itemList.size()){
                io.displayPrompt("Please pick a valid number.");
                input = io.getInteger();
            }

//        System.out.println(itemList.get(input) + input);
//            System.out.println(randomList.get(index)+ index);

            if (itemList.get(input-1).equals(randomList.get(index))) {

                io.displayText("");
                io.displayText("Master Hand approves of your offering.  Give it another!");
                index++;

                itemList.remove(input-1);

                if (itemList.size() == 0) {
                    masterHandAppeased = true;
                }

            } else {
                io.displayText("");
                io.displayText("Master Hand throws everything back at you. It didn't want that item yet.");
                itemList.clear();
                itemList = appeaseMasterHand.addItemsToList(itemList);
                index = 0;
            }

        }
        io.displayPrompt("Your generosity has appeased Master Hand.  It give you a giant thumbs up!");
    }

}
