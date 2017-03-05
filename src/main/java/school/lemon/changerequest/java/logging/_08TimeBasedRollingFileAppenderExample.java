package school.lemon.changerequest.java.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class _08TimeBasedRollingFileAppenderExample {

    private static final Logger logger = LoggerFactory.getLogger(_08TimeBasedRollingFileAppenderExample.class);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; ++i) {
            logger.info(String.format("It's a message #%d!", i));
            if (i % 100 == 0) {
                Thread.sleep(500);
            }
        }
    }

}
