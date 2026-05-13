# Coderbyte Challenge: CheckDOM (Java) - Odoo Technical Assessment

Este repositorio contiene mi solución al reto técnico de programación de **Coderbyte**, realizado como parte del proceso de selección para la posición de **Software Developer** en [Odoo](https://www.odoo.com/es_ES/jobs/software-developer-1).

##  Descripción del Reto

El objetivo es implementar una función `CheckDOM(strParam)` que analice una cadena de texto que contiene etiquetas HTML (`<b>`, `<i>`, `<em>`, `<div>`, `<p>`) y texto plano. El programa debe validar el correcto anidamiento de los elementos basándose en tres casos:

1.  **Resultado `true`**: Si todos los elementos están correctamente abiertos y cerrados siguiendo el orden LIFO (Last-In, First-Out).
2.  **Resultado [Nombre de Etiqueta]**: Si al cambiar una **única** etiqueta de apertura el String se vuelve correcto, el programa debe devolver el nombre de dicha etiqueta (ej. `div`, `b`, etc.).
3.  **Resultado `false`**: Si la cadena es incorrecta y requiere cambiar más de un elemento para ser válida.

### Ejemplo de funcionamiento:
- **Entrada:** `<div><b><p>hello world</p></b></div>` → **Salida:** `true`
- **Entrada:** `<div><i>hello</i>world</b>` → **Salida:** `div` (Cambiando `div` por `b` se corrige).
- **Entrada:** `<div><p></b></em>` → **Salida:** `false`

##  Mi Solución

Para este reto, opté por una implementación eficiente utilizando una **estructura de datos de Pila (Stack)** gestionada manualmente mediante un array de Strings y un puntero de control (`top`).

### Lógica aplicada:
1.  **Preprocesamiento del String**: Se limpian los posibles caracteres de comillas y se insertan espacios estratégicos alrededor de los caracteres `<` y `>` para asegurar un troceado (`split`) limpio de las etiquetas, incluso si están pegadas en el input original.
2.  **Gestión de Etiquetas**:
    *   Al encontrar una **etiqueta de apertura**, se almacena en la pila e incrementamos el puntero.
    *   Al encontrar una **etiqueta de cierre**, comprobamos si coincide con la última etiqueta abierta (cima de la pila).
3.  **Detección de Errores**:
    *   Si hay un desajuste entre apertura y cierre, devolvemos inmediatamente la etiqueta de la cima de la pila como la responsable del error.
    *   Si al finalizar el recorrido la pila no está vacía, devolvemos la primera etiqueta que quedó sin cerrar.
4.  **Simplicidad y Rendimiento**: Se evitó el uso de librerías externas complejas para mantener el código ligero y fácil de leer, cumpliendo con los estándares de evaluación de Odoo.

### Pruebas unitarias JUNIT

En la ruta **test/java/demo** se encuentran las pruebas unitarias cuyos inputs utilicé para realizar la comprobación del código en **CoderByte**, verificando que la realización del código (pese a no ser óptima), era aparentemente funcional.

