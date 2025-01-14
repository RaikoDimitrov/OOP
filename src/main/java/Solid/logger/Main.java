package Solid.logger;

import Solid.logger.appenders.ConsoleAppender;
import Solid.logger.appenders.FileAppender;
import Solid.logger.controllers.EngineImpl;
import Solid.logger.controllers.InputParser;
import Solid.logger.enums.ReportLevel;
import Solid.logger.factories.LoggerFactory;
import Solid.logger.interfaces.*;
import Solid.logger.layouts.SimpleLayout;
import Solid.logger.layouts.XmlLayout;
import Solid.logger.logFiles.LogFile;
import Solid.logger.loggers.MessageLogger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final Factory<Logger> LOGGER_FACTORY = new LoggerFactory();

    public static void main(String[] args) throws IOException {

        //using factory pattern and controllers
        InputParser inputParser = new InputParser();
        Logger logger = LOGGER_FACTORY.produce(inputParser.createLoggerInfo(READER));
        Engine engine = new EngineImpl(logger);
        engine.run("END", READER);

        System.out.println(logger);

       /* Layout simpleLayout = new SimpleLayout();
        Appender consoleAppender = new ConsoleAppender(simpleLayout);
        consoleAppender.setReportLevel(ReportLevel.ERROR);
        Logger logger = new MessageLogger(consoleAppender);
        logger.logWarning("3/31/2015 5:33:07 PM", "Warning: ping is too high - disconnect imminent");
        logger.logInfo("3/26/2015 2:08:11 PM", "User Pesho successfully registered.");
        logger.logError("3/26/2015 2:08:11 PM", "Error parsing JSON.");
        logger.logCritical("3/31/2015 5:33:07 PM", "No connection string found in App.config");
        logger.logFatal("3/31/2015 5:33:07 PM", "mscorlib.dll does not respond");
        System.out.println(logger);

        LogFile file = new LogFile();
        Appender fileAppender = new FileAppender(simpleLayout);
        ((FileAppender) fileAppender).setFile(file);
        Logger fileLogger = new MessageLogger(consoleAppender, fileAppender);
        fileLogger.logWarning("3/26/2015 2:08:11 PM", "Warning parsing JSON.");
        fileLogger.logInfo("3/26/2015 2:08:11 PM", "User Pesho successfully registered.");
        System.out.println(fileAppender + System.lineSeparator() + file.getPathAndName());
        System.out.println();

        Layout xmlLayout = new XmlLayout();
        Appender xmlAppender = new ConsoleAppender(xmlLayout);
        Logger xmlLogger = new MessageLogger(xmlAppender);
        xmlLogger.logFatal("3/31/2015 5:23:54 PM", "mscorlib.dll does not respond");
        xmlLogger.logCritical("3/31/2015 5:23:54 PM", "No connection string found in App.config");*/


    }
}
