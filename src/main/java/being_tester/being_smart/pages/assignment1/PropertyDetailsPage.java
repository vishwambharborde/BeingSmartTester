package being_tester.being_smart.pages.assignment1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import being_tester.being_smart.pages.BasePage;

public class PropertyDetailsPage extends BasePage {
	private static final Logger logger = LogManager.getLogger(PropertyDetailsPage.class);
	@FindBy(xpath = "//span[text()='Property details']")
	private WebElement pageElement;
	@FindBy(css = "div[class='dp-sidebar-wrapper__contact'] img")
	private WebElement agentLogo;
	@FindBy(css = "div[class='dp-sidebar-wrapper__contact'] h4.ui-agent__name")
	private WebElement agentName;
	@FindBy(css = "div[class='dp-sidebar-wrapper__contact'] a.ui-link")
	private WebElement agentContact;
	public static String agentNameText;
	public PropertyDetailsPage() {
		PageFactory.initElements(driver, this);
		try {
			if (pageElement.isDisplayed()) {
				logger.info("PropertyDetailsPage loaded");
			}
		} catch (Exception ignore) {
			logger.error("PropertyDetailsPage NOT loaded, error as: " + ignore.getMessage());
		}
	}
	public void clickOnAgentName() {
		agentNameText=agentName.getText();
		logger.info(String.format("click on agent name [%s]",agentNameText));
		agentName.click();
	}

}
