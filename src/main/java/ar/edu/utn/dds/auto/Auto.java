package ar.edu.utn.dds.auto;

public class Auto {
    //tanque
    //estado(encendido-apagado)
    //temperatura
    //kms_recorridos
    private boolean prendido = false;
    private double temperatura = 0;

    public boolean isPrendido() {
        return prendido;
    }
    public void encender() {
        //this.prendido = true;
    }
    public double getTemperatura() {
        return temperatura;
    }
    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }


}
