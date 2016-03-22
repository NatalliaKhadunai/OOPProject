package Main;

import flower.*;
import org.apache.log4j.Logger;

import java.util.List;

public class Main {
    private static final Logger log = Logger.getLogger(Main.class);

    public static void main (String[] args) {
        try {
            CutFlower flower1 = new CutFlower("rose", "white", false);
            CutFlower flower2 = new CutFlower("lily", "yellow", false);
            CutFlower flower3 = new CutFlower("lily", "pink", false);

            Bouquet bouquet = new Bouquet();
            bouquet.addFlower(flower1);
            bouquet.addFlower(flower2);
            bouquet.addFlower(flower3);

            bouquet.addFlowersFromXML("flowerFill.xml");
            bouquet.addDecorFromXML("decorationFill.xml");

            System.out.println(bouquet.toString());
            System.out.print("Bouquet cost = " + bouquet.getCost());

            System.out.println("\r\nSorting by freshness:\r\n" + bouquet.sortFlowers().toString());

            System.out.println("\r\nFlowers with length between [40; 60]:\r\n");
            List<CutFlower> list = bouquet.searchByLength(40, 60);
            if (list != null)
                System.out.println(list);
            System.out.println();
        }
        catch (IllegalArgumentException e) {
            log.error(e);
        }
    }
}
