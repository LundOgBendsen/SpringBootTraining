package com.acubiz.export.transform.output.model;


import com.acubiz.export.transform.processing.Visitor;

public interface Node {
    void accept(Visitor visitor);
}
