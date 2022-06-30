package com.qaprosoft.carina.demo.gui.gsmArenaPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class GsmArenaHamburgerMenu extends AbstractUIObject {
    @FindBy(xpath = "//a[contains(text(),'Home')][1]")
    private ExtendedWebElement homeLink;

    @FindBy(xpath = "//a[contains(text(),'Phone Finder')][1]")
    private ExtendedWebElement phoneFinderLink;

    public GsmArenaHamburgerMenu(WebDriver driver) {
        super(driver);
    }

    public GsmArenaHamburgerMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public GsmArenaHomePage openHomePage() {
        homeLink.click();
        return new GsmArenaHomePage(driver);
    }

    public GsmArenaSearchPage openPhoneFinderPage(){
        phoneFinderLink.click();
        return new GsmArenaSearchPage(driver);
    }

    public boolean verifyPhoneSearchButtonPresence(){
        return phoneFinderLink.isPresent();
    }
}
