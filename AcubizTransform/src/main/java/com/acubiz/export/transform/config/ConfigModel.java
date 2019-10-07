package com.acubiz.export.transform.config;

import com.acubiz.export.transform.processing.Visitor;

public class ConfigModel implements ConfigElement{
    String vendor;
    Version version;
    Config config;


    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    @Override
    public String toString() {
        return "ConfigModel{" +
                "vendor='" + vendor + '\'' +
                ", version=" + version +
                ", config=" + config +
                '}';
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
