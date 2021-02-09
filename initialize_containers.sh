#!/bin/bash

# create the caimantech network
docker network create caimantech
# pull the required images 
docker pull postgres
docker pull tomcat:jdk11
# run the containers
docker run --name transferdb01 --network=caimantech -e POSTGRES_PASSWORD=postgres -d postgres
docker run -itd --name=transferweb01 -p 9898:8080 --network=caimantech -e JASYPT_ENCRYPTOR_PASSWORD='V*GWw*7>.Y{f6^ja' tomcat:jdk11
# initialize the database
docker cp initdb.sql transferdb01:/opt 
sleep 3
docker exec -u postgres transferdb01 psql postgres postgres -f /opt/initdb.sql
# compile java application
mvn clean package
# deploy the war file
docker cp target/DemoContratos.war transferweb01:/usr/local/tomcat/webapps