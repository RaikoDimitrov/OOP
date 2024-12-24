package com.company.Solid.logger.interfaces;

import com.company.Solid.logger.enums.ReportLevel;

public interface Layout {

    String format(String time, String message, ReportLevel reportLevel);
}
