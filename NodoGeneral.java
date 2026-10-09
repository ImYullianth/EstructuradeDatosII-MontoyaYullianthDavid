import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Nodo general para construir estructuras jerarquicas.
 * Cada nodo almacena un dato y una lista de hijos.
 *
 * @param <T> tipo de dato almacenado en el nodo.
 */
public class NodoGeneral<T> {

    private final T dato;
    private final List<NodoGeneral<T>> hijos;

    public NodoGeneral(T dato) {
        this.dato = dato;
        this.hijos = new ArrayList<>();
    }

    /** Agrega un nuevo hijo al nodo actual. */
    public void agregarHijo(NodoGeneral<T> hijo) {
        if (hijo == null) {
            throw new IllegalArgumentException("El nodo hijo no puede ser null.");
        }
        hijos.add(hijo);
    }

    public T getDato() {
        return dato;
    }

    /** Devuelve una vista de solo lectura de los hijos. */
    public List<NodoGeneral<T>> getHijos() {
        return Collections.unmodifiableList(hijos);
    }

    /** Indica si el nodo no tiene hijos. */
    public boolean esHoja() {
        return hijos.isEmpty();
    }

    /** Cuenta todos los nodos del subarbol (incluido este nodo). Recursivo. */
    public int contarNodos() {
        int total = 1;
        for (NodoGeneral<T> hijo : hijos) {
            total += hijo.contarNodos();
        }
        return total;
    }

    /** Altura del subarbol: una hoja tiene altura 1. Recursivo. */
    public int altura() {
        int maxHijos = 0;
        for (NodoGeneral<T> hijo : hijos) {
            maxHijos = Math.max(maxHijos, hijo.altura());
        }
        return 1 + maxHijos;
    }

    /** Cuenta las hojas del subarbol. Recursivo. */
    public int contarHojas() {
        if (esHoja()) {
            return 1;
        }
        int total = 0;
        for (NodoGeneral<T> hijo : hijos) {
            total += hijo.contarHojas();
        }
        return total;
    }
}