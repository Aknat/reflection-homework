package annotationWithParams;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {

        Class<?> calc = Concatenation.class;
        Method[] methods = calc.getDeclaredMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(Concatenate.class)) {
                Concatenate annotation = m.getAnnotation(Concatenate.class);
                try {
                    m.invoke(calc, annotation.a(), annotation.b());
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
