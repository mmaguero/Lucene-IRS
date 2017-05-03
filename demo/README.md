# Manual de usuario
## Indexador
Para llevar a cabo la indexaci�n de documentos, se debe ejecutar la clase Index desde el IDE o un
.jar generado a partir del mismo. Los argumentos de ejecuci�n se encuentran dentro del c�digo, las
rutas relativas a directorios y archivos b�sicamente, es por ello que para cambiar alg�n dato habr�a
que recompilarlo. Las rutas son las siguientes:
- WebContent/data/indexes/ -> directorio de �ndices
- WebContent/data/efe -> colecci�n documental
- WebContent/data/palabras_vacias_utf8.txt ?-> palabras vac�as en espa�ol

Para ejecutar el .jar se debe ejecutar:
�java -jar nombreIndiceJar.jar�

No se incluy� la escritura de logs del proceso (por los costos de ejecuci�n que esto acarrea), pero si
emite en pantalla un estado del proceso m�nimo, a manera de no ralentizar el mismo, con el tiempo
total empleado para el proceso.

!(00)[https://github.com/mmaguero/Lucene-IRS/blob/master/img/00.PNG]

## Motor de B�squeda
Para lanzar el motor de b�squeda hay que desplegar la aplicaci�n Web que ejecutar� la interfaz del
usuario con el motor de b�squeda en un servidor Apache Tomcat (ideal, versi�n 9 o superior), o a
trav�s del proyecto con un IDE como Eclipse, previamente configurado dicho servidor. Cabe
destacar, que para desplegar un .war se debe copiarlo en la carpeta webapps del directorio de
instalaci�n de Tomcat.

El motor usa las mismas rutas que el indexador, que para cambiar la ruta habr�a que recompilarlo
tambi�n. Es decir, que los indices creados en la carpeta WebContent (data/indexes), junto con el
archivo de palabras vac�as (data/palabras_vacias_utf8.txt) en el paso anterior, debe ser copiado
enteramente a la misma altura que los archivos HTML o JSP en la carpeta LuceneIRS creada al
desplegar el .war.

Una vez desplegado, se puede acceder desde el navegador a la siguiente direcci�n:
http://dominio:8080/LuceneIRS/Home.html

!(01)[https://github.com/mmaguero/Lucene-IRS/blob/master/img/01.png]

Cada consulta se toma desde los �ndices creados, para ello hay que ingresar el texto a buscar y los
resultados se desplegar�n en una pantalla nueva, con el n�mero de resultados y el tiempo
aproximado que ha tardado en encontrarlos.

!(02)[https://github.com/mmaguero/Lucene-IRS/blob/master/img/02.png]

Ya dentro de la pantalla de resultados, cuando se haga clic sobre el t�tulo de cualquiera de los
resultados, se desplegar� una pantalla modal con el texto completo del elemento.

!(03)[https://github.com/mmaguero/Lucene-IRS/blob/master/img/03.png]