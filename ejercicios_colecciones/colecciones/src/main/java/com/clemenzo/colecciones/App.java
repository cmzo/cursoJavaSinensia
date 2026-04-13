package com.clemenzo.colecciones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.clemenzo.Alumno;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        //Paso 2
        Alumno[] alumnos = new Alumno[3];
        try {
            alumnos[0] = new Alumno("Ana", "123A");
            alumnos[1] = new Alumno("Luis", "456B");
            alumnos[2] = new Alumno("María", "789C");
            alumnos[3] = new Alumno("Extra", "000Z"); // lanza excepción
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: fuera de rango en el array de alumnos.");
        }

        //Paso 3
        List<Alumno> listaArray = new ArrayList<>(Arrays.asList(alumnos));
        List<Alumno> listaLinked = new LinkedList<>(Arrays.asList(alumnos));

        // Eliminar por índice
        listaArray.remove(1);

        // Eliminar por objeto (¿funciona?)
        Alumno aEliminar = new Alumno("Ana", "123A");
        listaLinked.remove(aEliminar);

        //Paso 4
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        long t1 = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(0, i);
        }
        long t2 = System.nanoTime();
        System.out.println("ArrayList inserción al inicio: " + (t2 - t1) + " ns");

        t1 = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            linkedList.add(0, i);
        }
        t2 = System.nanoTime();
        System.out.println("LinkedList inserción al inicio: " + (t2 - t1) + " ns");

        //Paso 5
        Set<Alumno> conjunto = new HashSet<>();
        Alumno a1 = new Alumno("Pepe", "111X");
        Alumno a2 = new Alumno("Pepe", "111X");

        conjunto.add(a1);
        conjunto.add(a2);

        System.out.println("Tamaño del conjunto: " + conjunto.size());

        //Paso 6
        
    }
}
