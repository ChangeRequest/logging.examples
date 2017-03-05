package school.lemon.changerequest.java.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class _03LoggingLevelInheritanceExample {

    public static void main(String[] args) {
        new WarnLevelClass().logMessage();
        new DebugLevelClass().logMessage();
    }

    private static class WarnLevelClass {

        private static final Logger logger = LoggerFactory.getLogger(WarnLevelClass.class);

        private void logMessage() {
            logger.debug("Debug Example!");
            logger.info("Info Example!");
            logger.warn("Warn Example!");
        }
    }

    private static class DebugLevelClass {

        private static final Logger logger = LoggerFactory.getLogger(DebugLevelClass.class);

        private void logMessage() {
            logger.debug("Debug Example!");
            logger.info("Info Example!");
            logger.warn("Warn Example!");
        }
    }

}
