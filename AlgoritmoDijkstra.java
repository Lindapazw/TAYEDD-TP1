import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class AlgoritmoDijkstra {
    private static class Nodo {
        int id;
        int distancia;

        Nodo(int id, int distancia) {
            this.id = id;
            this.distancia = distancia;
        }
    }
    private final int vertices;

    private int[][] matrizAdyacencia;

    public AlgoritmoDijkstra(int vertices) {
        this.vertices = vertices;
        matrizAdyacencia = new int[vertices][vertices];
        for (int[] fila : matrizAdyacencia) Arrays.fill(fila, Integer.MAX_VALUE); // Inicializamos la matriz en infinito
    }

    public void agregarArco(int origen, int destino, int peso) {
        matrizAdyacencia[origen][destino] = peso;
    }

    public void encontrarCaminoMinimo(int inicio, int fin) {
        int[] distancias = new int[vertices];
        boolean[] visitados = new boolean[vertices];
        Arrays.fill(distancias, Integer.MAX_VALUE);
        distancias[inicio] = 0;

        PriorityQueue<Nodo> cola = new PriorityQueue<>(Comparator.comparingInt(n -> n.distancia));
        cola.add(new Nodo(inicio, 0));

        while (!cola.isEmpty()) {
            Nodo actual = cola.poll();
            int u = actual.id;

            if (visitados[u]) continue;
            visitados[u] = true;

            for (int v = 0; v < vertices; v++) {
                if (matrizAdyacencia[u][v] != Integer.MAX_VALUE && !visitados[v]) {
                    int nuevaDistancia = distancias[u] + matrizAdyacencia[u][v];
                    if (nuevaDistancia < distancias[v]) {
                        distancias[v] = nuevaDistancia;
                        cola.add(new Nodo(v, distancias[v]));
                    }
                }
            }
        }

        System.out.println("Distancia mínima de " + (inicio + 1) + " a " + (fin + 1) + ": " + distancias[fin]);
    }
}
