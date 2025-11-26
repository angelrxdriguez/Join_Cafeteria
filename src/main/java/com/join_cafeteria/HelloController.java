package com.join_cafeteria;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class HelloController {

    @FXML
    private TextArea logs;
    public int contadorCamarero;
    public int totalServido;
    public int totalPedido;
    public boolean cerrado;

    private Camarero camarero;
    private Cliente c1;
    private Cliente c2;

    public void mostrarMensaje(String texto) {
        Platform.runLater(() -> logs.appendText(texto + "\n"));
    }

    @FXML
    protected void onHelloButtonClick() {
        logs.clear();
        mostrarMensaje("Simulación iniciada...");

        cerrado = false;
        totalServido = 0;
        totalPedido = 2;
        contadorCamarero=0;
        /*camarero = new Camarero("Pedro", this);*/
        c1 = new Cliente("Ana", 5000, this);
        c2 = new Cliente("Luis", 7000, this);
        c1.start();
        c2.start();
/*
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                camarero.prepararCafe(c1);
                Thread.sleep(1000);
                camarero.prepararCafe(c2);
                mostrarMensaje("CAMARERO HA TERMINADO).");
            } catch (InterruptedException e) {
                mostrarMensaje("Hilo del camarero interrumpido.");
            }
        }).start(); */
    }
    @FXML
    public void hola(ActionEvent actionEvent) {
        mostrarMensaje("Resumen: " + totalServido + "/" + totalPedido);
    }
    @FXML
    public void btnCerrar(ActionEvent actionEvent) {
        if (cerrado) {
            mostrarMensaje("CERRADO");
            return;
        }
        cerrado = true;
        mostrarMensaje("CERRADO, NO SE ATIENDEN MAS CLIENTES");
        if (c1.isAlive()) {
            c1.interrupt();
        }
        if (c2.isAlive()) {
            c2.interrupt();
        }
    }

    public void btnCamarero(ActionEvent actionEvent) {
        contadorCamarero ++;
        camarero = new Camarero("CAMARERO"+ " "+contadorCamarero, this);
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                camarero.prepararCafe(c1);
                Thread.sleep(1000);
                camarero.prepararCafe(c2);
                mostrarMensaje("CAMARERO HA TERMINADO).");
            } catch (InterruptedException e) {
                mostrarMensaje("Hilo del camarero interrumpido.");
            }
        }).start();
    }
}
