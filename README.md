Integrantes del grupo:
	Delli Carpini, Agustin.
	Forti, Franco.
	Mondin, Leandro.
	Rolando, Rodrigo.

Decisiones de diseño:
	
	Decidimos tener tres clases principales para nuestro desarrollo. La primera es la clase ‘App’ con la cual hacemos nuestra ‘interfaz  de usuario’ en la consola de eclipse, la segunda es la clase ‘Tablero’ que utilizamos
	para guardar y actualizar los estados y movimientos del jugador, y nuestra tercer clase fue la clase abstracta ‘Casillero’ la cual utilizamos como clase padre para las provisiones, el Pac, las minas y las paredes.
	Para las provisiones usamos un esquema ‘Composite’ para poder tener las vitaminas, los escudos y mas provisiones dentro de un mismo grupo que respondan a las mismas características y métodos.
	Por ultimo también empleamos una clase adaptador (TransformarPosicion) para poder devolver las filas y columnas de una posición por separado.


Descripcion de cada archivo:
	
	App.java: Carga los archivos de configuración, inicializa el tablero y lo muestra en consola junto con toda las interfaz de usuario pensada para este trabajo práctico.

	Tablero.java: 	Cuenta con una matriz de tipo ‘Casillero’ en la cual se van a colocar las minas, paredes, provisiones, salida y Pac. Su constructor le da dimensiones al tablero y crea todos sus casilleros del tipo ‘Vacio’. 
			Cuenta con un método ‘mostrarEnConsola’ que es llamado por la clase ‘App’ para mostrar el tablero por consola, luego tiene métodos para la creación de los objetos dentro del tablero, para el movimiento del jugador
			y métodos de control para saber si hay ganador o perdedor. Dentro, también cuenta con un método para actualizar el estado del jugador (quitar y sumar vidas o escudos).

	Casillero.java:  Es una clase abstracta con tres simples metodos: 'efectuarSobre', 'sePuedeAtravesar', 'toString'. El metodo 'efectuarSobre' sirve para la actualización de estados, 'sePuedeAtravesar' lo usamos para preguntar si
			 hay una pared.

	Consumible.java: Interfaz con un metodo que utilizamos para aplicar los cambios sobre el jugador.

	ConsumibleComposite.java: Lo usamos para un patron composite, este es una provision que contiene una lista de provisiones.

	VidaExtra.java: Extiende de 'Provision' e invoca el metodo 'sumarVida' del jugador.

	EscudoDeFuerza.java: Extiende de 'Provision' e invoca el metodo 'sumarEscudo' del jugador.

	Provision.java: Extiende de 'Casillero' e implementa 'Consumible'.

	Posicion.java: Objeto para 'materealizar' una posición en el tablero, cuenta con los métodos necesarios para saber que tiene a su alrededor.

	Pac.java: Extiende de 'Casillero'. Es un objeto para materializar al jugador, cuenta con los métodos necesarios para sumar y restar vida y escudo, para sus desplazamientos en el tablero y obtener sus estadisticas.

	Pared.java: Extiende de 'Casillero'. Dentro tiene un metodo 'sePuedeAtavesar' que devuelve un false, esto es para simbolizar una posición del tablero que no puede ser ocupado por el jugador.

	Mina.java: Extiende de 'Casillero'. Es un objeto para materializar una mina, tiene un método que invoca al método del Pac para restar vida o escudo.

	Salida.java: Extiende de 'Casillero'. Es un objeto para materializar la salida, tiene un metodo que devuelve que hay un ganador.

	Vacio.java: Extiende de 'Casillero'. Es un objeto para materializar un casillero vacio dentro del tablero.

	CargarConfiguracion.java: Busca el archivo de configuracion en la direccion espesificada para generar el tablero de juego.

	TransformarPosicion.java: Adaptador para pasar de una posicion de coordenadas a una posicion numerica del tablero.


Concluciones:
	Para finalizar y a modo de conclusión, podemos decir que este segundo trabajo práctico resulto mas facil que el primero. Creemos que esto se debe a lo aprendido en el proyecto de TierraMedia que nos ayudo a pautar los paso
	para la creación de un proyecto, empezando desde el debate de ideas, pasando por los diagramas para ordenar lo planeado, haciendo los test de funcionalidad mínimos y por ultimo desarrollar el código para nuestro juego. 
	Durante el camino hubo cambio de estructuras debido a las complejidades que no vimos en un principio, pero esto no nos significo mucho ya que al tener bien pensada la base, un pequeño cambio no era grave.