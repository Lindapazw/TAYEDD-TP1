import java.util.ArrayList;
import java.util.List;

public class Arbol {
    public static class NodoArbol {
        private int valor;
        private List<NodoArbol> hijos = new ArrayList<>();

        public NodoArbol(int valor) {
            this.valor = valor;
        }

        public int getValor() {
            return valor;
        }

        public List<NodoArbol> getHijos() {
            return hijos;
        }
    }

    private NodoArbol raiz;

    public Arbol(int valorRaiz) {
        this.raiz = new NodoArbol(valorRaiz);
    }

    public NodoArbol getRaiz() {
        return raiz;
    }

    public NodoArbol agregarHijo(NodoArbol padre, int valor) {
        NodoArbol hijo = new NodoArbol(valor);
        padre.getHijos().add(hijo);
        return hijo;
    }
}
