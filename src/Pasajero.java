public class Pasajero {
    private String id;
    private int prioridad;



    public Pasajero(String id, int prioridad ) {
        this.id = id;
        this.prioridad = prioridad;

    }

    public int getPrioridad() {
        return prioridad;
    }

    public String getId() {
        return id;
    }



    @Override
    public String toString() {
        return "Pasajero{" +
                "id='" + id + '\'' +
                ", prioridad='" + prioridad + '\'' +
                '}';
    }
}