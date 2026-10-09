import java.util.ArrayList;
import java.util.List;

/**
 * Guia 1 - De lo lineal a lo jerarquico.
 * Escenario modelado: organigrama empresarial.
 */
public class Main {

    public static void main(String[] args) {

        // 1. Raiz
        NodoGeneral<String> empresa = new NodoGeneral<>("Empresa");

        // 2. Segundo nivel
        NodoGeneral<String> tecnologia = new NodoGeneral<>("Tecnologia");
        NodoGeneral<String> finanzas = new NodoGeneral<>("Finanzas");
        NodoGeneral<String> recursosHumanos = new NodoGeneral<>("Recursos Humanos");

        empresa.agregarHijo(tecnologia);
        empresa.agregarHijo(finanzas);
        empresa.agregarHijo(recursosHumanos);

        // 3. Tercer nivel
        NodoGeneral<String> desarrollo = new NodoGeneral<>("Desarrollo");
        NodoGeneral<String> infraestructura = new NodoGeneral<>("Infraestructura");
        NodoGeneral<String> contabilidad = new NodoGeneral<>("Contabilidad");
        NodoGeneral<String> tesoreria = new NodoGeneral<>("Tesoreria");
        NodoGeneral<String> seleccion = new NodoGeneral<>("Seleccion");
        NodoGeneral<String> bienestar = new NodoGeneral<>("Bienestar");

        tecnologia.agregarHijo(desarrollo);
        tecnologia.agregarHijo(infraestructura);
        finanzas.agregarHijo(contabilidad);
        finanzas.agregarHijo(tesoreria);
        recursosHumanos.agregarHijo(seleccion);
        recursosHumanos.agregarHijo(bienestar);

        // 4. Cuarto nivel
        NodoGeneral<String> backend = new NodoGeneral<>("Backend");
        NodoGeneral<String> frontend = new NodoGeneral<>("Frontend");

        desarrollo.agregarHijo(backend);
        desarrollo.agregarHijo(frontend);

        // 5. Datos basicos
        System.out.println("Raiz: " + empresa.getDato());
        System.out.println();

        // 6. Jerarquia completa (recorrido recursivo)
        System.out.println("=== JERARQUIA COMPLETA ===");
        mostrarArbol(empresa);

        // 7. Consultas
        System.out.println();
        System.out.println("Tecnologia es hoja? " + tecnologia.esHoja());
        System.out.println("Backend es hoja? " + backend.esHoja());
        System.out.println("Cantidad de hijos directos de Empresa: "
                + empresa.getHijos().size());
        System.out.println("Total de nodos: " + empresa.contarNodos());
        System.out.println("Altura del arbol (niveles): " + empresa.altura());
        System.out.println("Cantidad de hojas: " + empresa.contarHojas());

        // 8. Comparacion con una estructura lineal
        System.out.println();
        System.out.println("=== VERSION LINEAL (lista) ===");
        List<String> lista = new ArrayList<>();
        aplanar(empresa, lista);
        System.out.println(lista);
        System.out.println("En la lista no se ve que Backend pertenece a Desarrollo,"
                + " ni que este pertenece a Tecnologia.");
    }

    /**
     * Muestra el arbol con sangria. Cada nodo (menos la raiz) se numera de
     * forma consecutiva: Hija 1, Hija 2, Hija 3... (recorrido en preorden).
     */
    public static void mostrarArbol(NodoGeneral<?> raiz) {
        System.out.println(raiz.getDato() + " (raiz)");
        int[] contador = {0};
        mostrarHijas(raiz, 1, contador);
    }

    private static void mostrarHijas(NodoGeneral<?> padre, int nivel, int[] contador) {
        String sangria = "   ".repeat(nivel);
        for (NodoGeneral<?> hija : padre.getHijos()) {
            contador[0]++;
            System.out.println(sangria + "Hija " + contador[0] + ": "
                    + hija.getDato() + "  (hija de " + padre.getDato() + ")");
            mostrarHijas(hija, nivel + 1, contador);
        }
    }

    /** Recorre el arbol y guarda los datos en una lista plana (preorden). */
    public static void aplanar(NodoGeneral<String> nodo, List<String> destino) {
        destino.add(nodo.getDato());
        for (NodoGeneral<String> hijo : nodo.getHijos()) {
            aplanar(hijo, destino);
        }
    }
}