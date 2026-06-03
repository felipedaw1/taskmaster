# Informe de errores detectados y mejoras aplicadas

## 1. Introducción
Durante la fase de pruebas y refactorización del proyecto TaskMaster se han detectado varios errores y aspectos mejorables en la lógica de negocio, la validación de datos y la organización del código. En este documento se recogen los principales problemas encontrados y las soluciones aplicadas.

## 2. Errores detectados

### 2.1 Validación insuficiente de fechas
Se detectó que era posible crear tareas con una fecha límite anterior a la fecha de creación.

**Corrección aplicada:**  
Se añadió una validación específica en la clase `Validador` para comprobar que la fecha límite no sea anterior a la fecha de creación.

---

### 2.2 Falta de control de campos vacíos
En algunos formularios y entradas por consola se aceptaban valores vacíos o nulos.

**Corrección aplicada:**  
Se implementó el método `validarTextoNoVacio()` para evitar la entrada de textos vacíos en campos obligatorios.

---

### 2.3 Duplicados en entidades
Se detectó que era posible crear entidades con identificadores repetidos.

**Corrección aplicada:**  
Se modificaron los gestores (`GestorUsuarios`, `GestorCategorias`, `GestorTareas`) para comprobar si ya existe un registro con el mismo ID antes de insertar un nuevo elemento.

---

### 2.4 Lógica de menú demasiado extensa
La clase `MenuConsola` concentraba demasiadas responsabilidades, lo que dificultaba la lectura y el mantenimiento.

**Corrección aplicada:**  
Se creó la clase `EntradaConsola` para centralizar la lectura de datos y se separaron varias operaciones en métodos más pequeños.

---

### 2.5 Mensajes poco claros al usuario
Algunas acciones no mostraban mensajes suficientemente descriptivos.

**Corrección aplicada:**  
Se revisaron los mensajes del sistema para ofrecer información más clara sobre errores, búsquedas fallidas y operaciones correctas.

## 3. Mejoras aplicadas

### 3.1 Refactorización del código
Se reorganizó parte del código para reducir la complejidad técnica y mejorar la legibilidad.

### 3.2 Separación de responsabilidades
Cada clase tiene ahora una función más clara:
- `Validador`: validaciones
- `EntradaConsola`: lectura por teclado
- `DatosIniciales`: carga de datos de prueba
- gestores: lógica de negocio

### 3.3 Pruebas unitarias
Se añadieron pruebas con JUnit 5 para comprobar el correcto funcionamiento de:
- validaciones
- creación de usuarios
- creación y búsqueda de tareas
- eliminación de tareas
- creación de categorías y estados

### 3.4 Documentación técnica
Se añadió Javadoc en clases y métodos públicos principales para facilitar el mantenimiento del proyecto.

## 4. Conclusión
Las pruebas realizadas han permitido localizar errores funcionales y de diseño, corrigiéndolos mediante validaciones, refactorización y documentación. El resultado es una aplicación más robusta, legible y fácil de mantener.

## 5. Evidencias
Las correcciones y mejoras se han aplicado sobre el código fuente del proyecto y se acompañan de pruebas unitarias y documentación técnica.