package com.acubiz.export.transform.config;

import com.acubiz.export.transform.processing.Visitor;

public class Item implements ConfigElement{
    String type;
    String fieldType;
    String fieldName;
    String title;
    Formatting formatting;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Formatting getFormatting() {
        return formatting;
    }

    public void setFormatting(Formatting formatting) {
        this.formatting = formatting;
    }

    @Override
    public String toString() {
        return "Item{" +
                "type='" + type + '\'' +
                ", fieldType='" + fieldType + '\'' +
                ", fieldName='" + fieldName + '\'' +
                ", title='" + title + '\'' +
                ", formatting=" + formatting +
                '}';
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
