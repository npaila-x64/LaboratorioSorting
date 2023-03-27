package org.app;

public abstract class Sort {

    protected long[] a;

    public abstract void insert(long value);
    public abstract long[] obtenerElementos();
    public abstract void ordenar();
    public abstract void display();

    // Dado un arreglo de tipo long, retorna otro arreglo de
    // tipo long con el orden de sus elementos invertidos
    public void invertirOrden() {
        int midPosition = a.length / 2;
        for (int index = 0; index < midPosition;index++) {
            long temp = a[index];
            a[index] = a[a.length - 1 - index];
            a[a.length - 1 - index] = temp;
        }
    }

}
