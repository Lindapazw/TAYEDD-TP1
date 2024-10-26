import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BusquedaAnchura {
    private GrafoMatriz grafo;
    private int nodoInicial;
    private Map<Integer, Integer> distanciaMinima = new HashMap<>();
    private List<Integer> nodosRecorridos = new ArrayList<>();
    private Map<Integer, Integer> predecesores = new HashMap<>();

    public BusquedaAnchura(GrafoMatriz grafo, int nodoInicial) {
        this.grafo = grafo;
        this.nodoInicial = nodoInicial;
    }

    public void ejecutar() {
        int[][] matriz = grafo.getMatrizAdyacencia();

        if (matriz == null || matriz.length == 0) {
            System.out.println("La matriz de adyacencia está vacía.");
            return;
        }

        Queue<Integer> cola = new LinkedList<>();
        cola.add(nodoInicial);
        distanciaMinima.put(nodoInicial, 0);

        while (!cola.isEmpty()) {
            int nodoActual = cola.poll();
            nodosRecorridos.add(nodoActual);

            for (int vecino = 0; vecino < matriz[nodoActual].length; vecino++) {
                if (matriz[nodoActual][vecino] == 0 || distanciaMinima.containsKey(vecino))
                    continue;

                distanciaMinima.put(vecino, distanciaMinima.get(nodoActual) + 1);
                predecesores.put(vecino, nodoActual);
                cola.add(vecino);
            }
        }
    }

    public List<Integer> obtenerRuta(int destino) {
        List<Integer> ruta = new ArrayList<>();
        for (Integer nodo = destino; nodo != null; nodo = predecesores.get(nodo)) {
            ruta.add(nodo);
        }
        return ruta;
    }

    public Map<Integer, Integer> obtenerDistancias() {
        return distanciaMinima;
    }

    public List<Integer> obtenerNodosRecorridos() {
        return nodosRecorridos;
    }
}
