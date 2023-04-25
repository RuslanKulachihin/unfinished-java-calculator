package Components;

import com.sun.tools.javac.Main;
import view.AbstractComponent;
import view.AllCalculations;
import view.ComponentType;

import java.util.Arrays;

public class MenuRecentCalculations extends AbstractComponent<Void> {
    public MenuRecentCalculations() {
        super(ComponentType.RECENTCALCULATIONS, null);
    }
    @Override
    public void draw() {
        int i = 1;
        if(AllCalculations.operations.size() > 0){
            System.out.println("Последние вычисление: \n ");
            for ( String key:AllCalculations.operations ){
                i++;
                if(AllCalculations.operations.size() == i-1){
                    System.out.print(i-1 + ") " + key +"\n");

                    System.out.println("****** MENU ******");
                    Arrays.stream(ComponentType.values())
                            .map(v -> v.getType() + " " + v.getComment())
                            .forEach(System.out::println);
                    System.out.println("9 - Exit\n");
            }
            }
        }else {
            System.out.println("Вычислений пока нет \n ");
            System.out.println("****** MENU ******");
            Arrays.stream(ComponentType.values())
                    .map(v -> v.getType() + " " + v.getComment())
                    .forEach(System.out::println);
            System.out.println("9 - Exit\n");
        }
        }
        }


