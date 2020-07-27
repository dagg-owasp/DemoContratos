:: create the caimantech network
docker network create caimantech
:: pull the images
docker pull postgres 
docker pull tomcat:jdk8
:: run the containers
docker run --name transferdb01 --network=caimantech -e POSTGRES_PASSWORD=postgres -d postgres
docker run -itd --name=transferweb01 -p 9898:8080 --network=caimantech tomcat:jdk8
:: initialize the databes
docker cp initdb.sql transferdb01:/opt
timeout /t 3 /nobreak > nul
docker exec -u postgres transferdb01 psql postgres postgres -f /opt/initdb.sql
:: compile java application
mvn clean package
:: deploy the war file
docker cp target/DemoContratos.war transferweb01:/usr/local/tomcat/webapps