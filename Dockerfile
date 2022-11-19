FROM openjdk:11
EXPOSE 8091
ADD target/consumer-0.0.1-SNAPSHOT.jar consumer-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar consumer-0.0.1-SNAPSHOT.jar"]
