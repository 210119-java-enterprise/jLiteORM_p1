package com.revature.utilities;

import com.revature.annotations.JoinColumn;

import java.lang.reflect.Field;

/**
 *
 Acts as a wrapper class for ForeignKey annotated Fields. Gives us methods to get the
 names, types, and annotation names of a field.
 */
public class ForeignKeyField {

    private Field field;

    /**
     * One-arg constructor takes the field that it wraps.
     * @param field The field to wrap.
     */
    public ForeignKeyField(Field field) {
        if (field.getAnnotation(JoinColumn.class) == null) {
            throw new IllegalStateException("Cannot create ForeignKeyField object! Provided field, " + getName() + "is not annotated with @JoinColumn");
        }
        this.field = field;
    }

    /**
     * Returns the field name.
     * @return String name of field.
     */
    public String getName() {
        return field.getName();
    }

    /**
     * Returns the class type of the Field.
     * @return The type of the field.
     */
    public Class<?> getType() {
        return field.getType();
    }

    /**
     * Returns the String name of the field's annotation.
     * @return String name of annotation.
     */
    public String getColumnName() {
        return field.getAnnotation(JoinColumn.class).columnName();
    }
}
