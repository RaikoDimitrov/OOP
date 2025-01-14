package Solid.logger.factories;

import Solid.logger.interfaces.Factory;
import Solid.logger.interfaces.Layout;
import Solid.logger.layouts.SimpleLayout;
import Solid.logger.layouts.XmlLayout;

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
