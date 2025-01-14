package Solid.logger.factories;

import Solid.logger.interfaces.Appender;
import Solid.logger.interfaces.Factory;
import Solid.logger.interfaces.Logger;
import Solid.logger.loggers.MessageLogger;

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
