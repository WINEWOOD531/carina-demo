package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.gsmArenaPages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GsmArenaTest implements IAbstractTest {

    @Test
    public void testVerifyGlossaryTextByAlphabets() {
        GsmArenaHomePage homePage = new GsmArenaHomePage(getDriver());
        homePage.open();
        GlossaryPage glossaryPage = homePage.getFooterMenu().openGlossaryPage();
        Assert.assertTrue(glossaryPage.isPageOpened(), "Glossary Page isn't opened");
        Assert.assertTrue(glossaryPage.verifyHeaderAndTextEquality(), "Header and text items don't match");
        Assert.assertTrue(glossaryPage.verifyAlphabeticalOrder(glossaryPage.glossaryItem));
    }

    @Test
    public void verifyBrandNameSearch() {
        final String BRAND_NAME = "BlackBerry";
        GsmArenaHomePage homePage = new GsmArenaHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        GsmArenaHamburgerMenu hamburgerMenu = homePage.getTopMenu().openHamburgerMenu();
        Assert.assertTrue(hamburgerMenu.verifyPhoneSearchButtonPresence(), "Phone Search button is not absent");
        GsmArenaSearchPage searchPage = hamburgerMenu.openPhoneFinderPage();
        Assert.assertTrue(searchPage.isPageOpened(), "Page is not opened");
        searchPage.selectBrand(BRAND_NAME);
        Assert.assertTrue(searchPage.isSearchButtonPresent(), "Search button is absent");
        String titleSearchResult = searchPage.getSearchResultText();
        PhoneSearchResultPage resultPage = searchPage.pressSearch();
        Assert.assertTrue(resultPage.isTextPresent(titleSearchResult));
        Assert.assertTrue(resultPage.verifySearchByCurrentBrand(BRAND_NAME));
        Assert.assertTrue(resultPage.isBtnClickHerePresent(), "Click here button is missing");
        searchPage = resultPage.pressClickHereBtn();
        Assert.assertTrue(searchPage.isPageOpened(), "Search Page is not opened");
    }
}
