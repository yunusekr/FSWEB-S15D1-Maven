package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Grocery {
    public static List<String> groceryList = new ArrayList<>();

    public void startGrocery() {
        Scanner grocery = new Scanner(System.in);

        while (true) {
            System.out.println("Lütfen bir işlem seçiniz: 0 = Uygulamayı Durdur , 1 = Eklenmesini istediğiniz elemanları giriniz. , 2 = Çıkarılmasını istediğiniz elemanları giriniz.");
            int number = grocery.nextInt();
            grocery.nextLine(); // nextInt'ten sonra newline'ı temizler

            if (number == 0) {
                grocery.close();
                break;
            } else if (number == 1) {
                System.out.println("Eklenmesini istediğiniz elemanları giriniz.");
                String deger = grocery.nextLine();
                addItems(deger);
                printSorted();
            } else if (number == 2) {
                System.out.println("Çıkarılmasını istediğiniz elemanları giriniz.");
                String deger = grocery.nextLine();
                removeItems(deger);
                printSorted();
            }
        }
    }

    public static void addItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            if (!checkItemIsInList(item)) {
                groceryList.add(item);
            }
        }
        Collections.sort(groceryList);
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            groceryList.remove(item);
        }
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        Collections.sort(groceryList);
        System.out.println(groceryList);
    }
}