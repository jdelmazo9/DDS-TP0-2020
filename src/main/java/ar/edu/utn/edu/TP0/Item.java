package ar.edu.utn.edu.TP0;

enum Tipo {
    Artículo,
    Servicio
}

public class Item{
    //Puede ser un artículo o un servicio
    Tipo tipo;

    //Descripcion artículo
    String nombre;

    //Costo del producto
    float valor;

    //Constructor
    Item(Tipo tipo, String nombre, float valor){
        this.tipo = tipo;
        this.nombre = nombre;
        this.valor = valor;
    }

    //Getter de nombre
    public String getNombre(){
        return this.nombre;
    }

    //Setter y Getter de Valor
    public void setValor(float valor){
        this.valor = valor;
    }

    public float getValor(){
        return this.valor;
    }

    //Getter de tipo
    public Tipo getTipo(){
        return this.tipo;
    }

    public Item clonar() {
        return new Item(this.tipo, new String(this.nombre), this.valor);
    }
}