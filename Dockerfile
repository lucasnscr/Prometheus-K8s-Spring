FROM azul/zulu-openjdk-alpine:17.0.0
VOLUME /tmp
ARG JAR_FILE=target/kubernetes-prometheus-0.0.1.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]