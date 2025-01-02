package com.company.Solid.logger.factories;

import com.company.Solid.logger.interfaces.Appender;
import com.company.Solid.logger.interfaces.Factory;
import com.company.Solid.logger.interfaces.Logger;
import com.company.Solid.logger.loggers.MessageLogger;

public class LoggerFactory implements Factory<Logger> {

    private final AppenderFactory appenderFactory;

    public LoggerFactory() {
        appenderFactory = new AppenderFactory();
    }

    @Override
    public Logger produce(String input) {
        String[] tokens = input.split(System.lineSeparator());
        Appender[] appenders = new Appender[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            appenders[i] = this.appenderFactory.produce(tokens[i]);
        }
        return new MessageLogger(appenders);
    }
}
