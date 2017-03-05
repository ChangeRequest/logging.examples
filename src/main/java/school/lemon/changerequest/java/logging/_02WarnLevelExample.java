package school.lemon.changerequest.java.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class _02WarnLevelExample {

    private static final Logger logger = LoggerFactory.getLogger(_02WarnLevelExample.class);

    public static void main(String[] args) {
        logger.info("Info Example!");
        logger.warn("Warn Example!");
        logger.error("Error Example!");
    }

}
