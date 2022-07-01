package com.qaprosoft.carina.demo.gui.gsmArenaPages;

import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.FooterMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.lang.invoke.MethodHandles;


public class GsmArenaHomePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id = "header")
    private GsmArenaTopMenu topMenu;

    @FindBy(id = "footmenu")
    private FooterMenu footerMenu;

    @FindBy(className = "news-column-index")
    private ExtendedWebElement newsColumn;

    public GsmArenaHomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(newsColumn);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public GsmArenaTopMenu getTopMenu() {
        return topMenu;
    }

    public FooterMenu getFooterMenu() {
        return footerMenu;
    }

}
