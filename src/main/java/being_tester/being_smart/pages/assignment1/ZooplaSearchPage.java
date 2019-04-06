package being_tester.being_smart.pages.assignment1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import being_tester.being_smart.pages.BasePage;

public class ZooplaSearchPage extends BasePage {
	private static final Logger logger = LogManager.getLogger(ZooplaSearchPage.class);

	@FindBy(css = "input#search-input-location")
	private WebElement locationSearchBox;
	@FindBy(css = "button#search-submit")
	private WebElement searchBtn;
	@FindBy(css = "img.icon--logo")
	private WebElement pageTitleLogo;
	@SuppressWarnings("unused")
	private ZooplaSearchPage() {}

	public ZooplaSearchPage(WebDriver driver2) {
		driver=driver2;
		PageFactory.initElements(driver, this);
		try {
			if (pageTitleLogo.isDisplayed()) {
				logger.info("zoopla search page loaded");
			}
		} catch (Exception ignore) {
			logger.error("zoopla search page NOT loaded, error as : " + ignore.getMessage());
		}

	}

	public ZooplaSearchPage setLocation(String locationName) {
		locationSearchBox.clear();
		logger.info(String.format("set [%s] as searchLocation",locationName));
		locationSearchBox.sendKeys(locationName);
		return this;
	}

	public void clickSearch() {
		logger.info("click on [search] button");
		searchBtn.click();
	}
}