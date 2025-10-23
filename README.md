# Proyecto_nodo_matriz_multiencadenada

Este proyecto implementa una matriz cuadrada utilizando una estructura de nodos multienlazados, donde cada celda está representada por un nodo que se enlaza con los nodos adyacentes superior, inferior, izquierdo y derecho. La matriz permite operaciones como impresión visual con flechas, diagonales, y triángulos superior/inferior.

## 🧠 ¿Qué es una matriz multiencadenada?

Es una estructura de datos donde cada nodo representa una celda de la matriz y contiene punteros a sus vecinos. Esto permite recorrer la matriz sin usar índices, solo con referencias entre nodos. Es útil para representar estructuras dispersas o para practicar enlaces bidimensionales.

## ✨ Funcionalidades principales

- Crear una matriz cuadrada de tamaño `n x n` con valores aleatorios entre un mínimo y un máximo.
- Imprimir la matriz con flechas que indican los enlaces entre nodos.
- Mostrar:
  - Diagonal principal
  - Diagonal secundaria
  - Triángulo inferior
  - Triángulo superior
- Interfaz gráfica moderna con botones y colores personalizados (Swing).

## 🖥️ Interfaz gráfica

El proyecto incluye una interfaz visual desarrollada con Java Swing que permite:

- Ingresar el tamaño y rango de valores de la matriz.
- Crear la matriz con un solo clic.
- Visualizar la matriz y sus secciones con botones interactivos.
- Ver los resultados en un área de texto estilizada.

## 📁 Estructura del proyecto

matriz-multiencadenada:
-  src/
- NodoM.java: Clase del nodo multienlazado
- Main.java: Menú por consola (modo texto)
- Interfaz.java: Interfaz gráfica 

## ▶️ Cómo ejecutar

1. Clona el repositorio:
   ```bash
   git clone https://github.com/Warzerp/Proyecto_nodo_matriz_multiencadenada.git

2. Abre el proyecto en tu IDE favorito (Eclipse, IntelliJ, NetBeans)

3. Ejecuta Interfaz.java para usar la interfaz gráfica
   
5. También puedes ejecutar Main.java para usar la versión por consola

   👥 Colaboradores
Warzerp – Lógica, estructura de nodos, interfaz gráfica, documentación

Natalia20041 – Diseño visual de la interfaz, estilo y experiencia de usuario

