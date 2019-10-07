package com.acubiz.export.transform.config;

import com.acubiz.export.transform.processing.Visitor;

public class Formatting implements ConfigElement{
    String justify;
    String pattern;

    public String getJustify() {
        return justify;
    }

    public void setJustify(String justify) {
        this.justify = justify;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public String toString() {
        return "Formatting{" +
                "justify='" + justify + '\'' +
                ", pattern='" + pattern + '\'' +
                '}';
    }


    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

