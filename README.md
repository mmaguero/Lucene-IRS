# Lucene-IRS
**[GIW-MII-UGR-2016-17]** *Desarrollo de un Sistema de Recuperación de Información con Lucene*

Para este trabajo se desarrolló un indexador sobre la colección documental de noticias en español de
la agencia EFE, publicadas en los años 19942, y un motor de búsqueda simple (búsquedas de
palabras) sobre una plataforma Web (que nos recuerda mucho al de Google). En ambos casos se
utilizaron los códigos base, proveídos en el guión del trabajo, solo que utilizando el
SpanishAnalyzer en vez del estándar, y los añadidos para manejar los documentos en formato
SGML.

## Indexador
La aplicación del indexador, emplea una clase Java, que recibe como argumentos la ruta de la
colección documental a indexar primeramente, además del archivo de palabras vacías a emplear y la
ruta donde alojar los índices a crear. Para llevar a cabo la indexación, se podrá ejecutarla desde la
línea de mandatos, creando los índices oportunos y archivos auxiliares necesarios para la
recuperación posterior.
Se utiliza además otra clase Java para la manipulación de los campos a indexar, en este caso los
correspondientes al título y el texto de las noticias.

## Motor de búsqueda
El motor de búsqueda, al ejecutarse recibe como argumento la ruta donde está alojado el índice de
la colección y a su vez permite al usuario realizar una consulta de texto simple, para obtener el
conjunto de documentos relevantes a dicha consulta, aplicando los mismos procesos que sobre los
documentos en el indexador.
Para este trabajo, se optó por utilizar las tecnologías provistas por Java EE (Servlet y Java Server
Pages o JSP) para montar el buscador en una plataforma Web minimalista utilizando BootStrap 4.
Básicamente se invoca una clase Java (origen) con la lógica en Lucene, desde un Servlet que actúa
de middleware, intercambiando objetos con páginas HTML5 (para la entrada de datos) y JSP (para
la interacción: entrada de datos y salida de coincidencias).

[Manual de usuario](/demo)
