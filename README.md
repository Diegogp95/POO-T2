## Reseña del programa----------------------------------------------------------------------------------------------------------------------------

El programa Stage4 simula un sistema domotica, el cual consiste en 2 cortinas, 2 lampara, un control de cortina y un control de lampara.
En el caso de la cortina, esta se manipula mediante su control con los comandos de "up", "down" y "stop", que estara asociado a un canal
el cual puede ser modificado. En el caso de la lampara, esta tendra un control con un canal propio el cual tambien puede ser modificado 
y tiene un boton para enceder y apagar la lampara, además de sliders los cuales modifican la intensidad de cada color de la luz de la 
lampara. La salida de este progarama sera una interfaz grafica desde la cual se puede ver el estado actual de los objetos y manipular las
funciones mencionadas mediante los botones.

## Errores de compilacion-------------------------------------------------------------------------------------------------------------------------

Al momento de ejecutar cada una de las Stage en Aragon aparece un error, este no interfiere con la ejecucion del programa y solo aparece al 
ejecutarlo en Aragon, al ejecutar en windows no da errores.

	#Error en Aragon:
	libGL error: unable to load driver: swrast_dri.so
	libGL error: failed to load driver: swrast
	Prism-ES2 Error : GL_VERSION (major.minor) = 1.4

Al ejecutar la Stage4 en Aragon ocurre un desperfecto en la ejecucion del programa, en este no se cargan los videos. Este desperfecto no entrega
informacion por consola por lo cual no es posible adjuntar mas detalles.

## Condiciones de compilacion y ejecucion---------------------------------------------------------------------------------------------------------

    Se utiliza: java 11 SDK y JavaFX 18 SDK

## Las instrucciones de compilacion y ejecucion---------------------------------------------------------------------------------------------------

	#Cada etapa viene con una libreria de JavaFX para liux por lo que para utilizar el programa basta con utilizar los comandos:

    	make 						/* para compilar, se debe utilizar en la carpeta que tiene el makefile*/    
   	make run					/* para ejecutar el programa*/
    	make clean					/* para limpiar los archivos .class*/

	#En caso de querer utilizar una libreria diferente de JavaFX se pueden utilizar los comandos descritos a continuacion:

    	make JavaFX="/path/to/javafx/lib" 		/* para compilar, se debe utilizar en la carpeta que tiene el makefile*/    
    	make JavaFX="/path/to/javafx/lib" run		/* para ejecutar el programa*/
    	make JavaFX="/path/to/javafx/lib" clean		/* para limpiar los archivos .class*/


## Lista de archivos utilizados en el funcionamiento del programa---------------------------------------------------------------------------------

	#Archivo que compilara, ejecutara y limpiara MakeFile

	#Archivos java de las clases
	Stage4.java 
	ShadeControlView.java
	ShadeControl.java
	RollerShadeView.java
	RollerShade.java
	LampView.java
	LampControlView.java
	LampControl.java
	Lamp.java
	DomoticDeviceControl.java
	DomoticDevice.java
	Cloud.java

	#Carpeta rsc con imagenes y videos
	Background.jpg
	powerIcon.png
	video1.mp4
	video2.mp4

	#Carpeta javafx-sdk-18.0.1 con la libreria de JavaFX para linux x64 SDK