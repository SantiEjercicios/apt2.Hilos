import java.util.ArrayList;
import java.util.List;

public class Balsa extends Thread {
    private int capacidad;
    private double tiempoRescate;
    private Barco barco;
    private List<Pasajero> ocupantes;

    public Balsa(String nombre, int capacidad, double tiempoRescate, Barco barco) {
        super(nombre);
        this.capacidad = capacidad;
        this.tiempoRescate = tiempoRescate;
        this.barco = barco;
        this.ocupantes = new ArrayList<>();
    }

    @Override
    public void run() {
        try {
            while (true) {

                while (ocupantes.size() < capacidad) {

                    Pasajero p = barco.obtenerPasajero();

                    if (p == null) {

                        break;
                    }
                    ocupantes.add(p);
                }


                if (ocupantes.isEmpty()) {

                    System.out.println(getName() + " finaliza su servicio (No hay más pasajeros).");
                    break;
                }


                reportarLlegada();


                long tiempoEsperaMs = (long) (tiempoRescate * 100);
                Thread.sleep(tiempoEsperaMs);


                ocupantes.clear();
            }
        } catch (InterruptedException e) {
            System.out.println(getName() + " ha sido interrumpida.");
        }
    }

    private void reportarLlegada() {
        StringBuilder sb = new StringBuilder();


        sb.append(">>> Balsa ").append(getName())
                .append(" (Tiempo rescate: ").append(tiempoRescate).append("s)"+"\n");

        sb.append("    Total rescatados en este viaje: ").append(ocupantes.size()).append("\n");
        sb.append("    Pasajeros: ");

        for (Pasajero p : ocupantes) {
            sb.append("[").append(p.getId()).append("-P").append(p.getPrioridad()).append("] ");
        }
        System.out.println(sb.toString());
    }
}