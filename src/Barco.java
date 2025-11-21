import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Barco {
    private List<Pasajero> pasajeros;

    public Barco() {
        this.pasajeros = new ArrayList<>();
        generarTripulacion();
        ordenarPorPrioridad();
    }

    private void generarTripulacion() {
        Random rand = new Random();

        for (int i = 1; i <= 352; i++) {
            int tipo = rand.nextInt(4) + 1; // 1 a 4
            String cat = "";
            switch (tipo) {
                case 1 -> cat = "Niño";
                case 2 -> cat = "Adulto";
                case 3 -> cat = "Anciano";
                default -> cat = "Tripulación"; // 4
            }

            pasajeros.add(new Pasajero("P-"+i,tipo));

        }
    }

    private void ordenarPorPrioridad() {

        pasajeros.sort(Comparator.comparingInt(Pasajero::getPrioridad));
        System.out.println("--- BARCO: Pasajeros ordenados por prioridad ---");
    }


    public synchronized Pasajero obtenerPasajero() {
        if (!pasajeros.isEmpty()) {
            return pasajeros.remove(0);
        }
        return null; }
}