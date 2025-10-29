package com.join_cafeteria;

public class Camarero {

    private String nombre;

    public Camarero(String nombre) {
        this.nombre = nombre;
    }

    public void prepararCafe(Cliente cliente) {
        System.out.println(nombre + " está preparando el café de " + cliente.getNombre() + "...");
        try {
            Thread.sleep(2000);
            System.out.println(nombre + " ha terminado el cafe de " + cliente.getNombre() + ".");
            cliente.interrupt();
        } catch (InterruptedException e) {
            System.out.println(nombre + " fue interrumpido mientras preparaba el café.");
        }
    }
}
