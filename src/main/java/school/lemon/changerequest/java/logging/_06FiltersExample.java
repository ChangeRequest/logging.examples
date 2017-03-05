package school.lemon.changerequest.java.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class _06FiltersExample {

    private static final Logger logger = LoggerFactory.getLogger(_06FiltersExample.class);

    public static void main(String[] args) {
        logger.info("Passed Example!");
        logger.info("Filtered Example!");
    }

}
