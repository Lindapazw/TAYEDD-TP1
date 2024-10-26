public class RecorridoArbol {
    public void preOrden(Arbol.NodoArbol nodo) {
        if (nodo == null) return;
        System.out.print(nodo.getValor() + " ");
        for (Arbol.NodoArbol hijo : nodo.getHijos()) {
            preOrden(hijo);
        }
    }

    public void enOrden(Arbol.NodoArbol nodo) {
        if (nodo == null) return;
        if (nodo.getHijos().size() > 0) enOrden(nodo.getHijos().get(0));
        System.out.print(nodo.getValor() + " ");
        for (int i = 1; i < nodo.getHijos().size(); i++) {
            enOrden(nodo.getHijos().get(i));
        }
    }

    public void postOrden(Arbol.NodoArbol nodo) {
        if (nodo == null) return;
        for (Arbol.NodoArbol hijo : nodo.getHijos()) {
            postOrden(hijo);
        }
        System.out.print(nodo.getValor() + " ");
    }
}
