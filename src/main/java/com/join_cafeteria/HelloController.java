package com.join_cafeteria;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class HelloController {

    @FXML
    private TextArea logs;
    public void mostrarMensaje(String texto) {
        Platform.runLater(() -> logs.appendText(texto + "\n"));
    }

    @FXML
    protected void onHelloButtonClick() {
        logs.clear();
        mostrarMensaje("Simulación iniciada...");
        Camarero camarero = new Camarero("Pedro", this);
        Cliente c1 = new Cliente("Ana", 4000, this);
        Cliente c2 = new Cliente("Luis", 3000, this);
        c1.start();
        c2.start();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
                camarero.prepararCafe(c1);
                Thread.sleep(1000);
                camarero.prepararCafe(c2);
                mostrarMensaje("TODOS LOS PEDIDOS SERVIDOS");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
