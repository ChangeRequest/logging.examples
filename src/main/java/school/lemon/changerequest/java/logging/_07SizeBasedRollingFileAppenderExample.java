package school.lemon.changerequest.java.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class _07SizeBasedRollingFileAppenderExample {

    private static final Logger logger = LoggerFactory.getLogger(_07SizeBasedRollingFileAppenderExample.class);

    public static void main(String[] args) {
        for (int i = 0; i < 1000; ++i) {
            logger.info(String.format("It's a message #%d!", i));
        }
    }

}
