package model;

//import sun.awt.windows.WPrinterJob;
import ui.Printer;

import java.util.ArrayList;
import java.util.List;

public class Clothing extends Wearable {
    private List<Wearable> uniform;
    //private List<Accessory> jacket;

    public Clothing(String name) {
        super(name);
        uniform = new ArrayList<>();
        // = new ArrayList<>();
    }

    public void add(Wearable wearable) {
        uniform.add(wearable);
    }


    public void display(String onTop) {
       // System.out.println(this.name + " on " + onTop);
        Printer.print(onTop, this.name);

        for (Wearable wearable : uniform) {
            wearable.display(this.name);
        }
    }

}
