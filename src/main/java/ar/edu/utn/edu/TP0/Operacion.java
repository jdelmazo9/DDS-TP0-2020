package ar.edu.utn.edu.TP0;

import java.util.ArrayList;

import static ar.edu.utn.edu.TP0.Tipo.*;

public class Operacion {
    EstadoOperacion estado;
    ArrayList<Item> itemList;

    Operacion(){
        itemList = new ArrayList();
        estado = new operacionAbierta(itemList);
    }

    public void agregarItem(Item i) throws RuntimeException{
        estado.agregarItem(i);
    }

    public void quitarItem(Item i) throws RuntimeException{
        estado.quitarItem(i);
    }

    public float calcularValor(){
        return estado.calcularValor();
    }

    public void cerrar() {
        if(!estado.puedeCerrarse()){
            throw new RuntimeException("La operación ya se encuentra cerrada");
        }
        float closeValue = estado.calcularValor();
        estado = new operacionCerrada(itemList);
    }

    public Remito generarRemito(){

        if(!esListaDeArticulos()) {
            throw new RuntimeException("La operación ya se encuentra cerrada");
        }
        return estado.generarRemito();
    }

    private boolean esListaDeArticulos(){
        return itemList.stream().allMatch(Item -> Item.getTipo().equals(Artículo));
    }
}

abstract class EstadoOperacion{
    ArrayList<Item> itemList;
    public float calcularValor(){
        return itemList.stream().map(Item -> Item.getValor()).reduce(0.0f, Float::sum);
    }
    abstract void agregarItem(Item i);
    abstract void quitarItem(Item i);
    public Remito generarRemito(){
        Remito remito = new Remito(itemList);
        return remito;
    }
    abstract boolean puedeCerrarse();
}


class operacionAbierta extends EstadoOperacion{
    operacionAbierta(ArrayList<Item> itemList){
        this.itemList = itemList;
    }

    public void agregarItem(Item i){
        itemList.add(i);
    }

    public void quitarItem(Item i){
        itemList.remove(i);
    }

    public boolean puedeCerrarse() {
        return true;
    }
}

class operacionCerrada extends EstadoOperacion{

    operacionCerrada(ArrayList<Item> itemList){
        this.itemList = new ArrayList<Item>();

        for (Item item : itemList) {
            this.itemList.add( item.clonar() );
        }
    }

    public void agregarItem(Item i) {
        throw new RuntimeException("No puede modificarse una operación cerrada");
    }

    public void quitarItem(Item i) {
        throw new RuntimeException("No puede modificarse una operación cerrada");
    }

    public boolean puedeCerrarse() {
        return false;
    }
}