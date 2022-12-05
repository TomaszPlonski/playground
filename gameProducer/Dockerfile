FROM openjdk:8

ADD target/my-first-maven-docker.jar /app/

ENTRYPOINT ["java", "-jar", "app/my-first-maven-docker.jar"]

VOLUME /root/.m2

EXPOSE 8080