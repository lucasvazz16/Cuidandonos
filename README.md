# Cuidandonos
## Alumnos: 
Lucas Vazquez - legajo 209.224-4

Camila Benitez - legajo 208.898-8

## Justificación de uso de patrones de diseño: 
Decidimos utilizar el patrón State debido a que en el dominio las acciones de reacción del transeúnte son múltiples sentencias condicionales que dependen de las opciones de él mismo, por ejemplo, si avisa que llegó bien o en caso de que no avise las opciones que configura en caso de que algo malo suceda. 
Por otro lado, cuando nos encontramos con la utilización de la API Distance Matrix, aprovechamos que sabíamos cuál iba a ser exactamente su responsabilidad y como no era parte de la entrega integrarla, decidimos hacer uso del patrón Adapter para crear una interfaz que encapsule la utilización de las funciones a utilizar de la API.
