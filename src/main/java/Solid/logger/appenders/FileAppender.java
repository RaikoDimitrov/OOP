package Solid.logger.appenders;

import Solid.logger.enums.ReportLevel;
import Solid.logger.interfaces.File;
import Solid.logger.interfaces.Layout;
import Solid.logger.logFiles.LogFile;

public class FileAppender extends  AppenderImpl {

    private File file;

    public FileAppender(Layout layout) {
        super(layout);
        this.file = new LogFile();
    }

    public FileAppender(Layout layout, ReportLevel reportLevel) {
        super(layout, reportLevel);
        this.file = new LogFile();
    }

    @Override
    public void append(String time, String message, ReportLevel reportLevel) {
        if (this.file == null) throw new NullPointerException("No set file!");
        if (this.canAppend(reportLevel)) {
            super.increaseMessageCount();
            this.file.append(super.getLayout().format(time, message, reportLevel));
            this.file.write();
        }
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", File size: %d", this.file.getSize());
    }
}
