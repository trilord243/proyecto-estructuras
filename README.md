## #SVEFE

SVEFE es un software de centro de manejo de usuario y de relaciones en donde uno puede modificar y visualizar las relaciones que tiene los usuarios con sus respectivas relaciones que tienen mediante el manejo de grafos.

## Como funciona?

---

Primero se clona el repositorio de githuby se abre en el IDE de [Netbeans](https://netbeans.apache.org/ "Netbeans").

**Nota**: Si sale un error de compatiblidad de JDK haga click al boton de ResolveProblems y esoja el JDK por defecto (Para este proyecto se uso el JDK 17)

[!Error](./images/error.png)

Una vez clonado el repositorio haga click en el boton RUN en la aplicacion main.
[!boton](./images/boton.png)

Luego saldra una ventana con esta pantalla

![pantalla1](./images/Untitled.png)

Le va a dar click en el boton de Subir archivo txt.

**Nota**: Tiene que ser un archivo de formato .txt y ademas debe seguir este formato.
**Ejemplo:**

##### Archivo de texto

Usuarios
121, @Pepe_Gónzales
254, @StephaniaCominos
365, @AndreaStanislao
412, @Josefina_La_Sifrina
512, @RosaMosa
231, @EduardoPetardo
123, @EnriqueManrique
129, @casanova23
870, @venepositivo
758, @yosoylatorre
578, @pitiypo
909, @obiwan123
893, @caribu_sol
467, @trapos232
788, @bandido121
239, @justiciero11
443, @fuerza_bruta
907, @Presentesiempre
Relaciones
121, 254, 7
121, 909, 8
254,909,5
909, 893, 5
254, 893, 1
893, 129, 3
129, 512, 10
512, 412, 2
893, 412, 4
231, 870, 5
231, 123, 1
123, 870, 15
123, 467, 6
788, 239, 7
788, 443, 11
239, 443, 6
239, 907, 3
443, 907, 9
788, 412, 7
870, 578, 7
870, 758, 1
758, 365, 9
578, 365, 4

Una vez suba el archivo le saldra la pantalla principal donde tendra diferentes opciones para manejar su archivo.

##### Agregar usuario

[!AddUser](./images/AgregarUsuario.png)

Esta opcion permite agregar usuario al archivo, primero tendra que ingresar el id del usuario (Tiene que ser un numero entero) y luego el nombre del usuario.

##### Agregar Relacion

[!AddRelation](./images/Relacion.png)

Esta opcion permite crear una nueva relacion de 2 usuarios, primero tiene que ingresar el id de un usuario, luego el id del otro usuario e indicar el tiempo de amistad que tienen

##### Mostrar Usuario

[!ShowUser](./images/Mostar.png)

Esta opcion permite visualizar todos los usuarios que hay en el archivo.

##### Contar Islas

[!Islas](./images/islas.png)

Esta opcion cuenta las islas que se encuentran en el archivo y tiene 2 opciones de como contarlas. Ya sea por el algoritmo DFS (Depth First Search) o por BFS (breadth-first search).

##### Encontrar puentes

[!puentes](./images/puentes.png)

Esta opcion permite encontrar la cantidad de puentes que hay en el archivo

##### Mostrar Grafo

[!graph](./images/grafico.png)

Esta opcion permite mostrar visualmente el grafo que existe en el archivo. Con sus usuarios y relaciones

##### Guardar Cambios

[!save](./images/save.png)

Esta opcion guarda todos los cambios que se hiceron el el archivo
