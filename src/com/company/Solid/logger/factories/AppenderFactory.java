package com.company.Solid.logger.factories;

import com.company.Solid.logger.appenders.ConsoleAppender;
import com.company.Solid.logger.appenders.FileAppender;
import com.company.Solid.logger.enums.ReportLevel;
import com.company.Solid.logger.interfaces.Appender;
import com.company.Solid.logger.interfaces.Factory;
import com.company.Solid.logger.interfaces.Layout;

public class AppenderFactory implements Factory<Appender> {

    private final LayoutFactory layoutFactory;

    public AppenderFactory() {
        this.layoutFactory = new LayoutFactory();
    }

    @Override
    public Appender produce(String input) {
        String[] tokens = input.split("\\s+");
        String appenderType = tokens[0];
        String layoutType = tokens[1];

        Layout produce = this.layoutFactory.produce(layoutType);
        Appender appender = null;

        if (appenderType.equals("ConsoleAppender")) {
            appender = new ConsoleAppender(produce);
        } else if (appenderType.equals("FileAppender")) {
            appender = new FileAppender(produce);
        }

        if (tokens.length > 2) {
            assert appender != null;
            appender.setReportLevel(ReportLevel.valueOf(tokens[2]));
        }
        return appender;
    }
}
