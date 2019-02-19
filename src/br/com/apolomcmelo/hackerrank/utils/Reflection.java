package br.com.apolomcmelo.hackerrank.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {
    public static Object genericInvokePrivateMethod(Object obj, String methodName, int paramCount, Object... params) {
        Object requiredObj = null;
        Object[] parameters = new Object[paramCount];
        Class<?>[] classArray = new Class<?>[paramCount];

        for (int i = 0; i < paramCount; i++) {
            parameters[i] = params[i];
            classArray[i] = getUnboxedClass(params[i].getClass());
        }

        try {
            Method method = obj.getClass().getDeclaredMethod(methodName, classArray);
            method.setAccessible(true);
            requiredObj = method.invoke(obj, params);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return requiredObj;
    }

    private static Class<?> getUnboxedClass(Class<?> clazz) {
        switch (clazz.getSimpleName()) {
            case "Integer":
                return int.class;
            case "Long":
                return long.class;
            case "Double":
                return double.class;
            case "Char":
                return char.class;
            case "Boolean":
                return boolean.class;
            case "Void":
                return void.class;
            default:
                return clazz;
        }
    }
}
