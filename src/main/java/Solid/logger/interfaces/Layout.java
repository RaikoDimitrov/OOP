package Solid.logger.interfaces;

import Solid.logger.enums.ReportLevel;

public interface Layout {

    String format(String time, String message, ReportLevel reportLevel);
}
