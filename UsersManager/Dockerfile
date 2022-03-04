FROM openjdk:11
ADD build/libs/UsersManager-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT exec java $JAVA_OPTS -jar /app/app.jar