package com.acubiz.export.transform.config;

import com.acubiz.export.transform.processing.Visitor;

public interface ConfigElement {
    void accept(Visitor visitor);
}
