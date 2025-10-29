package com.join_cafeteria;

public class HelloController {

    public static void main(String[] args) {

        System.out.println("Simulación iniciada...");

        Camarero camarero = new Camarero("Pedro");
        Cliente c1 = new Cliente("Ana", 4000);
        Cliente c2 = new Cliente("Luis", 3000);

        c1.start();
        c2.start();
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                camarero.prepararCafe(c1);
                Thread.sleep(1000);
                camarero.prepararCafe(c2);
                System.out.println("TODOS LOS PEDIDOS SERVIDOS");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
