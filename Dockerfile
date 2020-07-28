FROM postgres
ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=postgres
COPY initdb.sql /docker-entrypoint-initdb.d/initdb.sql
EXPOSE 5432