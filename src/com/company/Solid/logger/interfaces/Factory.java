package com.company.Solid.logger.interfaces;

public interface Factory<T> {
    T produce(String input);
}
