public class Asistente {
    private String nombre;
    private String horaLlegada;

    public Asistente(String nombre, String horaLlegada) {
        this.nombre = nombre;
        this.horaLlegada = horaLlegada;
    }

    public String getNombre(){
        return nombre;
    }

    public String getHoraLlegada(){
        return horaLlegada;
    }


    @Override
    public String toString(){
        return "Asistente[nombre = " + nombre + ", horaLlegada = " + horaLlegada + "]";
    }

}
