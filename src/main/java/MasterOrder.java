import java.util.ArrayList;
import java.util.HashSet;

public class MasterOrder {

    ArrayList<CookieOrder> orders = new ArrayList<CookieOrder>();
    int totalBoxes;

    public MasterOrder() {
    }

    public void addOrder(CookieOrder order) {
        orders.add(order);
        totalBoxes += order.getBoxes();
    }


    public int getTotalBoxes() {
        return totalBoxes;
    }

    public void removeVariety(int type) {
        orders.removeIf(order -> order.contains(type));
    }

    public int giveVarietyBoxes(String givenType) {
        int boxes = 0;
        for (CookieOrder singleOrder : orders) {
            if (singleOrder.contains(givenType)) {
                boxes += singleOrder.getBoxes();
            }
        }
        return boxes;
    }

    public void showOrder() {
        for (CookieOrder order : orders) {
            System.out.println(order);
        }
        System.out.println();
        System.out.println("You have ordered a total of " + getTotalBoxes() + " boxes.");
    }

    public void showCurrentCookies() {
        HashSet<String> cookiesList = new HashSet<String>();
        for (CookieOrder order : orders) {
            cookiesList.add(order.TYPES[order.typeIndex]);
        }
        System.out.println(cookiesList);

    }

}


