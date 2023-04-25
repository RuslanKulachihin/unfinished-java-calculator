package Components;

import com.sun.tools.javac.Main;
import view.AbstractComponent;
import view.AllCalculations;
import view.ComponentType;

import java.util.Arrays;

public class MenuAllCalculations extends AbstractComponent<Void> {
    public MenuAllCalculations() {
        super(ComponentType.ALLCALCULATIONS, null);
    }
    @Override
    public void draw() {
        int i = 1;
        if(AllCalculations.operations.size() > 0){
            System.out.println("История калькулятора: ");
            for ( String key: AllCalculations.operations ){
                i++;
                String sum = ""+i + ")\t"+key + "\n";
                System.out.print(sum);
            }
            System.out.println("****** MENU ******");
            Arrays.stream(ComponentType.values())
                    .map(v -> v.getType() + " " + v.getComment())
                    .forEach(System.out::println);
            System.out.println("9 - Exit\n");
        }
        else {
            System.out.println("Вычислений пока нет \n ");

            System.out.println("****** MENU ******");
            Arrays.stream(ComponentType.values())
                    .map(v -> v.getType() + " " + v.getComment())
                    .forEach(System.out::println);
            System.out.println("9 - Exit\n");
        }

    }
}
