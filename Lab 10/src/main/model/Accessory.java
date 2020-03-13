package model;

import ui.Printer;

public class Accessory  extends Wearable {

    public Accessory(String name) {
        super(name);
    }

    public void display(String onTopOf) {
        Printer.print(onTopOf, name);
    }

}
