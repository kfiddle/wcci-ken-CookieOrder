import org.junit.Assert;
import org.junit.Test;

public class CookieOrderTest {

    @Test


    public void gettingNumberOfBoxesTest() {
    CookieOrder orderTest = new CookieOrder(1,1);
    //tested the instance variable itself as 1.
    Assert.assertEquals(0, orderTest.getBoxes());
    }

    @Test
    public void testingTypesOfCookies() {
        CookieOrder thinMintCreating = new CookieOrder(1,2);
        Assert.assertEquals(0, thinMintCreating.typeIndex);
    }

    @Test
    public void tryingToMakeAMasterOrder() {
        MasterOrder underTest = new MasterOrder();
        CookieOrder randomCookiesBox = new CookieOrder(2,5);
        underTest.addOrder(randomCookiesBox);
        Assert.assertEquals(5, underTest.getTotalBoxes());
    }

    @Test
    public void testingRemovingVariety() {
        MasterOrder underTest = new MasterOrder();
        CookieOrder randomCookies = new CookieOrder(2,5);
        CookieOrder AnotherRandomCookies = new CookieOrder(4,3);
        CookieOrder oneMoreOrder = new CookieOrder(2,8);
        underTest.addOrder(randomCookies);
        underTest.addOrder(AnotherRandomCookies);
        underTest.addOrder(oneMoreOrder);
        underTest.removeVariety(2);
        Assert.assertEquals(3, underTest.getTotalBoxes());
    }

    @Test
    public void testVarietyByGivenString() {
        CookieOrder testOrder = new CookieOrder(4,5);
        Assert.assertEquals(true, testOrder.contains("tagalongs"));

        CookieOrder nextOrder = new CookieOrder(6,3);
            Assert.assertEquals(true, nextOrder.contains("lemonades"));
        }

    @Test
    public void testHowManyBoxesOfType() {
        MasterOrder underTest = new MasterOrder();
        CookieOrder randomCookies = new CookieOrder(2,5);
        CookieOrder AnotherRandomCookies = new CookieOrder(4,3);
        CookieOrder oneMoreOrder = new CookieOrder(2,8);
        underTest.addOrder(randomCookies);
        underTest.addOrder(AnotherRandomCookies);
        underTest.addOrder(oneMoreOrder);

        Assert.assertEquals(13, underTest.giveVarietyBoxes("lemon-ups"));


    }
}














