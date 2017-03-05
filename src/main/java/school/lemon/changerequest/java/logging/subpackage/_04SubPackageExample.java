package school.lemon.changerequest.java.logging.subpackage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import school.lemon.changerequest.java.logging._01Slf4JExample;

public class _04SubPackageExample {

    private static final Logger logger = LoggerFactory.getLogger(_04SubPackageExample.class);

    public static void main(String[] args) {
        logger.trace("Trace Example!");
        logger.debug("Debug Example!");
        logger.info("Info Example!");
        logger.warn("Warn Example!");
        new WarnLevelClass().logMessage();
        new TraceLevelClass().logMessage();
    }

    private static class WarnLevelClass {

        private static final Logger logger = LoggerFactory.getLogger(WarnLevelClass.class);

        private void logMessage() {
            logger.debug("Debug Example!");
            logger.info("Info Example!");
            logger.warn("Warn Example!");
        }
    }

    private static class TraceLevelClass {

        private static final Logger logger = LoggerFactory.getLogger(TraceLevelClass.class);

        private void logMessage() {
            logger.trace("Trace Example!");
            logger.debug("Debug Example!");
            logger.info("Info Example!");
            logger.warn("Warn Example!");
        }
    }

}
