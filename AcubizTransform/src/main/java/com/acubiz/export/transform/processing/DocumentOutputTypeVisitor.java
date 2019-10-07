package com.acubiz.export.transform.processing;

import com.acubiz.export.transform.config.*;
import com.acubiz.export.transform.output.model.Document;
import com.acubiz.export.transform.output.model.FileFormat;

public class DocumentOutputTypeVisitor extends AbstractVisitor {


    public DocumentOutputTypeVisitor(Document document) {
        super(document);
    }

    @Override
    public void visit(Output element) {
        Document root = getDocument();
        String filename = element.getFilename();
        String type = element.getType();
        FileFormat format = FileFormat.CSV;
        switch (type.toUpperCase()) {
            case "XML": format=FileFormat.XML;break;
            case "CSV": format=FileFormat.CSV;break;
            case "JSON": format=FileFormat.JSON;break;
        };
        root.setFormat(format);
        root.setFilename(filename);
    }
}
