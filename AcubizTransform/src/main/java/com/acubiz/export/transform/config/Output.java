package com.acubiz.export.transform.config;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Output {
    String type;
    @JsonProperty("fileName")
    String filename;
    String charset;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    @Override
    public String toString() {
        return "Output{" +
                "type='" + type + '\'' +
                ", filename='" + filename + '\'' +
                ", charset='" + charset + '\'' +
                '}';
    }
}
