import java.sql.SQLOutput;
import java.util.Scanner;

public class OrderApp {
    Scanner input = new Scanner(System.in);
    CookieOrder order = new CookieOrder();
    MasterOrder completeOrder = new MasterOrder();
    int nextChoice = 0;
    int orderNumber = 0;

    public void displayCookies() {
        System.out.println();
        System.out.println(" 1. thin mints\n 2. lemon-ups\n 3. s'mores\n 4. tagalongs \n 5. caramel deLites\n 6. lemonades\n" +
                " 7. shortbread trefoils\n 8. toffee-tastics\n");
    }

    public void diplayChangeOptions() {
        System.out.println();
        System.out.println("You can...\n" +
                " 1. continue to add to your order.\n 2. add boxes to an existing order.\n 3. remove boxes from an existing order.\n 4. Completely remove a cookie type\n" +
                " 5. If you really hate me, you can shut the door on me forever.");
    }


    public int validInteger(int range) {
        int response = 0;
        while (!input.hasNextInt()) {
            System.out.println("come on now...just a number.");
            input = new Scanner(System.in);
        }
        response = input.nextInt();

        while (response > range) {
            System.out.println("nice try. That's not an option I can deal with.");
            response = input.nextInt();
        }
        return response;
    }


    public void go() {
        System.out.println();
        System.out.println("I'm quite sure that you haven't bought girl scout cookies in years. It's time");
        System.out.println("So, have at it. You wouldn't deny a kid selling cookies, unless you're inhuman.");
        System.out.println();
    }




    public void nextChoiceLoop() {
        int boxes = 0;

        while (true) {

            completeOrder.showOrder();
            diplayChangeOptions();
            nextChoice = validInteger(5);
            if (nextChoice == 1) {
                break;

            } else if (nextChoice == 2) {
                System.out.println("very wise.");
                if (completeOrder.orders.size() == 1) {
                    System.out.println("...and how many boxes would you like to add?");
                    boxes = validInteger(100);
                    completeOrder.orders.get(0).addBoxes(boxes);
                } else {
                    System.out.println("to which order?");
                    completeOrder.showOrder();
                    orderNumber = validInteger(completeOrder.orders.size());
                    System.out.println("and how many more boxes of " + completeOrder.orders.get(orderNumber - 1) + "?");
                    boxes = validInteger(100);
                    completeOrder.orders.get(orderNumber - 1).addBoxes(boxes);

                }
            } else if (nextChoice == 3) {
                if (completeOrder.orders.size() == 1) {
                    System.out.println("That's unfortunate. How many are you gonna drop?");
                    boxes = validInteger(completeOrder.orders.get(0).getBoxes());
                    completeOrder.orders.get(0).subtractBoxes(boxes);
                } else {
                    System.out.println("Have it your way. To which order are we losing boxes?");
                    completeOrder.showOrder();
                    orderNumber = validInteger(completeOrder.orders.size());
                    System.out.println("and how many boxes of " + completeOrder.orders.get(orderNumber - 1) + " you dumping?");
                    boxes = validInteger(completeOrder.orders.get(orderNumber).getBoxes());
                    completeOrder.orders.get(orderNumber - 1).subtractBoxes(boxes);
                }

            } else if (nextChoice == 4) {
                if (completeOrder.orders.size() == 1) {
                    System.out.println("Really? ok...we'll start from the beginning.");
                } else {
                    System.out.println("Which cookie variety would you like to remove entirely?");
                    completeOrder.showCurrentCookies();
                    //orderNumber = validInteger()
                    //completeOrder.removeVariety(orderNumber);
                }
            } else if (nextChoice == 5) {
                System.out.println("fine. Nice doing business with you. See ya.");
                System.exit(0);
            }
        }
    }

    public void looping() {
        int cookieChoice = 0;
        int firstLoopRun = 0;
        while (true) {
            if (firstLoopRun > 0) {
                nextChoiceLoop();
            }
            displayCookies();
            System.out.println("What kind of cookie would you like? Just type a number please.");
            cookieChoice = validInteger(8);
            System.out.println("And how many boxes of these?");
            int boxes = validInteger(100);
            order = new CookieOrder(cookieChoice, boxes);
            completeOrder.addOrder(order);
            System.out.println("thanks. You're old. What's next? So far, we have...");
            System.out.println();
            firstLoopRun++;
        }
    }


    public static void main(String[] args) {

        OrderApp ordering = new OrderApp();
        ordering.go();
        ordering.looping();

    }
}


