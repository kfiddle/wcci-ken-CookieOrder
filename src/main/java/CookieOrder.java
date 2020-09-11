import java.util.ArrayList;

public class CookieOrder {
    int typeIndex;
    public static final String[] TYPES = {null, "thin mints", "lemon-ups", "s'mores", "tagalongs", "caramel deLites", "lemonades",
            "shortbread trefoils", "toffee-tastics"};

    private int numBoxes;

    public CookieOrder() {

    }

    public CookieOrder(int type, int boxes) {
        this.typeIndex = type;
        numBoxes = boxes;
    }


    public int getBoxes() {
        return numBoxes;
    }

    public String toString() {
        return numBoxes + " boxes of " + TYPES[this.typeIndex];
    }

    public boolean contains(int type) {
        if (typeIndex == type) {
            return true;
        }
        return false;
    }

    public boolean contains(String givenType) {
        int index = 0;
        for (int i = 0; i < TYPES.length; i++) {
            if (givenType.equals(TYPES[i])) {

                index = i;
            }
        }
        if (typeIndex == index) {
            return true;
        }
        return false;
    }

    public void addBoxes(int moreBoxes) {
        numBoxes += moreBoxes;
    }
    public void subtractBoxes(int lessBoxes){
        numBoxes -= lessBoxes;
    }
}


