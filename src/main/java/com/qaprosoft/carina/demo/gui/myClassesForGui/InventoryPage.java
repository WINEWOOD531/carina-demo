package com.qaprosoft.carina.demo.gui.myClassesForGui;

import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InventoryPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(className = "shopping_cart_link")
    private ExtendedWebElement shoppingCart;

    @FindBy(xpath = "//span[@class='title']")
    private ExtendedWebElement titleProducts;

    @FindBy(className = "inventory_item_img")
    private ExtendedWebElement inventoryItemImg;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private ExtendedWebElement inventoryItemName;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private List<ExtendedWebElement> productNames;

    @FindBy(xpath = "//div[@class='inventory_item_desc']")
    private ExtendedWebElement inventoryItemDesc;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    private ExtendedWebElement inventoryItemPrice;

    @FindBy(xpath = "//button[contains(@id,'add-to-cart')]")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//option[@value='az']")
    private ExtendedWebElement productSortAZ;

    @FindBy(xpath = "//option[@value='za']")
    private ExtendedWebElement productSortZA;

    @FindBy(xpath = "//option[@value='lohi']")
    private ExtendedWebElement productSortLow_To_High;

    @FindBy(xpath = "//*[@id='header_container']/div[2]/div[2]/span/select/option[3]")
    private ExtendedWebElement optionPriceLowToHigh;
    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[4]")
    private ExtendedWebElement optionDropdownByPriceHighToLow;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div[2]/span/span")
    private ExtendedWebElement activeOptionDropdownMenu;

    @FindBy(xpath = "//option[@value='hilo']")
    private ExtendedWebElement productSortHigh_To_Low;

    @FindBy(xpath = "//span[text()='Name (A to Z)']")
    private ExtendedWebElement activeOptionSort_AZ;

    @FindBy(xpath = "//span[text()='Name (Z to A)']")
    private ExtendedWebElement activeOptionSort_ZA;

    @FindBy(className = "bm-burger-button")
    private ExtendedWebElement menuButton;

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isShoppingCartPresent() {
        return shoppingCart.isPresent(5);
    }

    public boolean isTitleProductsPresent() {
        return titleProducts.isElementPresent(5);
    }

    public boolean isInventoryItemImgPresent() {
        return inventoryItemImg.isElementPresent();
    }

    public boolean isInventoryItemNamePresent() {
        return inventoryItemName.isElementPresent();
    }

    public boolean isInventoryItemDescPresent() {
        return inventoryItemDesc.isElementPresent();
    }

    public boolean isInventoryItemPricePresent() {
        return inventoryItemPrice.isElementPresent();
    }

    public boolean isAddToCartButtonPresent() {
        return addToCartButton.isElementPresent();
    }

    public boolean isSort_AZ_Present() {
        return productSortAZ.isElementPresent();
    }

    public boolean isSort_ZA_Present() {
        return productSortZA.isElementPresent();
    }

    public boolean isSortHighToLowPresent() {
        return productSortHigh_To_Low.isElementPresent();
    }

    public boolean isSortLowToHighPresent() {
        return productSortLow_To_High.isElementPresent();
    }

    public boolean clickSort_ZA() {

        productSortZA.click();
        LOGGER.info("Product sort (Z-A) is clicked");
        activeOptionSort_ZA.isElementPresent();
        LOGGER.info("(Z-A) filter is selected");
        return true;
    }

    public boolean clickSort_AZ() {

        productSortAZ.click();
        LOGGER.info("Product sort (A-Z) is clicked");
        activeOptionSort_AZ.isElementPresent();
        LOGGER.info("(A-Z) filter is selected");
        return true;
    }

    public boolean checkSortProducts_AZ() {

        List<String> productNamesList = new ArrayList<>();
        List<String> testList = new ArrayList<>();

        for (ExtendedWebElement prodName : productNames) {
            productNamesList.add(prodName.getText());
            LOGGER.info("Added to list: " + prodName.getText());
        }

        testList.addAll(productNamesList);
        Collections.sort(testList);

        LOGGER.info("Initial array" + productNamesList.toString());
        LOGGER.info("Sorted array" + testList.toString());

        return testList.equals(productNamesList);
    }

    public boolean checkSortProducts_ZA() {

        List<String> productNamesList = new ArrayList<>();
        List<String> testList = new ArrayList<>();

        for (ExtendedWebElement prodName : productNames) {
            productNamesList.add(prodName.getText());
            LOGGER.info("Added to list: " + prodName.getText());
        }

        testList.addAll(productNamesList);

        Collections.sort(testList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        LOGGER.info("Initial array" + productNamesList.toString());
        LOGGER.info("Sorted array" + testList.toString());

        return testList.equals(productNamesList);
    }

    public String selectOption() {
        return optionPriceLowToHigh.getText();
    }

    public boolean clickOnDropdown() {
        optionPriceLowToHigh.click();
        return false;
    }

    public String DropdownName() {
        return activeOptionDropdownMenu.getText();
    }

    public String getActiveOptionDropdownMenu() {
        return activeOptionDropdownMenu.getText();
    }

    public void clickPriceHighToLow() {
        optionDropdownByPriceHighToLow.click();
    }

    public boolean isMenuButtonPresent() {
        return menuButton.isElementPresent();
    }
}
