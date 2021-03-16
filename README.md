# DemoContratos
Java Spring Project to demo security related features
## Create Containers (Initial execution only)
```sh
./initialize_containers.bat
```
## Compile
```sh
mvn clean package
```
## Deploy
```sh
docker cp target/DemoContratos.war transferweb01:/usr/local/tomcat/webapps
```
## Test
http://127.0.0.1:9898/DemoContratos/login

## Password
Password1

## Check for SCA vulnerabilities (owasp dependencycheck maven plugin)
mvn org.owasp:dependency-check-maven:check 
