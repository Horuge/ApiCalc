# Calculadora

Microservicio "calculadora", usando maven + spring-boot

Microservicio por el cual de unos parámetros de entrada realiza operaciones aritmeticas.
En esta versión solamente ser realizan las operaciones de suma y resta.

- Para crear el proyecto se ha optado por realizando implementando servicios post. Nos ha parecido más comodo invocar el servicio utilizando POST y pasando los parámetros en el body en lugar de en la url. Por otro lado la url se ve más limpia.
- Como podría crecer y solicitarse añadir nuevas funciones se ha creado una abstracta para indicar la operación. De forma que cada operación se genere teniendo en cuenta esta clase.
- Se ha implementado la interface runnable en cada operación, con lo que nos permitirá crear un hilo por cada solicitud de operación a realizar.
- Se han implementado test para la suma y la resta muy básicos.

Para realizar el proyecto es ha sido necesario añadir los jar proporcionados para generar trazas. Los jar se han añadido al repositorio local para acceder a ellos desde el archivo pom.xml.
> mvn deploy:deploy-file -DgroupId=com.logger.tracer -DartifactId=tracer -Dversion=1.0.0 -Dfile=D:\workspace\tracer-1.0.0.jar -Dsources=D:\workspace\tracer-1.0.0-sources.jar -Djavadoc=D:\workspace\tracer-1.0.0-javadoc.jar -Durl=file:C:\Users\Jorge\.m2\repository

En el pom.xml se ha añadido:
    <dependency>
        <groupId>com.logger.tracer</groupId>
        <artifactId>tracer</artifactId>
        <version>1.0.0</version>
    </dependency>


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
