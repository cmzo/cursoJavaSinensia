## Repositorio para ejercicios del curso Sinensia Abril 2026

En este repositorio se irán subiendo los ejercicios del curso brindado por Sinensia en abril de 2026

### Ejercicio de fitrado con Predicate [15/04]

```java

package com.sinensia.ejercicio.colecciones.collections.EjercicioFiltradoConPredicate;

import java.util.List;
import java.util.function.Predicate;


public class App {

    public static void main(String[] args){
        record Jugador(String nombre, int edad, String posicion, double salario, boolean lesionado) {}

        var plantilla = List.of(
        new Jugador("Lamine Yamal", 17, "extremo", 6_000_000, false),
        new Jugador("Pedri", 21, "centrocampista", 8_000_000, true),
        new Jugador("Gavi", 20, "centrocampista", 5_000_000, true),
        new Jugador("Araujo", 25, "defensa", 7_000_000, false),
        new Jugador("Ter Stegen", 32, "portero", 12_000_000, true),
        new Jugador("Raphinha", 27, "extremo", 9_000_000, false),
        new Jugador("Fermín López", 21, "centrocampista", 3_000_000, false),
        new Jugador("Pau Cubarsí", 17, "defensa", 2_000_000, false),
        new Jugador("Lewandowski", 36, "delantero", 15_000_000, false),
        new Jugador("De Jong", 27, "centrocampista", 14_000_000, true)
);
    
        // ── Predicados básicos ────────────────────────────────────────────────────

        Predicate<Jugador> noLesionado    = j -> !j.lesionado();
        Predicate<Jugador> menores        = j -> j.edad() < 22;
        Predicate<Jugador> salarioAlto    = j -> j.salario() > 8_000_000;
        Predicate<Jugador> centrocampista = j -> j.posicion().equals("centrocampista");

        // ── Predicados auxiliares para composición ────────────────────────────────

        Predicate<Jugador> esPortero      = j -> j.posicion().equals("portero");
        Predicate<Jugador> menorTreinta   = j -> j.edad() < 30;
        Predicate<Jugador> esDelantero    = j -> j.posicion().equals("delantero");

        // ── Composición ───────────────────────────────────────────────────────────

        Predicate<Jugador> disponiblesJovenes  = noLesionado.and(menores);
        Predicate<Jugador> porterosOLesionados = esPortero.or(noLesionado.negate());
        Predicate<Jugador> delanteroJoven      = menorTreinta.or(esDelantero);
        Predicate<Jugador> convocable          = delanteroJoven.and(noLesionado);


        // ── Formato de Salida ───────────────────────────────────────────────────────────
        plantilla.stream()
                .filter(convocable)
                .forEach(j -> System.out.println("nombre: " + j.nombre() + ", posición: " + j.posicion() + ", salario: " + String.format("%,.0f €", j.salario())));

}

}



```
