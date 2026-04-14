package com.sinensia.ejercicio.colecciones.collections;

import java.util.List;

public class App {
    public static void main(String[] args) {
        
        List<Animal> animales = List.of(
        new Animal("Tigre", 5, 220),
        new Animal("Leon", 8, 190),
        new Animal("Lince", 3, 25),
        new Animal("Oso", 12, 350),
        new Animal("Lobo", 6, 45)
        );

        // 1. Recorrer y mostrar todos los animales
        System.out.println("=== Todos los animales ===");
        for (Animal animal : animales) {
            System.out.println(animal);
        }
        
        // 2. Contar cuántos animales pesan más de 100 kg. (pista contador + bucle foreach + if a> 100 - contador ++)
        System.out.println("Animales que pesan mas de 100 KG:");
        int contadorAnimalesPesados = 0;
        for(Animal animal : animales) {
            if (animal.getPesoKg() > 100)
            System.out.println(animal);
            contadorAnimalesPesados ++;
        }

        // 3. Obtener el animal de mayor edad. (pusta masViejo es el primero luego blucle uno por uno comparamos y vamos sustituyen masViejo según sea mayor que el anterior)
        

    }
}
