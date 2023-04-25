import view.ComponentFabric;
import view.Component;
import Components.MenuComponent;

import java.awt.*;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        ComponentFabric fabric = new ComponentFabric();
        System.out.println("----- Enter 0 to see menu ----\n");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int command = scanner.nextInt();
            Component component = fabric.build(command);
            if (component == null) {
                return;
            }
            component.draw();
        }

    }

}

