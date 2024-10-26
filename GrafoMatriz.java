import java.util.Arrays;

public class GrafoMatriz {
    private int numVertices;
    private int[][] matrizAdyacencia;

    public GrafoMatriz(int numVertices) {
        this.numVertices = numVertices;
        matrizAdyacencia = new int[numVertices][numVertices];
        for (int[] fila : matrizAdyacencia) {
            Arrays.fill(fila, 0);
        }
    }

    public int[][] getMatrizAdyacencia() {
        return matrizAdyacencia;
    }

    public void agregarConexion(int origen, int destino, int costo) {
        matrizAdyacencia[origen][destino] = costo;
    }

    public boolean esAciclico() {
        boolean[] visitado = new boolean[numVertices];
        boolean[] enCamino = new boolean[numVertices];

        for (int i = 0; i < numVertices; i++) {
            if (!visitado[i] && tieneCiclo(i, visitado, enCamino)) {
                return false;  // Si encuentra un ciclo, el grafo no es acíclico
            }
        }
        return true;  // Si no encuentra ningún ciclo, el grafo es acíclico
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Matriz de adyacencia:\n");

        for (int[] fila : matrizAdyacencia) {
            sb.append(Arrays.toString(fila));
            sb.append("\n");
        }

        return sb.toString();
    }

    private boolean tieneCiclo(int nodo, boolean[] visitado, boolean[] enCamino) {
        if (enCamino[nodo]) return true;  // Si el nodo ya está en el camino actual, hay un ciclo
        if (visitado[nodo]) return false; // Si el nodo ya fue visitado pero no está en el camino actual, no hay ciclo

        visitado[nodo] = true;
        enCamino[nodo] = true;

        for (int vecino = 0; vecino < numVertices; vecino++) {
            if (matrizAdyacencia[nodo][vecino] != 0 && tieneCiclo(vecino, visitado, enCamino)) {
                return true;
            }
        }

        enCamino[nodo] = false;  // Eliminamos el nodo del camino actual antes de regresar
        return false;
    }
}
