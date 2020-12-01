# Project Code Challenge

_Proyecto Backend para el registro de Ventas_
```

## Comenzando 🚀

_Para obtener una copia del repositorio solo se necesitaría clonar con el siguiente comando: ._

```
git clone https://github.com/alonsozy/app-venta.git
```

### Pre-requisitos 📋

_Para poder desplegar el proyecto es necesario tener instalado:_

```
- Maven
- Java version 8 o superior
- Docker

```

### Despliegue 🔧

_Para poder iniciar todos los contenedores se tiene Dockerfile por el app y la BD_

_Ubicarse en la ruta del file y ejecutar:_

```
docker build db-store .
docker build app .

docker run -d store
docker run -d app
```
_Este comando iniciara todos los contenedores necesarios para deployar el API_


_Una vez iniciado los contenedores se habilitaran dos rutas_

```
http://localhost:2050/swagger-ui.html#/
```


## Ejecutando las pruebas ⚙️

_Para ejecutar los UnitTest ejecutar el siguiente comando en la ubicacion del pom.xml_

```
mvn test
```
## Construido con 🛠️

_Herramientas utilizadas en el desarrollo del proyecto_

```
* Java 8
* Spring Framework
* Spring Boot
* Spring MVC
* Spring JPA
* Swagger: utilizado para la documentacion del contrato del API
* JUnit
* Mockito
* JavaDocs: utilizado para documentar el codigo
* BD PostgreSQL 9.5
* Docker

```

## Autor ✒️

* **Marino Alonso Z.Y. **

_Links:_
* [Linkedin](https://www.linkedin.com/in/marino-alonso-zevallos-yapias-82a200196/)
* Bitbucket : [azevallosyapias](https://bitbucket.org/azevallosyapias/)
* GitHub: [alonsozy](https://github.com/alonsozy)
* DockerHub: [alonsozy](https://hub.docker.com/u/alonsozy)
