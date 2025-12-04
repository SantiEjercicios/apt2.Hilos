import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore; // IMPORTANTE

public class Barco {
    private List<Pasajero> pasajeros;

    private Semaphore semaforo = new Semaphore(1, true);

    public Barco() {
        this.pasajeros = new ArrayList<>();
        generarTripulacion();
        ordenarPorPrioridad();
    }

    private void generarTripulacion() {
        Random rand = new Random();

        for (int i = 1; i <= 352; i++) {
            int tipo = rand.nextInt(4) + 1;
            String cat = switch (tipo) {
                case 1 -> "Niño";
                case 2 -> "Adulto";
                case 3 -> "Anciano";
                default -> "Tripulación";
            };
            pasajeros.add(new Pasajero("P-" + i, tipo));
        }
    }

    private void ordenarPorPrioridad() {
        pasajeros.sort(Comparator.comparingInt(Pasajero::getPrioridad));
        System.out.println("--- BARCO: Pasajeros ordenados y listos (Protegido por SEMÁFORO) ---");
    }


    public Pasajero obtenerPasajero() {
        Pasajero p = null;
        try {

            semaforo.acquire();


            if (!pasajeros.isEmpty()) {
                p = pasajeros.remove(0);
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

            semaforo.release();
        }
        return p;
    }
}