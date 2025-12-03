package com.join_cafeteria;

public class Buffer {

    private Cliente cliente;
    private boolean disponible;

    public Buffer() {
        this.disponible = false;
        this.cliente = null;
    }

    public void put(Cliente cliente) {
        this.cliente = cliente;
        this.disponible = true;
    }

    public Cliente get() {
        if (disponible) {
            Cliente c = this.cliente;
            this.cliente = null;
            this.disponible = false;
            return c;
        } else {
            return null;
        }
    }
}
