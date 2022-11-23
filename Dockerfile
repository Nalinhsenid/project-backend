FROM openjdk:17
RUN mkdir "app"
COPY target/lms-0.0.1-SNAPSHOT.jar /app
WORKDIR /app
EXPOSE 8080
CMD java -jar lms-0.0.1-SNAPSHOT.jar