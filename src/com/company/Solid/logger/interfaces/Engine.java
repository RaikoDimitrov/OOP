package com.company.Solid.logger.interfaces;

import java.io.BufferedReader;
import java.io.IOException;

public interface Engine {
    void run(String stopCommand, BufferedReader reader) throws IOException;
}
