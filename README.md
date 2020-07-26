# DemoContratos
Java Spring Project to demo security related features
## Create Containers (Initial execution only)
```sh
    .\initialize_containers.bat
```
## Compile
```sh
mvn clean package
```
## Deploy
```sh
docker cp target/DemoContratos.war transferweb01:/usr/local/tomcat/webapps
```