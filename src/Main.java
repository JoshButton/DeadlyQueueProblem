/*
This simple interactive story shows the "safe" position in a queue of people waiting to die.
A number of people are skipped each time someone is chosen to die. The queue loops.

Brief:
People are standing in a queue waiting to be executed. Counting begins at the beginning of the queue and
proceeds around the queue, restarting from the beginning when necessary.
After a specified number k of people are skipped, the next person is executed.
The procedure is repeated with the remaining people, starting with the next person, going in the same
direction and skipping the same number k of people, until only one person remains, and is freed.
Write a java a program that, given the number of people and number k to be skipped, find out the position
in the queue to avoid execution

 @author Joshua Button
 @version 0.1
 @date 25/01/2019
 @website www.joshuabutton.co.uk
 */


import java.util.*;

public class Main {

    public static void main(String[] args) {
        
        ArrayList<String> deathQueue = new ArrayList<>();
        deathQueue.add("Elizabeth");
        deathQueue.add("Sonya");
        deathQueue.add("Eloise");
        deathQueue.add("James");
        deathQueue.add("Imogen");
        deathQueue.add("Josh");
        
        String chosenPerson = "";

        System.out.println("Welcome to the town square...");
        sleep(1000);
        System.out.println("Today we are executing traitors. But one shall be set free to go tell their friends.");
        sleep(3000);
        System.out.println("Here is a list of the traitors: " + deathQueue.toString().replace("[", "").replace("]", ""));
        sleep(4000);
        System.out.println();
        System.out.println("You are the executioner. Choose a number and we will kill every such person until only one is left.");
        sleep(4000);
        System.out.print("Choose your number: ");
        Scanner kb = new Scanner(System.in);
        int roulette = kb.nextInt();
        while(roulette <= 1){
            System.out.print("Ma'am! You need to choose a number greater than 1! Please choose again: ");
            roulette = kb.nextInt();
        }
        System.out.println();
        calculateSafeSpot(roulette, deathQueue);
        sleep(4000);
        System.out.println("\nYes ma'am, we shall kill every " + ordinal(roulette) + " person. Starting with...");
        Iterator<String> deathChooser = deathQueue.iterator();
        sleep(2000);
        while(deathQueue.size() > 1){
            for(int i = 0; i < roulette; i++){
                if (deathChooser.hasNext()) {
                    chosenPerson = deathChooser.next();
                    if(i == (roulette -1)){
                        System.out.println(chosenPerson + "...");
                        sleep(2000);
                    }
                    else {
                        System.out.println(chosenPerson + " *spared*");
                        sleep(1000);
                    }
                }
                else{
                    deathChooser = deathQueue.iterator();
                    i--;
                }
            }
            deathChooser.remove();
            System.out.println(chosenPerson + " has been killed!");
            sleep(3000);
            System.out.println();
        }
        sleep(2000);
        String survivor = deathQueue.toString().replace("[", "").replace("]", "");
        System.out.println( survivor + " is the last person alive, they are set free.");
        sleep(3000);
        System.out.println("*" + survivor + " runs into the distance to tell their friends of the horrors in the town square*");
        sleep(5000);
        System.out.print("\nTHE SHOW IS OVER! TIME TO LEAVE!");
        sleep(2000);
    }


    private static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
        }
    }

    private static String ordinal(int i) {
        int mod100 = i % 100;
        int mod10 = i % 10;
        if(mod10 == 1 && mod100 != 11) {
            return i + "st";
        } else if(mod10 == 2 && mod100 != 12) {
            return i + "nd";
        } else if(mod10 == 3 && mod100 != 13) {
            return i + "rd";
        } else {
            return i + "th";
        }
    }

    private static void calculateSafeSpot(int k, ArrayList deathQueue) {
        ArrayList<String> calculateQueue = new ArrayList<>();
        calculateQueue.add("0");
        calculateQueue.add("1");
        calculateQueue.add("2");
        calculateQueue.add("3");
        calculateQueue.add("4");
        calculateQueue.add("5");

        String chosenPerson = "";

        Iterator<String> calculateChooser = calculateQueue.iterator();
        while(calculateQueue.size() > 1){
            for(int i = 0; i < k; i++){
                if (calculateChooser.hasNext()) {
                    chosenPerson = calculateChooser.next();
                }
                else{
                    calculateChooser = calculateQueue.iterator();
                    i--;
                }
            }
            calculateChooser.remove();
        }
        String survivor = calculateQueue.toString().replace("[", "").replace("]", "");
        int position = Integer.parseInt(survivor);

        System.out.println("***Spot \'" + survivor + "\' is the safest spot in the queue. This would be the " + ordinal(position + 1) + " position in a physical queue.***");
        sleep(5000);
        System.out.println("***This should mean that " + deathQueue.get(position) + " will survive. Lets find out...***");
    }
}





