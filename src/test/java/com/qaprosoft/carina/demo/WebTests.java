package com.qaprosoft.carina.demo;

import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.myClassesForGui.HomePageTest;
import com.qaprosoft.carina.demo.gui.myClassesForGui.InventoryPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.invoke.MethodHandles;

public class WebTests implements IAbstractTest {
    private static final String USER_NAME = "standard_user";
    private static final String USER_PASSWORD = "secret_sauce";
    private static final String FAIL_USER_NAME = "Username";
    private static final String FAIL_USER_PASSWORD = "1234567";
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    HomePageTest homePageTest = new HomePageTest(getDriver());
    final String expectedErrorMessageUserName = "Epic sadface: Username is required";
    final String expectedErrorMessagePassword = "Epic sadface: Password is required";


    @Test
    public void testLoginPageEmptyFields() {
        homePageTest.open();
        Assert.assertTrue(homePageTest.isPageOpened(), "Home page is not opened!");
        homePageTest.clickLoginButton();
        Assert.assertTrue(homePageTest.isPageOpened(), "Home page is not opened!");
        Assert.assertTrue(homePageTest.isErrorButtonPresent(), "Error button is absent");
        Assert.assertTrue(homePageTest.isErrorIconPresent(), "Error icon is absent");
        String actualErrorMessage = homePageTest.getErrorMessage();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessageUserName, "Actual and Expected results are different");

    }

    @Test
    public void testHomeTitle() {
        homePageTest.open();
        Assert.assertTrue(homePageTest.isTitlePresent(), "Home page title isn`t present");
    }


    @Test
    public void testFailLogin() {
        homePageTest.open();
        Assert.assertNotEquals(homePageTest.checkUsernameTextField(), FAIL_USER_NAME, "User name is equals");
        Assert.assertNotEquals(homePageTest.checkPasswordTextField(), FAIL_USER_PASSWORD, "Password is equals");
        homePageTest.clickLoginButton();
        Assert.assertTrue(homePageTest.isErrorMessagePresent(), "Error message isn`t present");
    }

    @Test
    public void testCorrectUserName() {
        homePageTest.open();
        Assert.assertTrue(homePageTest.isPageOpened(), "Home page is not opened");
        homePageTest.typeUserName(USER_NAME);
        homePageTest.clickLoginButton();
        Assert.assertTrue(homePageTest.isPageOpened(), "Home page is not opened!");
        Assert.assertTrue(homePageTest.isErrorButtonPresent(), "Error button is absent");
        Assert.assertTrue(homePageTest.isErrorIconPresent(), "Error icon is absent");
        String actualErrorMessage = homePageTest.getErrorMessage();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessagePassword, "Actual and Expected results are different");
    }

    @Test
    public void testRightPosition() {
        homePageTest.open();
        Assert.assertTrue(homePageTest.checkLocationUsername(), "Username field is not above password field");
        Assert.assertTrue(homePageTest.checkLocationLoginBtn(), "Login button is not below password field");
    }

    @Test
    public void testProductItemCard() {
        homePageTest.open();
        InventoryPage inventoryPage = homePageTest.loginToAccount(USER_NAME, USER_PASSWORD);
        Assert.assertTrue(inventoryPage.isInventoryItemImgPresent(), "Inventory item img is not present");
        Assert.assertTrue(inventoryPage.isInventoryItemNamePresent(), "Inventory item name is not present");
        Assert.assertTrue(inventoryPage.isInventoryItemDescPresent(), "Inventory item description is not present");
        Assert.assertTrue(inventoryPage.isInventoryItemPricePresent(), "Inventory item price is not present");
        Assert.assertTrue(inventoryPage.isAddToCartButtonPresent(), "Add to cart button is not present");
    }

    @Test
    public void testProductSort() {
        homePageTest.open();
        InventoryPage inventoryPage = homePageTest.loginToAccount(USER_NAME, USER_PASSWORD);
        Assert.assertTrue(inventoryPage.isSort_AZ_Present(), "Sort A-Z isn`t present");
        Assert.assertTrue(inventoryPage.isSort_ZA_Present(), "Sort Z-A isn`t present");
        Assert.assertTrue(inventoryPage.isSortHighToLowPresent(), "Sort High to Low isn`t present");
        Assert.assertTrue(inventoryPage.isSortLowToHighPresent(), "Sort Low to High isn`t present");
    }

    @Test
    public void testDropDownFilterMenu() {
        homePageTest.open();
        InventoryPage inventoryPage = homePageTest.loginToAccount(USER_NAME, USER_PASSWORD);
        Assert.assertTrue(inventoryPage.clickSort_ZA(), "(Z-A) filter isn`t present");
        Assert.assertTrue(inventoryPage.clickSort_AZ(), "(A-Z) filter isn`t present");
    }

    @Test
    public void testSortByAlphabetical() {
        homePageTest.open();
        InventoryPage inventoryPage = homePageTest.loginToAccount(USER_NAME, USER_PASSWORD);
        Assert.assertTrue(inventoryPage.checkSortProducts_AZ(), "The array is not sorted correctly.");
        Assert.assertTrue(inventoryPage.clickSort_ZA(), "(Z-A) filter isn`t present");
        Assert.assertTrue(inventoryPage.checkSortProducts_ZA(), "The array is not sorted correctly.");
    }

    @Test
    public void testDropdownElementFilterMenu() {
        homePageTest.open();
        Assert.assertTrue(homePageTest.isPageOpened(), "Home page is not opened!");
        InventoryPage inventoryPage = homePageTest.loginToAccount(USER_NAME, USER_PASSWORD);

        Assert.assertFalse(inventoryPage.isPageOpened(), "Inventory/Products page is not opened!");
        Assert.assertEquals(inventoryPage.DropdownName(), "NAME (A TO Z)", "Default dropdown name is incorrect");
        inventoryPage.clickOnDropdown();
        Assert.assertEquals(inventoryPage.selectOption(), "Price (low to high)", "Option doesn't selected");
    }

}
