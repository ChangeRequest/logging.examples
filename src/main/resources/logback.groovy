import ch.qos.logback.classic.boolex.JaninoEventEvaluator
import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.classic.html.HTMLLayout
import ch.qos.logback.classic.turbo.MarkerFilter
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.core.FileAppender
import ch.qos.logback.core.encoder.LayoutWrappingEncoder
import ch.qos.logback.core.filter.EvaluatorFilter
import ch.qos.logback.core.rolling.FixedWindowRollingPolicy
import ch.qos.logback.core.rolling.RollingFileAppender
import ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy
import ch.qos.logback.core.spi.FilterReply

import static ch.qos.logback.classic.Level.*

def LOG_PATH = "logs"
appender("Console-Appender", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = "%d{HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n"
    }
}
root(INFO, ["Console-Appender"])

logger("school.lemon.changerequest.java.logging._02WarnLevelExample", WARN)

logger("school.lemon.changerequest.java.logging._03LoggingLevelInheritanceExample", DEBUG)
logger("school.lemon.changerequest.java.logging._03LoggingLevelInheritanceExample\$WarnLevelClass", WARN)

logger("school.lemon.changerequest.java.logging.subpackage", TRACE)
logger("school.lemon.changerequest.java.logging.subpackage._04SubPackageExample\$WarnLevelClass", WARN)

appender("HTML_FILE", FileAppender) {
    file = "${LOG_PATH}/test.html"
    append = false
    encoder(LayoutWrappingEncoder) {
        layout(HTMLLayout) {
            pattern = "%relative%thread%level%logger%msg"
        }
    }
}
logger("school.lemon.changerequest.java.logging._05HtmlFileExample", INFO, ["HTML_FILE"], false)

appender("FILTERED_STDOUT", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = "%d{HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n"
    }
    filter(EvaluatorFilter) {
        evaluator(JaninoEventEvaluator) {
            expression = "return message.contains(\"Filtered\");"
        }
        onMismatch = FilterReply.NEUTRAL
        onMatch = FilterReply.DENY
    }
}
logger("school.lemon.changerequest.java.logging._06FiltersExample", INFO, ["FILTERED_STDOUT"], false)

appender("SIZE_BASED_FILE", RollingFileAppender) {
    file = "${LOG_PATH}/fixWindowBasedLogFile.log"
    rollingPolicy(FixedWindowRollingPolicy) {
        fileNamePattern = "${LOG_PATH}/fixWindowBasedLogFile.log%i.log"
        minIndex = 1
        maxIndex = 3
    }
    triggeringPolicy(SizeBasedTriggeringPolicy) {
        maxFileSize = "100KB"
    }
    encoder(PatternLayoutEncoder) {
        pattern = "%d{HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n"
    }
}
logger("school.lemon.changerequest.java.logging._07SizeBasedRollingFileAppenderExample", INFO, ["SIZE_BASED_FILE"])

appender("TIME_BASED_FILE", RollingFileAppender) {
    file = "${LOG_PATH}/timeBasedlogFile.log"
    rollingPolicy(TimeBasedRollingPolicy) {
        fileNamePattern = "${LOG_PATH}/timeBasedlogFile.%d{yyyy-MM-dd-HH-mm-ss}.log"
        maxHistory = 3
    }
    encoder(PatternLayoutEncoder) {
        pattern = "%d{HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n"
    }
}
logger("school.lemon.changerequest.java.logging._08TimeBasedRollingFileAppenderExample", INFO, ["TIME_BASED_FILE"])

turboFilter(MarkerFilter) {
    name = "CONFIDENTIAL_FILTER"
    marker = "CONFIDENTIAL"
    onMatch = FilterReply.DENY
}
