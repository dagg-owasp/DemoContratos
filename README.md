# DemoContratos
Java Spring Project to demo security related features
## Compile
```sh
mvn clean package
```
## Check for SCA vulnerabilities (owasp dependencycheck maven plugin)
```sh
mvn org.owasp:dependency-check-maven:check 
```
## Deploy
```sh
docker compose up
```
## Test
[Login Page](http://127.0.0.1:9898/DemoContratos/login)
## Usuarios
| User          | Password      | Role  |
| ------------- |:-------------:| -----:|
| david         | Password1     | Admin |
| juan          | Password1     | User  |
| Jesica        | Password1     | User  |