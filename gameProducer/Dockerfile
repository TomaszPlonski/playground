FROM openjdk:8

ADD target/game-producer.jar /app/

ENTRYPOINT ["java", "-jar", "app/game-producer.jar"]

#VOLUME /game_volume

EXPOSE 8090