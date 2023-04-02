FROM openjdk:17
VOLUME /tmp
EXPOSE 8082
ARG JAR_FILE=../../target/searchservice-1.jar
ADD ${JAR_FILE} searchservice.jar
ENTRYPOINT ["java","-jar","/searchservice.jar"]