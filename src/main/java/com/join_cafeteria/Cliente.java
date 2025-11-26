package com.join_cafeteria;

public class Cliente extends Thread {
    public boolean atendido;
    private String nombre;
    private int tiempoEspera;
    private HelloController controlador;

    public Cliente(String nombre, int tiempoEspera, HelloController controlador) {
        this.nombre = nombre;
        this.tiempoEspera = tiempoEspera;
        this.controlador = controlador;
        this.atendido  = false;
    }

    public String getNombre() {
        return nombre;
    }
    public boolean getAtendido(){
        return atendido;
    }
    @Override
    public void run() {
        controlador.mostrarMensaje(nombre + " ha llegado y pide un cafe");

        try {
            Thread.sleep(tiempoEspera);
            if (controlador.cerrado) {
                controlador.mostrarMensaje(nombre + " se va porque la cafetería está cerrada.");
            } else {
                controlador.mostrarMensaje(nombre + " se ha cansado de esperar y se PIRA");
            }
        } catch (InterruptedException e) {
            if (controlador.cerrado) {
                controlador.mostrarMensaje(nombre + " se va porque la cafetería ha CERRADO");
            } else {
                controlador.mostrarMensaje(nombre + " ha recibido su cafe");
                controlador.totalServido++;
            }
        }
    }
}
