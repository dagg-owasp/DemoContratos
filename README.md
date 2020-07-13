# DemoContratos
Java Spring Project to demo security related features
## Compile
```sh
mvn clean package
```
## Deploy
```sh
cp target/DemoContratos /d/docker_playground/
docker cp /d/docker_playground/DemoContratos.war transferweb01:/usr/local/tomcat/webapps
```