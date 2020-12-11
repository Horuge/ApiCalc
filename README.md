# Calculadora

Microservicio "calculadora", usando maven + spring-boot

Microservicio por el cual de unos parámetros de entrada realiza operaciones aritmeticas.
En esta versión solamente ser realizan las operaciones de suma y resta.

- Se ha reformado el servicio para funcionar con un solo servicio en donde en la ruta del servicio se indica el tipo de operación a realizar. Este servicio se ha creado como GET y a causa de este se ha modificado el anterior, se ha pasado a GET. No tenía mucho sentido, y es erroneo mantenerlo como un POST, ya que el servicio que se debe utilizar para solicitar un dato es GET, POST queda para la realización de operaciones. Me planteé tener los dos, uno POST y otro GET pero en realidad creo que lo correcto es que se realice con un GET. Por esto se ha aprovechado la creación del servicio para separar capas para convertir el POST en GET. Hemos mantenido el servicio anterior en el que se le pasan los operadores en el body.
- Como podría crecer y solicitarse añadir nuevas funciones se ha creado una abstracta para indicar la operación. De forma que cada operación se genere teniendo en cuenta esta clase.
- Se ha implementado la interface runnable en cada operación, con lo que nos permitirá crear un hilo por cada solicitud de operación a realizar.
- Se han implementado test para la suma y la resta muy básicos.
- He tenido problemas al inyectar la librería Tracer con @Autowire. Que es la forma en la que creo se debe incluir. Pero creo, por lo que he podido ver en la web, que ha sido por culpa de una mala configuración de Intellij Idea, IDE que he utilizado para realizar la prueba (queria utilizar esta aplicación y me ha parecido una oportunidad para probarla). Debería de funcionar con @Autowire, de todas formas también probé a realizar una clase desde TracerAPI que se alojara en el proyecto pero el problema no desaparecía. Así que para que funcione el proyecto se está utilizando new. Por esta razón, creo también, en mi local las pruebas no se ejecutan correctamente.

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
http://localhost:8080/api/calculator/{operacion}/ope?ope1={ope1}&ope2={ope2}

donde:

{operacion} = suma|resta

{ope1}= número 1 a aplicar la operación

{ope2}= número 2 a aplicar la operación

Ejemplo: http://localhost:8080/api/calculator/suma/ope?ope1=1&ope2=2



# Generar Jar ejecutable
- Abrir consola con en la búsqueda de windows escribiendo 'cmd' o buscando 'simbolo del sistema'.
- Ir a la ruta del proyecto, donde esté nuestro archivo pom.xml
- Aseguramos que tenemos maven en el path. (Si no es así hay que añadirlo o redireccionar a la ruta)
    mvn clean install
  
- Con esto creamos en la carpeta target un archivo .jar ejecutable con el proyecto.

# Ejecutar en Eclipse
- El proyecto debe estar previamente importado como maven project o desde github.
- Ir a Run->Run configuration -> Maven Build -> New configuration
- Seleccionar el directorio base ej. ${workspace_loc:/calculadora} 
- En goals indicar goal spring-boot:run
- Ejecutar proyecto Run->New_Configuration 

