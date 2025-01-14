package Solid.logger.controllers;

import Solid.logger.enums.ReportLevel;
import Solid.logger.interfaces.Engine;
import Solid.logger.interfaces.Logger;

import java.io.BufferedReader;
import java.io.IOException;

public class EngineImpl implements Engine {

    private final Logger logger;

    public EngineImpl(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void run(String stopCommand, BufferedReader reader) throws IOException {
        String input;

        while (!stopCommand.equals(input = reader.readLine())) {
            String[] tokens = input.split("\\|");

            ReportLevel reportLevel = ReportLevel.valueOf(tokens[0]);
            String time = tokens[1];
            String message = tokens[2];
            this.logger.log(time, message, reportLevel);
        }
    }
}
