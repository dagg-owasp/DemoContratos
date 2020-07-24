# DemoContratos
Java Spring Project to demo security related features
## Compile
```sh
mvn clean package
```
## Deploy
```sh
docker cp target/DemoContratos.war transferweb01:/usr/local/tomcat/webapps
```