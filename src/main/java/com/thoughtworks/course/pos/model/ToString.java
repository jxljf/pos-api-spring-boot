package com.thoughtworks.course.pos.model;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 提供 toString 方法，不做学习要求
 */
public class ToString {
    @Override
    public String toString() {
        final Class<?> clazz = getClass();
        final List<Field> fields = getFields(clazz);
        return fields.stream().map(field -> {
            field.setAccessible(true);
            try {
                return field.getName() + "=" + field.get(this);
            } catch (IllegalAccessException e) {
                return field.getName() + "=?";
            }
        }).collect(Collectors.joining(", ", clazz.getSimpleName() + "(", ")"));
    }

    private List<Field> getFields(Class<?> clazz) {
        if (clazz == null) {
            return new ArrayList<>();
        }
        final List<Field> declaredFields = Arrays.asList(clazz.getDeclaredFields());
        return Stream.concat(declaredFields.stream(), getFields(clazz.getSuperclass()).stream()).collect(Collectors.toList());
    }
}
