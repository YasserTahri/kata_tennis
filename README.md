# Kata Tennis Game

This Kata goal is to implement a simple tennis score computer.

The scoring system consist in one game, divided by points :

Each player starts a game with 0 point.
If the player wins the 1st ball, he will have 15 points. 2nd balls won : 30 points. 3rd ball won : 40points.
If a player have 40 points and wins the ball, he wins the game, however there are special rules.
If both players have 40 points the players are “deuce”.
If the game is in deuce, the winner of the ball will have advantage
If the player with advantage wins the ball he wins the game
If the player without advantage wins the ball they are back at “deuce”.

## Get Started
### Environements

- Java 17
- SpringBoot3

### methodology
TDD

1. Open terminal and clone the repo:
```shell
git clone https://github.com/YasserTahri/kata_tennis.git
```
2. Make sure you are in project root:
```shell
cd kata_tennis
```
3. Build and run the app:
```shell
mvn clean install
mvn spring-boot:run
```
4- Run tests
https://github.com/YasserTahri/kata_tennis/blob/master/src/test/java/com/kata/tennis/service/TennisGameTest.java

# Get score game by API:
GET:  http://localhost:8080/api/v1/tennis-game/score/ABABAA
