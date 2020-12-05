# Calculadora

Microservicio "calculadora", usando maven + spring-boot

Microservicio por el cual de unos parámetros de entrada realiza operaciones aritmeticas.
En esta versión solamente ser realizan las operaciones de suma y resta.

- Para crear el proyecto se ha optado por realizando implementando servicios post. Nos ha parecido más comodo invocar el servicio utilizando POST y pasando los parámetros en el body en lugar de en la url. Por otro lado la url se ve más limpia.
- Como podría crecer y solicitarse añadir nuevas funciones se ha creado una abstracta para indicar la operación. De forma que cada operación se genere teniendo en cuenta esta clase.
- Se ha implementado la interface runnable en cada operación, con lo que nos permitirá crear un hilo por cada solicitud de operación a realizar.
- Se han implementado test para la suma y la resta muy básicos.

# Endpoint
El endpoint es:
http://localhost:8080/api/calculator

Enpoint para suma: http://localhost:8080/api/calculator/add

resta: http://localhost:8080/api/calculator/substract

# Generar Jar ejecutable
- Abrir consola con.
- Ir a la ruta del proyecto, donde esté nuestro archivo pom.xml
- Aseguramos que tenemos maven en el path. (Si no es así hay que añadirlo o redireccionar a la ruta)
    mvn clean install
  
Con esto creamos en la carpeta target un archivo .jar ejecutable con el proyecto.
