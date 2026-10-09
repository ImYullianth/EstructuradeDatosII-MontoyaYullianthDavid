# Guía 1 – De lo lineal a lo jerárquico

**Asignatura:** Estructura de Datos II  
**Programas:** Ingeniería de Software – Ingeniería de Sistemas · Semestre IV

## Objetivo

Reconocer la necesidad de las estructuras de datos no lineales y representar un problema real mediante una estructura jerárquica.

## Clasificación de los cuatro escenarios

| # | Escenario | ¿Lineal o jerárquico? | Justificación |
|---|-----------|-----------------------|---------------|
| 1 | Sistema de archivos | **Jerárquico** | Una carpeta contiene archivos y otras carpetas; cada elemento tiene una única carpeta padre y una ruta única desde la raíz. |
| 2 | Organigrama empresarial | **Jerárquico** | Hay una raíz (la empresa) y cada área depende de una sola unidad superior. **(Modelado en Draw.io y Java)** |
| 3 | Menú de una aplicación | **Jerárquico** | Un menú contiene submenús y opciones, con varios niveles de profundidad. Solo sería lineal si fuera una única barra sin submenús. |
| 4 | Árbol genealógico | **Jerárquico (con matices)** | Representa generaciones y relaciones padre-hijo. Como cada persona tiene dos progenitores y existen uniones entre familias, en rigor se acerca a un grafo; se modela como árbol si se toma una sola línea (ascendencia o descendencia). |

**Conclusión:** una estructura lineal (lista, arreglo) solo puede guardar los elementos de forma plana: sirve para listar, pero pierde la relación de dependencia. Los cuatro casos requieren una estructura jerárquica para expresar quién pertenece a quién.

## Escenario elegido para Draw.io

Se modeló el **organigrama empresarial** (12 nodos, 4 niveles):

```text
Empresa
├── Tecnología
│   ├── Desarrollo
│   │   ├── Backend
│   │   └── Frontend
│   └── Infraestructura
├── Finanzas
│   ├── Contabilidad
│   └── Tesorería
└── Recursos Humanos
    ├── Selección
    └── Bienestar
```

## Estructura del proyecto

```text
EstructuraDatosII-Apellido/
├── NodoGeneral.java
├── Main.java
├── Jerarquia_Empresa.drawio   (agregar el archivo del diagrama)
├── Jerarquia_Empresa.pdf      (opcional: exportación del diagrama)
├── Explicacion_Guia1.pdf
├── salida_esperada.txt
├── .vscode/
└── README.md
```

## Compilación y ejecución

Desde la terminal, dentro de esta carpeta:

```bash
javac -encoding UTF-8 NodoGeneral.java Main.java
java -Dfile.encoding=UTF-8 -Dstdout.encoding=UTF-8 Main
```

## Qué demuestra el código

1. `NodoGeneral<T>` es una clase genérica.
2. Cada nodo almacena un dato y una lista de hijos.
3. `agregarHijo()` crea la relación padre-hijo.
4. `mostrarArbol()` recorre la jerarquía mediante recursividad.
5. `esHoja()`, `contarNodos()`, `altura()` y `contarHojas()` consultan la estructura.
6. `aplanar()` convierte el árbol en una lista y muestra qué información se pierde en la versión lineal.

## Reflexión

Al analizar los cuatro casos noté que una estructura lineal sirve para guardar elementos uno tras otro, pero no para expresar quién depende de quién. Una lista de departamentos me dice qué áreas existen, aunque no que Backend pertenece a Desarrollo y este a Tecnología. En el sistema de archivos, el menú y el organigrama ocurre lo mismo: cada elemento tiene un único superior y puede contener otros elementos, por eso un árbol los modela de forma natural. El árbol genealógico fue el caso más interesante, porque cada persona tiene dos progenitores y las uniones familiares generan cruces; es una jerarquía, pero con matices que la acercan a un grafo. Elegí el organigrama porque su raíz y sus niveles son claros. En Java lo implementé con NodoGeneral<T>, que guarda un dato y una lista de hijos, con métodos recursivos para recorrerlo, contarlo y medir su altura. Aprendí que la recursividad es la herramienta natural para procesar jerarquías y que elegir bien la estructura simplifica el código.
