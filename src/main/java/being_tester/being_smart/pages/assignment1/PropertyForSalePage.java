package being_tester.being_smart.pages.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import being_tester.being_smart.pages.BasePage;

public class PropertyForSalePage extends BasePage {
	private static final Logger logger = LogManager.getLogger(PropertyForSalePage.class);
	@FindAll(@FindBy(css = "div.agent_logo +a.listing-results-price.text-price"))
	private List<WebElement> listOfPropValues;
	@FindBy(xpath = "//h1[contains(text(),'Property for sale in')]")
	private WebElement pageTitle;

	public PropertyForSalePage() {
		PageFactory.initElements(driver, this);
		try {
			if (pageTitle.isDisplayed()) {
				logger.info("PropertyForSalePage loaded");
			}
		} catch (Exception ignore) {
			logger.error("PropertyForSalePage NOT loaded, error as: " + ignore.getMessage());
		}
	}

	public PropertyForSalePage printPropertyForSaleInReverseOrder() {
		List<String> propValues = new ArrayList<>();
		for (WebElement element : listOfPropValues) {
			propValues.add(element.getText());
		}
		Collections.sort(propValues, Collections.reverseOrder());
		logger.info("properties value in reverse order as:");
		for (String propValue : propValues) {
			logger.info(propValue);
		}
		return this;
	}

	public void clickOnPropertyValue(int index) {
		logger.info("click on property for sale index: " + index);
		if (index >= listOfPropValues.size()) {
			logger.error(String.format("wrong lookup propertyindex as [%s], search result property value size is[%s]",
					index, listOfPropValues.size()));
		}
		listOfPropValues.get(index - 1).click();;
	}
}
