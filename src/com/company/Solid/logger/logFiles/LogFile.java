package com.company.Solid.logger.logFiles;

import com.company.Solid.logger.interfaces.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;

public class LogFile implements File {
    private final StringBuilder text;
    private static final String DEFAULT_PATH_AND_NAME = System.getProperty("user.dir") + "\\src\\com\\company\\Solid\\logger\\" + "/output.txt";
    private int size;
    private String pathAndName;

    public LogFile() {
        this.text = new StringBuilder();
        this.pathAndName = DEFAULT_PATH_AND_NAME;
    }

    public LogFile(String pathAndName) {
        this();
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
        return  calculateSize();
    }

    private int calculateSize() {
        for (char symbol : this.text.toString().toCharArray()) {
            if (Character.isAlphabetic(symbol)) this.size += symbol;
        }
        return this.size;
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
