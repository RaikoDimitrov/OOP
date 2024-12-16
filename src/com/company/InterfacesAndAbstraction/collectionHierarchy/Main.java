package com.company.InterfacesAndAbstraction.collectionHierarchy;

import com.company.InterfacesAndAbstraction.collectionHierarchy.classImpl.AddCollection;
import com.company.InterfacesAndAbstraction.collectionHierarchy.classImpl.AddRemoveCollection;
import com.company.InterfacesAndAbstraction.collectionHierarchy.classImpl.MyListImpl;
import com.company.InterfacesAndAbstraction.collectionHierarchy.interfaces.AddRemovable;
import com.company.InterfacesAndAbstraction.collectionHierarchy.interfaces.Addable;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myList = new MyListImpl();

        String[] input = scanner.nextLine().split("\\s+");
        int countRemove = Integer.parseInt(scanner.nextLine());

        printAdd(input, addCollection);
        printAdd(input, addRemoveCollection);
        printAdd(input, myList);

        printRemove(countRemove, addRemoveCollection);
        printRemove(countRemove, myList);
    }

    private static void printRemove(int countRemove, AddRemovable removeCollection) {
        for (int i = 0; i < countRemove; i++) {
            System.out.print(removeCollection.remove() + " ");
        }
        System.out.println();
    }

    private static void printAdd(String[] input, Addable addCollection) {
        for (String s : input) {
            System.out.print(addCollection.add(s) + " ");
        }
        System.out.println();
    }

}
