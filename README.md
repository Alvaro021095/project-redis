# Proyecto Redis 
 Este projecto muestra como crear una conexion con la base de datos **Redis** de forma _Reactiva_.
 Se explicara como descargar _Redis_ por **Docker** y asi mismo como iniciarlo.
 
## Docker - Redis

1. #####Desde una consola realizamos los siguientes pasos:
     - Creamos un contenedor con Redis: _docker run -dit -p (Puerto de mi maquina)6379:6379(Puerto del producto) --name my-redis redis(producto)_
     - Ejecutamos el contenedor: _winpty docker exec -it my-redis bash_
     
2. #####Ya dentro de la consola de **Redis** podemos ejecutar los siguientes comandos:
    - Buscar todos los registros: _keys *_
    - Guardar registro: _set ("Llave") (" \ "Value \ " ")_
    - Buscar valor de una llave: _get ("Llave")_
    - Eliminar un registro: _del ("Llave")_
    
3. #####Codigo fuente
    - **Spring Webflux** para utilizar _Endpoints funcionales_.
    - **Reactor** es una biblioteca reactiva de cuarta generación, basada en la especificación Reactive Streams, para construir aplicaciones sin bloqueo en la JVM.
    - **Redis** cache de _Base de Datos_.

4. #####Dependencias
    - _implementation 'org.springframework.boot:spring-boot-starter-webflux'_
    - _implementation 'io.projectreactor:reactor-core'_
    - _implementation 'org.springframework.boot:spring-boot-starter-data-redis-reactive'_
    
5. ####Endpoints y Peticiones
- Obtener Valor por llave: 
     - Tipo de peticion: GET
     - URL: http://localhost:8080/valueKey
     - Headers (Llave Valor): Content-Type - application/json, key - key
- Guardar Registro:
     - Tipo de peticion: GET
     - URL: http://localhost:8080/save
     - Headers (Llave Valor): Content-Type - application/json, key - key, value - value



  
