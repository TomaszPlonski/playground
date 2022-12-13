FROM sapmachine:latest

ADD target/game-producer-jar-with-dependencies.jar app/

ENTRYPOINT ["java", "-jar", "app/game-producer-jar-with-dependencies.jar"]

EXPOSE 8090