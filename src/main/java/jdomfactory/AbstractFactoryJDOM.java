package jdomfactory;

import org.apache.log4j.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractFactoryJDOM {

    private static final Logger log = Logger.getLogger(AbstractFactoryJDOM.class);

    public final Iterator getElements(String fileName) {
        Element rootElement = getRootElement(fileName);
        Iterable resultList = null;
        if (rootElement != null) resultList =  buildResultCollection(rootElement);
        return resultList.iterator();
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


    protected abstract Iterable buildResultCollection(Element rootElement);
}
