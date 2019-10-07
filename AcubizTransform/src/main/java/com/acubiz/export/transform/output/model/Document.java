package com.acubiz.export.transform.output.model;

import java.util.ArrayList;
import java.util.List;

public class Document {
    private FileFormat format;
    private String filename;
    private List<Element> children = new ArrayList<>();

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public FileFormat getFormat() {
        return format;
    }

    public void setFormat(FileFormat format) {
        this.format = format;
    }



    public List<Element> getChildren() {
        return children;
    }

    public void setChildren(List<Element> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Document{" +
                "format=" + format +
                ", filename='" + filename + '\'' +
                ", children=" + children +
                '}';
    }
}
