package school.lemon.changerequest.java.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

public class _09MarkersExample {

    private static final Logger logger = LoggerFactory.getLogger(_09MarkersExample.class);

    public static void main(String[] args) throws InterruptedException {
        String confidentialMarkerText = "CONFIDENTIAL";
        Marker confidentialMarker = MarkerFactory.getMarker(confidentialMarkerText);
        logger.info("This logger supports confidential messages....");
        logger.info(confidentialMarker, "This is a confidential message....");
        logger.info("Just logged a confidential message");
    }

}
