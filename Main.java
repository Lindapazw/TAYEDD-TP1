public class Main {
    public static void main(String[] args) {
        // Punto 1: Implementar el tipo abstracto de datos grafo usando matriz de adyacencia
        System.out.println("Punto 1: Implementación de Grafo en Matriz de Adyacencia");
        System.out.println("Creando un grafo con 7 nodos y las siguientes conexiones con sus respectivos pesos:");
        
        System.out.println(" - Nodo 0 a Nodo 1 con peso 2");
        System.out.println(" - Nodo 0 a Nodo 2 con peso 4");
        System.out.println(" - Nodo 1 a Nodo 3 con peso 1");
        System.out.println(" - Nodo 1 a Nodo 4 con peso 7");
        System.out.println(" - Nodo 2 a Nodo 5 con peso 3");
        System.out.println(" - Nodo 2 a Nodo 6 con peso 1");
        
        GrafoMatriz grafo = new GrafoMatriz(7);
        grafo.agregarConexion(0, 1, 2);
        grafo.agregarConexion(0, 2, 4);
        grafo.agregarConexion(1, 3, 1);
        grafo.agregarConexion(1, 4, 7);
        grafo.agregarConexion(2, 5, 3);
        grafo.agregarConexion(2, 6, 1);
        System.out.println("Matriz de Adyacencia del Grafo:");
        System.out.println(grafo);

        // Punto 2: Algoritmo de camino mínimo sin pesos (BFS)
        System.out.println("\nPunto 2: Camino mínimo sin pesos usando BFS");
        System.out.println("Aplicamos el algoritmo BFS para encontrar el camino mínimo desde el nodo inicial (0) a todos los demás.");
        BusquedaAnchura bfs = new BusquedaAnchura(grafo, 0);
        bfs.ejecutar();
        System.out.println("Resultados del recorrido BFS:");
        System.out.println(bfs);

        // Punto 3: Determinar si el grafo es acíclico
        System.out.println("\nPunto 3: Determinación de la aciclicidad del Grafo");
        System.out.println("Verificamos si el grafo tiene ciclos.");
        if (grafo.esAciclico()) {
            System.out.println("Resultado: El grafo es acíclico (no tiene ciclos).");
        } else {
            System.out.println("Resultado: El grafo contiene ciclos.");
        }

        // Punto 4: Implementar el TDA árbol y operaciones básicas
        System.out.println("\nPunto 4: Creación del TDA Árbol y operaciones básicas");
        System.out.println("Creamos un árbol con la siguiente estructura:");
        System.out.println(" - Raíz: Nodo 1");
        System.out.println(" - Hijos de la raíz: Nodos 2 y 3");
        System.out.println(" - Hijos del Nodo 2: Nodos 4 y 5");
        System.out.println(" - Hijos del Nodo 3: Nodos 6 y 7");

        Arbol arbol = new Arbol(1);
        Arbol.NodoArbol nodo2 = arbol.agregarHijo(arbol.getRaiz(), 2);
        Arbol.NodoArbol nodo3 = arbol.agregarHijo(arbol.getRaiz(), 3);
        arbol.agregarHijo(nodo2, 4);
        arbol.agregarHijo(nodo2, 5);
        arbol.agregarHijo(nodo3, 6);
        arbol.agregarHijo(nodo3, 7);
        System.out.println("Estructura visual del árbol:");
        arbol.imprimirArbol();

        // Punto 5: Recorrer el árbol de manera recursiva
        System.out.println("\nPunto 5: Recorridos del Árbol en diferentes órdenes");
        System.out.println("Realizamos los siguientes recorridos en el árbol:");
        RecorridoArbol recorrido = new RecorridoArbol();
        System.out.print("Recorrido PreOrden: ");
        recorrido.preOrden(arbol.getRaiz());
        System.out.println();
        System.out.print("Recorrido EnOrden: ");
        recorrido.enOrden(arbol.getRaiz());
        System.out.println();
        System.out.print("Recorrido PostOrden: ");
        recorrido.postOrden(arbol.getRaiz());
        System.out.println();

        // Punto 6: Algoritmo de Dijkstra para camino más corto entre dos nodos
        System.out.println("\nPunto 6: Camino más corto usando el Algoritmo de Dijkstra");
        System.out.println("Aplicamos el algoritmo de Dijkstra para encontrar el camino más corto entre el nodo 0 y el nodo 4.");
        System.out.println("Se consideran las mismas conexiones y pesos definidos en el grafo del Punto 1.");
        
        AlgoritmoDijkstra dijkstra = new AlgoritmoDijkstra(7);
        dijkstra.agregarArco(0, 1, 2);
        dijkstra.agregarArco(0, 2, 4);
        dijkstra.agregarArco(1, 3, 1);
        dijkstra.agregarArco(1, 4, 7);
        dijkstra.agregarArco(2, 5, 3);
        dijkstra.agregarArco(2, 6, 1);

        System.out.println("Resultado del Camino Más Corto de Dijkstra:");
        dijkstra.encontrarCaminoMinimo(0, 4);
    }
}
