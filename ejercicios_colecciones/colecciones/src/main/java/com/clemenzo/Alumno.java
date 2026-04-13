package com.clemenzo;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
    private String nombre;
    private String dni;
    private List<String> cursos;

    public Alumno(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        this.cursos = new ArrayList<>();
    }

    public void inscribirCurso(String curso) {
        cursos.add(curso);
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    @Override
    public String toString() {
        return nombre + " (" + dni + ") - Cursos: " + cursos;
    }

    // Implementaremos equals y hashCode más adelante
}
