package com.company.Solid.logger.factories;

import com.company.Solid.logger.interfaces.Factory;
import com.company.Solid.logger.interfaces.Layout;
import com.company.Solid.logger.layouts.SimpleLayout;
import com.company.Solid.logger.layouts.XmlLayout;

public class LayoutFactory implements Factory<Layout> {

    @Override
    public Layout produce(String input) {
        Layout layout = null;
        if (input.equals("SimpleLayout")) {
            layout = new SimpleLayout();
        } else if (input.equals("XmlLayout")){
            layout = new XmlLayout();
        }
        return layout;
    }
}
