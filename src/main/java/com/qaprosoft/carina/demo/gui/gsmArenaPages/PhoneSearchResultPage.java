package com.qaprosoft.carina.demo.gui.gsmArenaPages;
import java.lang.invoke.MethodHandles;
import java.util.List;


import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
public class PhoneSearchResultPage extends AbstractPage{
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final String TITLE_RESULT_PAGE = "Phone finder results";

    @FindBy(xpath = "//h1[@class='article-info-name']")
    private ExtendedWebElement resultTitlePage;

    @FindBy(xpath = "//div[@class='st-text']")
    private ExtendedWebElement resultText;

    @FindBy(xpath = "//div[@class='makers']//span")
    private List<ExtendedWebElement> phoneResult;

    @FindBy(xpath = "//a[contains(text(),'click here')]")
    private ExtendedWebElement clickHereBtn;

    public PhoneSearchResultPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return resultTitlePage.getText().equals(TITLE_RESULT_PAGE);
    }

    public boolean isBtnClickHerePresent() {
        return clickHereBtn.isPresent();
    }

    public GsmArenaSearchPage pressClickHereBtn(){
        LOGGER.info("Press if you want to return to Search Page");
        clickHereBtn.click();
        return new GsmArenaSearchPage(getDriver());
    }

    public boolean isTextPresent(String resultTextBtn) {
        final String searchText = "Your search returned " + resultTextBtn + ".";
        final String refineText = "To refine your search click here.";
        LOGGER.info("Check for containsn searchText" + searchText);
        LOGGER.info("Check for containsn searchText" + refineText);
        return StringUtils.containsIgnoreCase(resultText.getText(), searchText)
                & StringUtils.containsIgnoreCase(resultText.getText(), refineText);
    }

    public boolean verifySearchByCurrentBrand(String modelPhone) {
        LOGGER.info("Сheck for presence in the title " + modelPhone);
        for (ExtendedWebElement model : phoneResult) {
            if (!StringUtils.containsIgnoreCase(model.getText(), modelPhone)) {
                LOGGER.error("This model not include " + modelPhone);
                return false;
            }
        }
        return true;
    }

}
