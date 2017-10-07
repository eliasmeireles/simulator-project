FROM postgres:9.3
MAINTAINER Elias Meireles
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD root
ENV POSTGRES_DB docker
ADD src/main/resources/simulato-sql.sql /docker-entrypoint-initdb.d/
EXPOSE 5432
