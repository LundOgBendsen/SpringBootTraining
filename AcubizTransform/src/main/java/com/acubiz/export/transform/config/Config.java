package com.acubiz.export.transform.config;

import com.acubiz.export.transform.processing.Visitor;

import java.util.List;

public class Config implements ConfigElement {
    Output output;
    List<Item> items;

    public Output getOutput() {
        return output;
    }

    public void setOutput(Output output) {
        this.output = output;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Config{" +
                "output=" + output +
                ", items=" + items +
                '}';
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
