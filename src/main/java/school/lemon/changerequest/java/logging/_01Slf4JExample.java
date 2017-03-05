package school.lemon.changerequest.java.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class _01Slf4JExample {

    private static final Logger logger = LoggerFactory.getLogger(_01Slf4JExample.class);

    public static void main(String[] args) {
        logger.info("Info Example!");
        logger.debug("Debug Example!");
        logger.trace("Trace Example!");
    }

}
