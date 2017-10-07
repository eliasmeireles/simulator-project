FROM maven:latest
MAINTAINER Elias Meireles
COPY . /var/www
WORKDIR /var/www
ENTRYPOINT ["mvn", "spring-boot:run"]
EXPOSE 8080