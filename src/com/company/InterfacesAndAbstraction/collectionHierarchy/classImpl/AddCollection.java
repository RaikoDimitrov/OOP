package com.company.InterfacesAndAbstraction.collectionHierarchy.classImpl;

import com.company.InterfacesAndAbstraction.collectionHierarchy.interfaces.Addable;

public class AddCollection extends Collection implements Addable {


    @Override
    public int add(String element) {
        super.getItems().add(element);
        return super.getItems().indexOf(element);
    }
}
