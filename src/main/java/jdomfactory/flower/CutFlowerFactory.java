package jdomfactory.flower;

import flower.CutFlower;
import flower.Flower;
import org.apache.log4j.Logger;
import org.jdom2.Element;

import java.util.LinkedList;
import java.util.List;

public class CutFlowerFactory extends FlowerAbstractFactory {

    private static final Logger log = Logger.getLogger(CutFlowerFactory.class);

    protected List<Flower> buildResultCollection(Element rootElement) {
        List<Element> elemList = rootElement.getChildren();
        List<Flower> resultList = new LinkedList<Flower>();
        for (int temp = 0; temp < elemList.size(); temp++) {
            Element elem = elemList.get(temp);
            if (!elem.getName().equals("cutflower")) continue;
            if (Boolean.parseBoolean(elem.getChild("isArtificial").getText()) == true) continue;
            resultList.add(processElement(elem));
        }
        return resultList;
    }

    private CutFlower processElement(Element elem) {
        CutFlower cutFlower = new CutFlower(elem.getChild("name").getText(),
                elem.getChild("color").getText(), Boolean.parseBoolean(elem.getChild("isArtificial").getText()));
        cutFlower.setCost(Integer.parseInt(elem.getChild("cost").getText()));
        cutFlower.setFreshness(elem.getChild("freshness").getText());
        cutFlower.setLength(Integer.parseInt(elem.getChild("length").getText()));
        cutFlower.setBurgeonDiameter(Integer.parseInt(elem.getChild("burgeonDiameter").getText()));
        cutFlower.setHasThorns(Boolean.parseBoolean(elem.getChild("hasThorns").getText()));
        return cutFlower;
    }
}
