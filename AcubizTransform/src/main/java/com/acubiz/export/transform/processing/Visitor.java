package com.acubiz.export.transform.processing;

import com.acubiz.export.transform.config.*;
import com.acubiz.export.transform.output.model.Node;

public interface Visitor {
    void visit(ConfigElement element);
    void visit(Config element);
    void visit(ConfigModel element);
    void visit(Formatting element);
    void visit(Item element);
    void visit(Output element);
    void visit(Version element);
}
