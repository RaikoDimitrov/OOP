package com.company.Solid.logger.appenders;

import com.company.Solid.logger.enums.ReportLevel;
import com.company.Solid.logger.interfaces.Appender;
import com.company.Solid.logger.interfaces.Layout;

public abstract class AppenderImpl implements Appender {

    public static final ReportLevel DEFAULT_REPORT_LEVEL = ReportLevel.INFO;

    private final Layout layout;
    private ReportLevel reportLevel;
    private int messageCount;

    public AppenderImpl(Layout layout) {
        this.layout = layout;
        this.reportLevel = DEFAULT_REPORT_LEVEL;
    }

    public AppenderImpl(Layout layout, ReportLevel reportLevel) {
        this.layout = layout;
        this.reportLevel = reportLevel;
    }

    @Override
    public abstract void append(String time, String message, ReportLevel reportLevel);

    @Override
    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }

    protected boolean canAppend(ReportLevel reportLevel) {
        return this.reportLevel.ordinal() <= reportLevel.ordinal();
    }

    protected void increaseMessageCount() {
        this.messageCount++;
    }

    @Override
    public String toString() {
        return String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d",
                this.getClass().getSimpleName(),
                this.layout.getClass().getSimpleName(),
                this.reportLevel.toString(),
                this.messageCount);
    }

    protected Layout getLayout() {
        return layout;
    }
}
