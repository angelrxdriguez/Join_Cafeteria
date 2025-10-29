package com.join_cafeteria;


public class Cliente extends Thread {

    private String nombre;
    private int tiempoEspera;
    private HelloController controlador;

    public Cliente(String nombre, int tiempoEspera, HelloController controlador) {
        this.nombre = nombre;
        this.tiempoEspera = tiempoEspera;
        this.controlador = controlador;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {
        controlador.mostrarMensaje(nombre + " ha llegado a la cafetería y pide un café.");
        try {
            Thread.sleep(tiempoEspera);
            controlador.mostrarMensaje(nombre + " se ha cansado de esperar y se ha pirado😢");
        } catch (InterruptedException e) {
            controlador.mostrarMensaje(nombre + " ha recibido su cafe 😄");
        }
    }
}
