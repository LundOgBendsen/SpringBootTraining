package com.acubiz.export.transform.processing;

import com.acubiz.export.transform.config.Item;
import com.acubiz.export.transform.output.model.Document;
import com.acubiz.export.transform.output.model.Element;
import org.apache.commons.csv.CSVRecord;

public class InputElementVisitor extends AbstractInputVisitor {

    public InputElementVisitor(Document document) {
        super(document);
    }

    @Override
    public void visit(Item element) {
        String inputFieldName = element.getFieldName();
        CSVRecord line = getLine();
        String content = line.get(inputFieldName.trim());
        if (content!=null) {
            Element e = new Element();
            e.setName(element.getTitle());
            e.setValue(content);
            getDocument().getChildren().add(e);
        } else {
            System.out.println("Warning. Field named " + element.getFieldName() + " not found!");
        }
    }
}
