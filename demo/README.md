# Manual de usuario
## Indexador
Para llevar a cabo la indexación de documentos, se debe ejecutar la clase Index desde el IDE o un
.jar generado a partir del mismo. Los argumentos de ejecución se encuentran dentro del código, las
rutas relativas a directorios y archivos básicamente, es por ello que para cambiar algún dato habría
que recompilarlo. Las rutas son las siguientes:
- WebContent/data/indexes/ -> directorio de índices
- WebContent/data/efe -> colección documental
- WebContent/data/palabras_vacias_utf8.txt ?-> palabras vacías en español

Para ejecutar el .jar se debe ejecutar:
´java -jar nombreIndiceJar.jar´

No se incluyó la escritura de logs del proceso (por los costos de ejecución que esto acarrea), pero si
emite en pantalla un estado del proceso mínimo, a manera de no ralentizar el mismo, con el tiempo
total empleado para el proceso.

!(00)[https://github.com/mmaguero/Lucene-IRS/blob/master/img/00.PNG]

## Motor de Búsqueda
Para lanzar el motor de búsqueda hay que desplegar la aplicación Web que ejecutará la interfaz del
usuario con el motor de búsqueda en un servidor Apache Tomcat (ideal, versión 9 o superior), o a
través del proyecto con un IDE como Eclipse, previamente configurado dicho servidor. Cabe
destacar, que para desplegar un .war se debe copiarlo en la carpeta webapps del directorio de
instalación de Tomcat.

El motor usa las mismas rutas que el indexador, que para cambiar la ruta habría que recompilarlo
también. Es decir, que los indices creados en la carpeta WebContent (data/indexes), junto con el
archivo de palabras vacías (data/palabras_vacias_utf8.txt) en el paso anterior, debe ser copiado
enteramente a la misma altura que los archivos HTML o JSP en la carpeta LuceneIRS creada al
desplegar el .war.

Una vez desplegado, se puede acceder desde el navegador a la siguiente dirección:
http://dominio:8080/LuceneIRS/Home.html

!(01)[https://github.com/mmaguero/Lucene-IRS/blob/master/img/01.png]

Cada consulta se toma desde los índices creados, para ello hay que ingresar el texto a buscar y los
resultados se desplegarán en una pantalla nueva, con el número de resultados y el tiempo
aproximado que ha tardado en encontrarlos.

!(02)[https://github.com/mmaguero/Lucene-IRS/blob/master/img/02.png]

Ya dentro de la pantalla de resultados, cuando se haga clic sobre el título de cualquiera de los
resultados, se desplegará una pantalla modal con el texto completo del elemento.

!(03)[https://github.com/mmaguero/Lucene-IRS/blob/master/img/03.png]