package com.company.Solid.logger;

import com.company.Solid.logger.appenders.ConsoleAppender;
import com.company.Solid.logger.appenders.FileAppender;
import com.company.Solid.logger.interfaces.Appender;
import com.company.Solid.logger.interfaces.Layout;
import com.company.Solid.logger.interfaces.Logger;
import com.company.Solid.logger.layouts.SimpleLayout;
import com.company.Solid.logger.logFiles.LogFile;
import com.company.Solid.logger.loggers.MessageLogger;


public class Main {
    public static void main(String[] args) {
        Layout simpleLayout = new SimpleLayout();
        Appender consoleAppender = new ConsoleAppender(simpleLayout);
        Logger logger = new MessageLogger(consoleAppender);
        logger.logError("3/26/2015 2:08:11 PM", "Error parsing JSON.");
        logger.logInfo("3/26/2015 2:08:11 PM", "User Pesho successfully registered.");
        System.out.println(consoleAppender);

        LogFile file = new LogFile();
        Appender fileAppender = new FileAppender(simpleLayout);
        ((FileAppender) fileAppender).setFile(file);
        Logger fileLogger = new MessageLogger(consoleAppender, fileAppender);
        fileLogger.logWarning("3/26/2015 2:08:11 PM", "Warning parsing JSON.");
        fileLogger.logInfo("3/26/2015 2:08:11 PM", "User Pesho successfully registered.");
        System.out.println(fileAppender + System.lineSeparator() + file.getPathAndName());
    }
}
