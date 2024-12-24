package com.company.Solid.logger.interfaces;

import com.company.Solid.logger.enums.ReportLevel;

public interface Appender {

    void append(String time, String message, ReportLevel reportLevel);

    void setReportLevel(ReportLevel reportLevel);
}
