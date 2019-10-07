package com.acubiz.export.transform.processing;

import com.acubiz.export.transform.output.model.Document;
import org.apache.commons.csv.CSVRecord;

public class AbstractInputVisitor extends AbstractVisitor {
    private CSVRecord line;

    public AbstractInputVisitor(Document document) {
        super(document);
    }

    public CSVRecord getLine() {
        return line;
    }

    public void setLine(CSVRecord line) {
        this.line = line;
    }

}
