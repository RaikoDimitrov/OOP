package com.company.Solid.logger.appenders;

import com.company.Solid.logger.enums.ReportLevel;
import com.company.Solid.logger.interfaces.Layout;

public class ConsoleAppender extends AppenderImpl {

    public ConsoleAppender(Layout layout) {
        super(layout);

    }

    @Override
    public void append(String time, String message, ReportLevel reportLevel) {
        if (this.canAppend(reportLevel)) {
            super.increaseMessageCount();
            System.out.println(super.getLayout().format(time, message, reportLevel));
        }
    }

}
