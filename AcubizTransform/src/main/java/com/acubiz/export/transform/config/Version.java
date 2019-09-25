package com.acubiz.export.transform.config;


public class Version {
    String display;
    int major;
    int minor;
    int patch;

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public int getMajor() {
        return major;
    }

    public void setMajor(int major) {
        this.major = major;
    }

    public int getMinor() {
        return minor;
    }

    public void setMinor(int minor) {
        this.minor = minor;
    }

    public int getPatch() {
        return patch;
    }

    public void setPatch(int patch) {
        this.patch = patch;
    }

    @Override
    public String toString() {
        return "Version{" +
                "display='" + display + '\'' +
                ", major=" + major +
                ", minor=" + minor +
                ", patch=" + patch +
                '}';
    }
}
