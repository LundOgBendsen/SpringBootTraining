package com.acubiz.export.transform.output.model;


import java.util.List;

public class Element {
    String name;
    Object value;
    ElementType type;
    List<Element> children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public ElementType getType() {
        return type;
    }

    public void setType(ElementType type) {
        this.type = type;
    }

    public List<Element> getChildren() {
        return children;
    }

    public void setChildren(List<Element> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Element{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", type=" + type +
                ", children=" + children +
                '}';
    }
}
