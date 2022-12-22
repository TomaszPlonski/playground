# Playground for developing skills #

This is simple app with one producer sending via Kafka JSON objected to consumer. <br/>
Consumer analize it, save it do database and serves as rest controller.

## How to run ##
Just run docker-compose on playground/docker-compose.yml
Producer and consumer servives images will be downlonad from my docker hub.

### GameProducer: ###
Every three seconds, the producer generates game of Rock Paper Scissors, between two of the randomly selected 22 players.<br/>
Each player's move is also randomly selected.<br/>
The result of the matches is sent in JSON format to GameOperator

### GameOperator: ###
GameOperator recives message, maps it to an object which it saves in the database.
Also provides endpoints

- GET: (`localhost:8080/players`) - To get list of names who played game
- GET: (`localhost:8080/player-wins/{name}`) - To get the number of victories of the given person


## DOCKER ##
<p>Zookeeper exposed on port 2181</p>
<p>Kafka exposed on port 9092</p>
<p>Game Producer exposed on port 8090</p>
<p>Game Operator exposed on port 8080</p>
<p>MySql exposed on port 3306</p>
<b>