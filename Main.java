public class Main {
    public static void main(String[] args) {
        // Punto 1: Implementar el tipo abstracto de datos grafo usando matriz de adyacencia
        System.out.println("Punto 1: Implementación de Grafo en Matriz de Adyacencia");
        GrafoMatriz grafo = new GrafoMatriz(7);
        grafo.agregarConexion(0, 1, 2);
        grafo.agregarConexion(0, 2, 4);
        grafo.agregarConexion(1, 3, 1);
        grafo.agregarConexion(1, 4, 7);
        grafo.agregarConexion(2, 5, 3);
        grafo.agregarConexion(2, 6, 1);
        System.out.println(grafo);

        // Punto 2: Algoritmo de camino mínimo sin pesos (BFS)
        System.out.println("\nPunto 2: Camino mínimo sin pesos usando BFS");
        BusquedaAnchura bfs = new BusquedaAnchura(grafo, 0);
        bfs.ejecutar();
        System.out.println(bfs);

        // Punto 3: Determinar si el grafo es acíclico
        System.out.println("\nPunto 3: Determinar si el grafo es acíclico");
        if (grafo.esAciclico()) {
            System.out.println("El grafo es acíclico.");
        } else {
            System.out.println("El grafo contiene ciclos.");
        }

        // Punto 4: Implementar el TDA árbol y operaciones básicas
        System.out.println("\nPunto 4: Operaciones del TDA Árbol");
        Arbol arbol = new Arbol(1);
        Arbol.NodoArbol nodo2 = arbol.agregarHijo(arbol.getRaiz(), 2);
        Arbol.NodoArbol nodo3 = arbol.agregarHijo(arbol.getRaiz(), 3);
        arbol.agregarHijo(nodo2, 4);
        arbol.agregarHijo(nodo2, 5);
        arbol.agregarHijo(nodo3, 6);
        arbol.agregarHijo(nodo3, 7);
        System.out.println("Árbol creado con raíz y nodos hijos.");

        // Punto 5: Recorrer el árbol de manera recursiva
        System.out.println("\nPunto 5: Recorridos del Árbol");
        RecorridoArbol recorrido = new RecorridoArbol();
        System.out.print("PreOrden: ");
        recorrido.preOrden(arbol.getRaiz());
        System.out.println();
        System.out.print("EnOrden: ");
        recorrido.enOrden(arbol.getRaiz());
        System.out.println();
        System.out.print("PostOrden: ");
        recorrido.postOrden(arbol.getRaiz());
        System.out.println();

        // Punto 6: Algoritmo de Dijkstra para camino más corto entre dos nodos
        System.out.println("\nPunto 6: Camino más corto usando Dijkstra");
        AlgoritmoDijkstra dijkstra = new AlgoritmoDijkstra(7);
        dijkstra.agregarArco(0, 1, 2);
        dijkstra.agregarArco(0, 2, 4);
        dijkstra.agregarArco(1, 3, 1);
        dijkstra.agregarArco(1, 4, 7);
        dijkstra.agregarArco(2, 5, 3);
        dijkstra.agregarArco(2, 6, 1);

        // Calcular y mostrar el camino más corto entre los nodos 0 y 4
        dijkstra.encontrarCaminoMinimo(0, 4);
    }
}
