package org.app;

import org.app.BubbleSort.BubbleSort;
import org.app.InsertSort.InsertSort;
import org.app.SelectSort.SelectSort;

public class Main {
    public static void main(String[] args) {
        int n = 100000;

        Sort A1 = new BubbleSort(n);
        Sort A2 = new InsertSort(n);
        Sort A3 = new SelectSort(n);

        System.out.println("ITEM 1 (Caso Orden Aleatorio)");
        llenarArreglos(A1, A2, A3, n);
        medirTiemposDeEjecucion(A1, A2, A3);
        /*
        Tal como lo visto en clases, el algoritmo de peor rendimiento normalmente es el BubbleSort, mientras
        que el InsertSort es el de mayor eficiencia y el SelectionSort se mantiene entre ambos.
         */
        System.out.println();
        System.out.println("ITEM 2 (Caso Orden Invertido)");
        invertirArreglos(A1, A2, A3);
        medirTiemposDeEjecucion(A1, A2, A3);
        /*
        Cuando los arreglos están invertidos, el BubbleSort suele tener un mejor rendimiento mientras que el
        InsertionSort "debería" tener el peor rendimiento de entre los algoritmos.
        */
    }

    private static void invertirArreglos(Sort A1, Sort A2, Sort A3) {
        A1.invertirOrden();
        A2.invertirOrden();
        A3.invertirOrden();
    }

    public static void medirTiemposDeEjecucion(Sort A1, Sort A2, Sort A3){
        System.out.print("BubbleSort A1: ");
        medirTiempoDeEjecucion(A1);
        System.out.print("InsertSort A2: ");
        medirTiempoDeEjecucion(A2);
        System.out.print("SelectionSort A3: ");
        medirTiempoDeEjecucion(A3);
    }

    public static void medirTiempoDeEjecucion(Sort algoritmo){
        long start = System.currentTimeMillis();
        algoritmo.ordenar();
        long time = System.currentTimeMillis() - start;
        System.out.println(time + "ms");
    }

    public static void llenarArreglos(Sort A1, Sort A2, Sort A3, int n){
        for (int index = 0; index < n; index++) {
            A1.insert(Math.round(Math.random() * n));
        }
        for (long element : A1.obtenerElementos()) {
            A2.insert(element);
            A3.insert(element);
        }
    }
}
