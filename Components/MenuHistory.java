package Components;

import view.AbstractComponent;
import view.ComponentType;

import java.util.Arrays;


public class MenuHistory extends AbstractComponent<Void> {
    public MenuHistory() {
        super(ComponentType.HISTORY, null);
    }
    @Override
    public void draw() {

        System.out.println("\n\nДанный калькулятор спасобен выычелсять любые вырожения со знаками * / + - () \nВводите вырожение в калькулятор по возможности бех пробелов и не вводите больше одного знака между числами.\nУдачи !\n");
        Arrays.stream(ComponentType.values())
                .map(v -> v.getType() + " " + v.getComment())
                .forEach(System.out::println);
        System.out.println("9 - Exit\n");
    }
}
