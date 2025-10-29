package com.join_cafeteria;

public class Cliente extends Thread {

    private String nombre;
    private int tiempoEspera;

    public Cliente(String nombre, int tiempoEspera) {
        this.nombre = nombre;
        this.tiempoEspera = tiempoEspera;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {
        System.out.println(nombre + " ha llegado a la cafetería y pide un café.");
        try {
            Thread.sleep(tiempoEspera);
            System.out.println(nombre + " se ha cansado de esperar y se ha pirado");
        } catch (InterruptedException e) {
            System.out.println(nombre + " ha recibido su cafe");
        }
    }
}
