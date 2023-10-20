package requesters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

public class TestRequester {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Test
    public void testLogger(){
        LOGGER.info("This is logger!");
        LOGGER.info("Logs goes here:");
        LOGGER.warn("This is warning!");
        LOGGER.error("This is error!");
    }
}
