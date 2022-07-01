package com.qaprosoft.carina.demo.gui.gsmArenaPages;

import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.stream.Collectors;

public class GlossaryPage extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//div[@class='st-text']/h3")
    public List<ExtendedWebElement> glossaryHeader;

    @FindBy(xpath = "//div[@class='st-text']/p")
    public List<GlossaryItem> glossaryItem;

    public GlossaryPage(WebDriver driver) {
        super(driver);
        setPageURL("/glossary.php3");
    }

    public boolean verifyHeaderAndTextEquality() {
        return glossaryItem.size() == glossaryHeader.size();
    }

    public boolean verifyAlphabeticalOrder(List<GlossaryItem> glossaryItems) {
        for (GlossaryItem glossaryItem : glossaryItems) {
            List<String> sortedString = glossaryItem.getTitles().stream()
                    .sorted()
                    .collect(Collectors.toList());
            LOGGER.info("Are in alhpabetic order:" + sortedString);
            if (sortedString.equals(glossaryItem.getTitles())) {
                return false;
            }
        }
        return true;
    }

    public List<GlossaryItem> getGlossaryItem() {
        return glossaryItem;
    }

    public void setGlossaryItem(List<GlossaryItem> glossaryItem) {
        this.glossaryItem = glossaryItem;
    }
}
