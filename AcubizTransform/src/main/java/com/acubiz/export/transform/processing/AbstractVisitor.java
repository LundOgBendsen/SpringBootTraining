package com.acubiz.export.transform.processing;

import com.acubiz.export.transform.config.*;
import com.acubiz.export.transform.output.model.Document;

public class AbstractVisitor implements Visitor {
    private Document document;

    public AbstractVisitor(Document document) {
        this.document = document;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    @Override
    public void visit(ConfigElement element) {

    }

    @Override
    public void visit(Config element) {

    }

    @Override
    public void visit(ConfigModel element) {

    }

    @Override
    public void visit(Formatting element) {

    }

    @Override
    public void visit(Item element) {

    }

    @Override
    public void visit(Output element) {

    }

    @Override
    public void visit(Version element) {

    }
}
