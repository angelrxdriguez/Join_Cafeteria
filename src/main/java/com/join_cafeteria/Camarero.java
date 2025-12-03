package com.join_cafeteria;

public class Camarero {

    private String nombre;
    private HelloController controlador;
    private Buffer buffer;

    public Camarero(String nombre, HelloController controlador, Buffer buffer) {
        this.nombre = nombre;
        this.controlador = controlador;
        this.buffer = buffer;
        controlador.mostrarMensaje("Ha empezado el camarero " + this.nombre);
    }

    public void atenderCliente(Barista barista, Cliente cliente) {
        controlador.mostrarMensaje(nombre + " avisa al barista para el café de " + cliente.getNombre());


        barista.prepararCafe(cliente);


        Cliente clienteConCafe = buffer.get();

        if (clienteConCafe != null) {
            controlador.mostrarMensaje(nombre + " coge un café del buffer para " + clienteConCafe.getNombre());

            clienteConCafe.interrupt();
            controlador.mostrarMensaje(nombre + " entrega el café a " + clienteConCafe.getNombre());
        } else {
            controlador.mostrarMensaje(nombre + " no ha encontrado café en el buffer.");
        }
    }
}
