# DemoContratos
Java Spring Project to demo security related features
## Compile
maven clean package
## Deploy
cp target/DemoContratos /d/docker_playground/
docker cp /d/docker_playground/DemoContratos.war transferweb01:/usr/local/tomcat/webapps