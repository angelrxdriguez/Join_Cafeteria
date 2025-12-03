package com.join_cafeteria;

public class Barista {

    private String nombre;
    private HelloController controlador;
    private Buffer buffer;

    public Barista(String nombre, HelloController controlador, Buffer buffer) {
        this.nombre = nombre;
        this.controlador = controlador;
        this.buffer = buffer;
        controlador.mostrarMensaje("Ha empezado el barista " + this.nombre);
    }

    public void prepararCafe(Cliente cliente) {
        controlador.mostrarMensaje(nombre + " está preparando el café de " + cliente.getNombre() + "...");
        try {
            Thread.sleep(2000);
            controlador.mostrarMensaje(nombre + " ha terminado el café de " + cliente.getNombre() + ".");


            buffer.put(cliente);
            controlador.mostrarMensaje(nombre + " ha dejado el café en el buffer.");

        } catch (InterruptedException e) {
            controlador.mostrarMensaje(nombre + " fue interrumpido mientras preparaba el café.");
        }
    }
}
