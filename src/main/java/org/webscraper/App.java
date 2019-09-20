package org.webscraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

class App {

    private String scan;

    public static void main(String[] args) {
        App p = new App();
        p.ebay();
    }

    private void ebay() {
        Document doc;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the Item's url:\n");
            scan = scanner.next();
        } catch (InputMismatchException e) {
            e.printStackTrace();

        }
        try {
            doc = Jsoup.connect(scan).get();
            Element productTitle = doc.getElementById("itemTitle");
            Element buy_now = doc.getElementById("prcIsum");
            System.out.println(productTitle.text().substring(14));
            System.out.println("Price: " + buy_now.text().substring(3));

            Float converted_price = Float.valueOf(buy_now.text().substring(4));
            Scanner scan_price = new Scanner(System.in);
            System.out.println("Enter the Buy it Now price:");
            Float watch_price = scan_price.nextFloat();

            if (converted_price < watch_price) {
                System.out.println("Price is lower");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
