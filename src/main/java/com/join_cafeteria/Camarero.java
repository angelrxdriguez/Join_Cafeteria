package com.join_cafeteria;

public class Camarero {

    private String nombre;
    private HelloController controlador;

    public Camarero(String nombre, HelloController controlador) {
        this.nombre = nombre;
        this.controlador = controlador;
    }

    public void prepararCafe(Cliente cliente) {
        controlador.mostrarMensaje(nombre + " está preparando el café de " + cliente.getNombre() + "...");
        try {
            Thread.sleep(2000);
            controlador.mostrarMensaje(nombre + " ha terminado el café de " + cliente.getNombre() + ".");
            cliente.interrupt();
        } catch (InterruptedException e) {
            controlador.mostrarMensaje(nombre + " fue interrumpido mientras preparaba el café.");
        }
    }
}
