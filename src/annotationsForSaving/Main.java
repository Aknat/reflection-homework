package annotationsForSaving;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {

        TextContainer container = new TextContainer();
        Class<?> cls = container.getClass();
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Save.class)) {
                try {
                    method.invoke(container, cls.getAnnotation(SaveTo.class).path(), cls.getDeclaredField("text").get(container));
                } catch (IllegalAccessException | InvocationTargetException | NoSuchFieldException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
