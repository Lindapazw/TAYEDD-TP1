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
                return false;
            }
        }
        return true;
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
        if (enCamino[nodo]) return true;
        if (visitado[nodo]) return false;

        visitado[nodo] = true;
        enCamino[nodo] = true;

        for (int vecino = 0; vecino < numVertices; vecino++) {
            if (matrizAdyacencia[nodo][vecino] != 0 && tieneCiclo(vecino, visitado, enCamino)) {
                return true;
            }
        }

        enCamino[nodo] = false;
        return false;
    }
}
