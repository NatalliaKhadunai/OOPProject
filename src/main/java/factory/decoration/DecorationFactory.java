package factory.decoration;

import decoration.*;
import flower.Foliage;
import org.apache.log4j.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class DecorationFactory {

    private static final Logger log = Logger.getLogger("factories");

    public final Map<IDecorable, Integer> getElements(String fileName) {
        Element rootElement = getRootElement(fileName);
        Map<IDecorable, Integer> resultMap =  buildResultCollection(rootElement);
        return resultMap;
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

    protected Map<IDecorable, Integer> buildResultCollection(Element rootElement) {
        List<Element> elemList = rootElement.getChildren();
        Map<IDecorable, Integer> resultMap = new HashMap<IDecorable, Integer>();
        for (int temp = 0; temp < elemList.size(); temp++) {
            Element elem = elemList.get(temp);
            if (elem.getName() == "foliage")
                resultMap.put(processFoliageElement(elem), Integer.parseInt(elem.getAttributeValue("amount")));
            if (elem.getName() == "wrapper")
                resultMap.put(processWrapperElement(elem), Integer.parseInt(elem.getAttributeValue("amount")));
            if (elem.getName() == "container")
                resultMap.put(processContainerElement(elem), Integer.parseInt(elem.getAttributeValue("amount")));
        }
        return resultMap;
    }

    private IDecorable processFoliageElement(Element elem) {
        Foliage foliage = new Foliage(elem.getChild("name").getText(), elem.getChild("color").getText(),
                Boolean.parseBoolean(elem.getChild("isArtificial").getText()));
        foliage.setCost(Integer.parseInt(elem.getChild("cost").getText()));
        foliage.setFreshness(elem.getChild("freshness").getText());
        foliage.setLength(Integer.parseInt(elem.getChild("length").getText()));
        foliage.setCurly(Boolean.parseBoolean(elem.getChild("isArtificial").getText()));
        return foliage;
    }

    private IDecorable processWrapperElement(Element elem) {
        Wrapper wrapper = new Wrapper(elem.getChild("material").getText(), elem.getChild("color").getText(),
                Integer.parseInt(elem.getChild("cost").getText()));
        wrapper.setType(elem.getChild("type").getText());
        int width = Integer.parseInt(elem.getChild("size").getChild("width").getText());
        int height = Integer.parseInt(elem.getChild("size").getChild("height").getText());
        wrapper.setSize(width, height);
        wrapper.setMat(Boolean.parseBoolean(elem.getChild("isMat").getText()));
        return wrapper;
    }

    private IDecorable processContainerElement(Element elem) {
        Container container = new Container(elem.getChild("material").getText(), elem.getChild("color").getText(),
                Integer.parseInt(elem.getChild("cost").getText()));
        container.setType(elem.getChild("type").getText());
        int width = Integer.parseInt(elem.getChild("size").getChild("width").getText());
        int height = Integer.parseInt(elem.getChild("size").getChild("height").getText());
        container.setSize(width, height);
        container.setTransparent(Boolean.parseBoolean(elem.getChild("isTransparent").getText()));
        return container;
    }
}
