package factory.flower;

import org.apache.log4j.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.util.*;

public abstract class FlowerAbstractFactory {

    private static final Logger log = Logger.getLogger(FlowerAbstractFactory.class);

    public final List getElements(String fileName) {
        Element rootElement = getRootElement(fileName);
        List resultList =  buildResultCollection(rootElement);
        return resultList;
    }

    protected final Element getRootElement(String fileName) {
        Element rootElement = null;
        try {
            File inputFile = new File(fileName);
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(inputFile);
            rootElement = document.getRootElement();
        }
        catch (IOException | JDOMException e) {
            log.error(e);
        }
        finally {
            return rootElement;
        }
    }

    protected abstract List buildResultCollection(Element rootElement);
}
