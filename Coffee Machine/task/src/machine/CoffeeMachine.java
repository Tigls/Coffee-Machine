package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var work = true;

        // Initialize
        var machine = new MachineState(400, 540, 120, 550, 9);

        while (work) {
            System.out.println();
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            var action = scanner.next();
            if (action.toUpperCase().equals(Actions.BUY.name())) {
                machine.buy(scanner);
            } else if (action.toUpperCase().equals(Actions.FILL.name())) {
                machine.fill(scanner);
            } else if (action.toUpperCase().equals(Actions.TAKE.name())){
                machine.take();
            } else if (action.toUpperCase().equals(Actions.REMAINING.name())){
                machine.printState();
            } else if (action.toUpperCase().equals(Actions.EXIT.name())){
                work = false;
            }
        }
    }

}
