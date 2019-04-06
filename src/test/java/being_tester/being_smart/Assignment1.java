package being_tester.being_smart;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import being_tester.being_smart.pages.assignment1.AgentDetailsPage;
import being_tester.being_smart.pages.assignment1.PropertyDetailsPage;
import being_tester.being_smart.pages.assignment1.PropertyForSalePage;
import being_tester.being_smart.pages.assignment1.ZooplaSearchPage;

public class Assignment1 extends BaseTest {
	private static final Logger logger = LogManager.getLogger(Assignment1.class);

	@Test
	public void testAssignment1() {
		logger.debug("testAssignment1 started...");
		ZooplaSearchPage searchPage = new ZooplaSearchPage(driver);
		searchPage.setLocation("London").clickSearch();
		new PropertyForSalePage().printPropertyForSaleInReverseOrder().clickOnPropertyValue(5);
		new PropertyDetailsPage().clickOnAgentName();
		new AgentDetailsPage().verifyAgentName(PropertyDetailsPage.agentNameText);
	}

}
