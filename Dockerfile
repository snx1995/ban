FROM maven
COPY ./target/ban.jar /app/app.jar
WORKDIR /app
RUN jav -jar app.jar
EXPOSE 8080
