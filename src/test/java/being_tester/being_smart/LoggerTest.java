package being_tester.being_smart;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class LoggerTest extends BaseTest{
	
	private static final Logger logger = LogManager.getLogger(LoggerTest.class);
	

@Test
public void logTest() {
	logger.info("info hello world");
}
}
