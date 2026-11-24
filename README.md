# Caso Práctico 1: Servidor y Cliente Eco (TCP)

Aplicación cliente-servidor en Java utilizando sockets TCP (`ServerSocket` y `Socket`) para la comunicación en red.

## Funcionamiento
* **ServidorEco:** Escucha de forma continua en el puerto `5001`. Cuando un cliente se conecta, recibe sus mensajes de texto, los convierte a mayúsculas y se los devuelve hasta que el cliente envía `"FIN"`. Después, queda a la espera de un nuevo cliente.
* **ClienteEco:** Se conecta a `localhost:5001`, lee líneas escritas por teclado, las envía al servidor y muestra la respuesta en pantalla hasta que el usuario introduce `"FIN"`.

## Estructura del proyecto
* `ServidorEco.java`: Proceso servidor TCP.
* `ClienteEco.java`: Proceso cliente TCP.

## Ejecución
1. Compilar ambos archivos:
   ```bash
   javac ServidorEco.java ClienteEco.java