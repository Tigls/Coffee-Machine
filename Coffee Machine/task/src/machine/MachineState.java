package machine;

import java.util.Scanner;

public class MachineState {
    private int water;
    private int milk;
    private int beans;
    private int money;
    private int cups;

    MachineState(int water, int milk, int beans, int money, int cups) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.money = money;
        this.cups = cups;
    }

    public void buy(Scanner scanner) {
        System.out.println();
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        switch (scanner.next()) {
            case "1":
                if (checkResources(Coffees.ESPRESSO)) {
                    prepare(Coffees.ESPRESSO);
                }
                break;
            case "2":
                if (checkResources(Coffees.LATTE)) {
                    prepare(Coffees.LATTE);
                }
                break;
            case "3":
                if (checkResources(Coffees.CAPUCHINO)){
                    prepare(Coffees.CAPUCHINO);
                }
                break;
            default:
                break;
        }
    }

    public void fill(Scanner scanner) {
        var howManyString = "Write how many %s do you want to add:";
        var waterString = "ml of water";
        var milkString = "ml of milk";
        var beansString = "grams of coffee beans";
        var cupsString = "disposable cups of coffee";

        System.out.println(String.format(howManyString, waterString));
        water += scanner.nextInt();

        System.out.println(String.format(howManyString, milkString));
        milk += scanner.nextInt();

        System.out.println(String.format(howManyString, beansString));
        beans += scanner.nextInt();

        System.out.println(String.format(howManyString, cupsString));
        cups += scanner.nextInt();
    }

    public void take() {
        System.out.println();
        System.out.println("I gave you $" + money);
        money = 0;
    }

    public void prepare(Coffees drink) {
        this.water -= drink.getWater();
        this.milk  -= drink.getMilk();
        this.beans -= drink.getBeans();
        this.money += drink.getPrice();
        this.cups  -= 1;
    }

    public void printState() {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(String.format("%s of water", water));
        System.out.println(String.format("%s of milk", milk));
        System.out.println(String.format("%s of coffee beans", beans));
        System.out.println(String.format("%s of disposable cups", cups));
        System.out.println(String.format("%s of money", money));
    }

    private boolean checkResources(Coffees drink) {
        var failResponse = "Sorry, not enough %s!";
        var successResponse = "I have enough resources, making you a coffee!";
        if (water < drink.getWater()) {
            System.out.println(String.format(failResponse, "water"));
            return false;
        } else if (milk < drink.getMilk()) {
            System.out.println(String.format(failResponse, "milk"));
            return false;
        } else if(beans < drink.getBeans()) {
            System.out.println(String.format(failResponse, "coffee beans"));
            return false;
        } else if(cups < 1) {
            System.out.println(String.format(failResponse, "cups"));
            return false;
        }
        System.out.println(successResponse);
        return true;
    }

}
