package ar.edu.utn.edu.TP0;

import ar.edu.utn.edu.TP0.Item;

import java.util.ArrayList;

public class Remito {
    ArrayList<Item> itemList;
    Remito(ArrayList<Item> itemList){
        this.itemList = itemList;
    }
    void imprmimirRemito() {
        itemList.forEach(item -> System.out.println(item.nombre+' '+item.valor));
    }
}
