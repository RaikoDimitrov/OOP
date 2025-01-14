package Solid.logger.logFiles;

import Solid.logger.interfaces.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;

public class LogFile implements File {
    private final StringBuilder text;
    private static final String DEFAULT_PATH_AND_NAME = System.getProperty("user.dir") + "\\src\\com\\company\\Solid\\logger\\" + "/output.txt";
    private final int size;
    private String pathAndName;

    public LogFile() {
        this(DEFAULT_PATH_AND_NAME);
    }

    public LogFile(String pathAndName) {
        this.text = new StringBuilder();
        this.size = 0;
        this.pathAndName = pathAndName;
    }

    @Override
    public boolean write() {
        try {
            Files.write(Path.of(pathAndName), Collections.singleton(this.text));
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public int getSize() {
        return this.calculateSize();
    }

    private int calculateSize() {
        int size = 0;
        for (char symbol : this.text.toString().toCharArray()) {
            if (Character.isAlphabetic(symbol)) size += symbol;
        }
        return size;
    }

    @Override
    public void append(String text) {
        this.text.append(text);
    }

    public String getPathAndName() {
        return pathAndName;
    }

    public void setPathAndName(String pathAndName) {
        this.pathAndName = pathAndName;
    }
}
