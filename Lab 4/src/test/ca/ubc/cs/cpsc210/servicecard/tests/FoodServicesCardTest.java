package ca.ubc.cs.cpsc210.servicecard.tests;

import ca.ubc.cs.cpsc210.servicecard.model.FoodServicesCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


// Unit tests for FoodServiceCard class
class FoodServicesCardTest {
    FoodServicesCard testCard;


    @BeforeEach
    public void setUp() {
        testCard = new FoodServicesCard(0);
    }


    @Test
    public void reloadTest() {
        testCard.reload(1000);
        assertEquals(1000, testCard.getBalance());
    }

    @Test
    public void makePurchaseNotEnoughMoneyTest() {
        testCard.reload(5);
        assertFalse(testCard.makePurchase(10));
        assertEquals(5, testCard.getBalance());
        assertEquals(0, testCard.getRewardPoints());
    }


    @Test
    public void makePurchaseEnoughMoneyNoCashBackTest() {
        testCard.reload(1000);
        assertTrue(testCard.makePurchase(10));
        assertEquals(1000-10, testCard.getBalance());
        assertEquals(10, testCard.getRewardPoints());
    }





    @Test
    public void makePurchaseEnoughMoneyWithCashBackOnceTest() {
        testCard.reload(2000);
        assertTrue(testCard.makePurchase(2000));
        assertEquals(10, testCard.getBalance());
        assertEquals(0, testCard.getRewardPoints());

    }

    @Test
    public void makePurchaseEnoughMoneyWithMultipleCashBacks() {
        testCard.reload(5000);
        assertTrue(testCard.makePurchase(4000));
        assertEquals(1000, testCard.getBalance());
        assertEquals(0, testCard.getRewardPoints());
    }

}