FROM openjdk:8

ADD target/my-first-maven-docker.jar /app/

ENTRYPOINT ["java", "-jar", "app/my-first-maven-docker.jar"]

VOLUME /game_volume

EXPOSE 8080