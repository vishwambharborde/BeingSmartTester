package being_tester.being_smart.pages.assignment1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import being_tester.being_smart.pages.BasePage;

public class AgentDetailsPage extends BasePage {
	private static final Logger logger = LogManager.getLogger(AgentDetailsPage.class);
	@FindBy(xpath = "//h1/b[1]")
	private WebElement agentName;

	public AgentDetailsPage() {
		PageFactory.initElements(driver, this);
		try {
			if (agentName.isDisplayed()) {
				logger.info("AgentDetailsPage loaded");
			}
		} catch (Exception ignore) {
			logger.error("AgentDetailsPage NOT loaded, error as: " + ignore.getMessage());
		}
	}

	public void verifyAgentName(String lookUpAgentName) {
		String actualAgentName=agentName.getText();
		logger.info(String.format("actual agentName=[%s]",actualAgentName ));
		Assert.assertTrue(agentName.getText().contains(lookUpAgentName),String.format("agent name not found, expected:[%s], actual:[%s]", lookUpAgentName,actualAgentName));
	}

}
