FROM openjdk:11
ARG JAR_FILE=target/*jar
ENV SPRING_DATASOURCE_URL = jdbc:mysql://localhost:3306/codecademy
EXPOSE 3306
EXPOSE 8000
ENV SPRING_DATASOURCE_USERNAME = root
ENV SPRING_DATASOURCE_PASSWORD = ""
COPY target/storage-service-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]