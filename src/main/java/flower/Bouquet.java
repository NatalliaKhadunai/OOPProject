package flower;

import java.util.*;
import java.util.Map.Entry;

import decoration.*;
import jdomfactory.decoration.DecorationFactory;
import jdomfactory.flower.*;
import jdomfactory.AbstractFactoryJDOM;
import org.apache.log4j.Logger;


public class Bouquet {
    private List<CutFlower> flowers = new LinkedList<CutFlower>();
    private Map<IDecorable, Integer> decorations = new HashMap<IDecorable, Integer>();

    private static final Logger log = Logger.getLogger(Bouquet.class);

    public boolean addFlower(CutFlower flower) {
        if (!flower.IsArtificial()) {
            return flowers.add(flower);
        }
        else {
            log.error("Flower shouldn't be artificial");
            throw new IllegalArgumentException("Flower shouldn't be artificial");
        }
    }

    public boolean removeFlower(CutFlower flower) {
        if (!flowers.contains(flower)) {
            log.error("No flower found to remove");
            throw new IllegalArgumentException("No flower found to remove");
        }
        return flowers.remove(flower);
    }

    public void addDecoration(IDecorable decoration) {
        if (decorations.containsKey(decoration))
            decorations.put(decoration, decorations.get(decoration).intValue() + 1);
        else decorations.put(decoration, 1);
    }

    public int removeDecoration(IDecorable decoration) {
        if (!decorations.containsKey(decoration)) {
            log.error("No decoration found to remove");
            throw new IllegalArgumentException("No decoration found to remove");
        }
        else if (decorations.get(decoration).intValue() == 1) return decorations.remove(decoration);
        else return decorations.put(decoration, decorations.get(decoration).intValue() - 1);
    }

    public boolean addFlowersFromXML(String XMLFileName) {
        if (isXMLFileNameValid(XMLFileName)) {
            AbstractFactoryJDOM flowerFactory = new CutFlowerFactory();
            for (Object flower : flowerFactory.getElements(XMLFileName)) {
                flowers.add((CutFlower)flower);
            }
            return true;
        }
        else return false;
    }

    public boolean addDecorFromXML(String XMLFileName) {
        if (isXMLFileNameValid(XMLFileName)) {
            AbstractFactoryJDOM decorFactory = new DecorationFactory();
            for (Object objEntry : decorFactory.getElements(XMLFileName)) {
                Entry<IDecorable, Integer> entry = (Entry<IDecorable, Integer>) objEntry;
                decorations.put(entry.getKey(), entry.getValue());
            }
            return true;
        }
        else return false;
    }

    public void fill(CutFlower ... flowers) {
        for (CutFlower f : flowers) addFlower(f);
    }

    public int getCost() {
        int summ = 0;
        for (CutFlower f : flowers) summ += f.getCost();
        for (Entry<IDecorable, Integer> entry : decorations.entrySet())
            summ += entry.getKey().getCost() * entry.getValue().intValue();
        return summ;
    }

    public List<CutFlower> sortFlowers() {
        List<CutFlower> sortedList = new LinkedList<CutFlower>();
        sortedList.addAll(flowers);
        sortedList.sort(new ComparatorFreshness());
        return sortedList;
    }

    public List<CutFlower> searchByLength(int minLength, int maxLength) {
        List<CutFlower> resList = new LinkedList<CutFlower>();
        for (CutFlower flower : flowers) {
            if (flower.getLength() >= minLength && flower.getLength() <= maxLength) {
                resList.add(flower);
            }
        }
        return resList;
    }

    private boolean isXMLFileNameValid(String fileName) {
        if (fileName.indexOf(".xml") >= 0) return true;
        else {
            log.error("Incorrect file name. Format shoud be \".xml\"");
            throw new IllegalArgumentException("Incorrect file name. Format shoud be \".xml\"");
        }
    }

    public String toString() {
        String str = "Flowers:\r\n";
        for (CutFlower f : flowers) str += f.toString() + "\r\n";
        str += "\r\nDecorations:\r\n";
        for (Entry<IDecorable, Integer> decor : decorations.entrySet())
            str += decor.getValue() + " x " + decor.getKey().toString() + "\r\n";
        return str;
    }
}
