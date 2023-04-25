package view;



import Components.*;

import java.beans.Expression;
import java.util.HashMap;
import java.util.Map;

public class ComponentFabric {

    private final Map<ComponentType, Component> components;
    private Object service;
    private Expression Model;

    public ComponentFabric() {
        this.components = new HashMap<>();
    }

    public <T> Component build(int type) {
        try {
            ComponentType componentType = ComponentType.fromType(type);

            return components.computeIfAbsent(componentType, this::apply);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    private Component apply(ComponentType ct) {
        Component component;
        switch (ct) {
            case MENU:
                component = new MenuComponent();
                break;
            case HISTORY:
              component = new MenuHistory();
                break;
            case CALCULATE:
                component =new MenuCalculate();
                break; 
            case RECENTCALCULATIONS:
                component = new MenuRecentCalculations();
                break;
            case ALLCALCULATIONS:
                component = new MenuAllCalculations();
                break;
            case DELETEHISTORY:
                component = new MenuDeleteHistory();
                break;
            /*case SINGLE_EMPLOY:
                component = new SingleObjectComponent<Employee>(service1);
                break;
            case CREATE_EMPLOY:
                component = new CreateEmployComponent(service1);
                break;
            case UPDATE_EMPLOY:
                component = new UpdateEmployComponent(service1);
                break;*/
            default:
                component = null;
        }
        return component;
    }
}