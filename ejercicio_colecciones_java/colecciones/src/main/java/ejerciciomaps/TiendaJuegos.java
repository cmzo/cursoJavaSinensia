package ejerciciomaps;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TiendaJuegos {

    public static void main(String[] args) {

        // Catálogo: nombre → precio
        Map<String, Double> catalogo = new HashMap<>();
        catalogo.put("Zelda", 59.99);
        catalogo.put("Mario", 49.99);
        catalogo.put("Metroid", 39.99);
        catalogo.put("Pokemon", 54.99);
        catalogo.put("Kirby", 44.99);
        catalogo.put("Splatoon", 49.99);
        catalogo.put("Xenoblade", 59.99);
        catalogo.put("Fire Emblem", 44.99);

        // Ventas: nombre → unidades vendidas
        Map<String, Integer> ventas = new HashMap<>();
        ventas.put("Zelda", 320);
        ventas.put("Mario", 580);
        ventas.put("Metroid", 150);
        ventas.put("Pokemon", 410);
        ventas.put("Kirby", 90);
        ventas.put("Splatoon", 275);
        ventas.put("Xenoblade", 60);
        ventas.put("Fire Emblem", 180);


        //Caso 1. Recorrer un MAP
        System.out.println("=== CASO 1: Recorrer un Map ===\n");
        // Con entrySet (lo que ya conocéis)
        for (Map.Entry<String, Double> entry : catalogo.entrySet()) {
            System.out.printf("  %-15s → %5.2f €%n", entry.getKey(), entry.getValue());
        }

         // Map.forEach recibe (clave, valor) directamente
        System.out.println("\nCon forEach + lambda:");
        catalogo.forEach((juego, precio) ->
            System.out.printf("  %-15s → %5.2f €%n", juego, precio));

        
        //Caso 2. Filtrar entradas de un MAP - Forma Clásica
        System.out.println("\n=== CASO 2: Filtrar un Map ===\n");

        Map<String, Double> baratos = new HashMap<>();
        for (Map.Entry<String, Double> entry : catalogo.entrySet()) {
            if (entry.getValue() < 50.0) {
                baratos.put(entry.getKey(), entry.getValue());
            }
        }
        System.out.println("Clásico - Baratos: " + baratos);



        // entrySet().stream() → Stream<Map.Entry<K, V>>
        Map<String, Double> baratosStream = catalogo.entrySet().stream()
            .filter(entry -> entry.getValue() < 50.0)
            .collect(Collectors.toMap(
                Map.Entry::getKey,     // función que extrae la clave
                Map.Entry::getValue    // función que extrae el valor
            ));
        System.out.println("Stream  - Baratos: " + baratosStream);


        //Caso 3. Transformar los valores de un Map
        System.out.println("\n=== CASO 3: Transformar valores ===\n");

        Map<String, Double> conDescuentoClasico = new HashMap<>();
        for (Map.Entry<String, Double> entry : catalogo.entrySet()) {
            conDescuentoClasico.put(entry.getKey(), entry.getValue() * 0.80);
        }

        Map<String, Double> conDescuento = catalogo.entrySet().stream()
            .collect(Collectors.toMap(
                Map.Entry::getKey,                  // clave: se mantiene
                entry -> entry.getValue() * 0.80    // valor: precio con descuento
            ));

        conDescuento.forEach((juego, precio) ->
            System.out.printf("  %-15s → %5.2f € (antes %5.2f €)%n",
                juego, precio, catalogo.get(juego)));

 }

}
