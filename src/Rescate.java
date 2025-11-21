public class Rescate {
    private Barco barco;

    public Rescate() {
        this.barco = new Barco();
    }

    public void comenzarRescate() {
        System.out.println("!!! COMIENZA EL OPERATIVO DE RESCATE CON HILOS !!!");

        Balsa b1 = new Balsa("Acasta", 1, 10.5, barco);
        Balsa b2 = new Balsa("Banff", 2, 21, barco);
        Balsa b3 = new Balsa("Cadiz", 3, 32, barco);
        Balsa b4 = new Balsa("Deimos", 4, 44, barco);
        Balsa b5 = new Balsa("Expedición", 5, 58, barco);


        b1.start();
        b2.start();
        b3.start();
        b4.start();
        b5.start();


        try {
            b1.join();
            b2.join();
            b3.join();
            b4.join();
            b5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("--- RESCATE COMPLETADO ---");
    }
}