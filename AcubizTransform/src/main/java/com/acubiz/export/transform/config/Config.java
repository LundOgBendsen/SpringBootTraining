package com.acubiz.export.transform.config;

import java.util.List;

public class Config {
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
}
