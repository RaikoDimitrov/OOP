package InterfacesAndAbstraction.collectionHierarchy.classImpl;

import InterfacesAndAbstraction.collectionHierarchy.interfaces.AddRemovable;
import InterfacesAndAbstraction.collectionHierarchy.interfaces.Addable;

public class AddRemoveCollection extends Collection implements Addable, AddRemovable {

    @Override
    public String remove() {
        return super.getItems().remove(super.getItems().size() - 1);
    }

    @Override
    public int add(String element) {
        super.getItems().add(0, element);
        return 0;
    }
}
