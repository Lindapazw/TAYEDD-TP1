public class RecorridoArbol {
    public void preOrden(Arbol.NodoArbol nodo) {
        if (nodo == null) return;
        System.out.print(nodo.getValor() + " ");  // Visitamos el nodo actual
        for (Arbol.NodoArbol hijo : nodo.getHijos()) {
            preOrden(hijo);  // Recorremos los hijos
        }
    }

    public void enOrden(Arbol.NodoArbol nodo) {
        if (nodo == null) return;
        if (nodo.getHijos().size() > 0) enOrden(nodo.getHijos().get(0));  // Visitamos el primer hijo
        System.out.print(nodo.getValor() + " ");  // Visitamos el nodo actual
        for (int i = 1; i < nodo.getHijos().size(); i++) {  // Recorremos el resto de los hijos
            enOrden(nodo.getHijos().get(i));
        }
    }

    public void postOrden(Arbol.NodoArbol nodo) {
        if (nodo == null) return;
        for (Arbol.NodoArbol hijo : nodo.getHijos()) {
            postOrden(hijo);  // Recorremos los hijos primero
        }
        System.out.print(nodo.getValor() + " ");  // Visitamos el nodo actual
    }
}
