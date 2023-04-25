package Components;

import view.AbstractComponent;
import view.AllCalculations;
import view.ComponentType;

import java.util.Arrays;

public class MenuDeleteHistory extends AbstractComponent<Void> {
        public MenuDeleteHistory() {
            super(ComponentType.DELETEHISTORY, null);
        }
        @Override
        public void draw() {
            AllCalculations.operations.clear();
            System.out.println("История очищена ! \n");
            System.out.println("****** MENU ******");
            Arrays.stream(ComponentType.values())
                    .map(v -> v.getType() + " " + v.getComment())
                    .forEach(System.out::println);
            System.out.println("9 - Exit\n");
        }
}
