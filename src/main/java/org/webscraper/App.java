package org.webscraper;

import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        App p = new App();
        p.ebay();
    }

    private void ebay() {
        Document doc;
        try {
            doc = Jsoup.connect(
                    "https://www.ebay.com/itm/HP-EliteBook-1040-G2-Laptop-Intel-i5-5200U-2-2GHz-8GB-128GB-SSD-Windows-10-Pro/123732165300?_trkparms=aid%3D111001%26algo%3DREC.SEED%26ao%3D1%26asc%3D40719%26meid%3Dc75633cff9954289a16ddbcc686dda9a%26pid%3D100675%26rk%3D3%26rkt%3D15%26sd%3D113171583869%26itm%3D123732165300%26pmt%3D0%26noa%3D1%26pg%3D2481888&_trksid=p2481888.c100675.m4236&_trkparms=pageci%3A33c6bd72-d4c1-11e9-8b38-74dbd18008b8%7Cparentrq%3A2190985616d0ad31c359b24fffc7f4c1%7Ciid%3A1")
                    .get();
            Element productTitle = doc.getElementById("itemTitle");
            Element buy_now = doc.getElementById("prcIsum");
            System.out.println(productTitle.text().substring(14));
            System.out.println(buy_now.text().substring(4));
            Scanner scan_price = new Scanner(System.in);
            System.out.println("Enter the Buy it Now price");
            Float watch_price = scan_price.nextFloat();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
