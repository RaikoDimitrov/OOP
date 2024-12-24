package com.company.Solid.logger.layouts;

import com.company.Solid.logger.enums.ReportLevel;
import com.company.Solid.logger.interfaces.Layout;

public class SimpleLayout implements Layout {

    @Override
    public String format(String time, String message, ReportLevel reportLevel) {
        return String.format("%s - %s - %s", time, reportLevel.toString(), message);
    }
}
