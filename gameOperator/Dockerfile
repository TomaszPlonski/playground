FROM sapmachine:latest

ADD target/game-operator.jar app/

ENTRYPOINT ["java", "-jar", "app/game-operator.jar"]

EXPOSE 8091