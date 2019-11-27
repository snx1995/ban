FROM maven
COPY . /app
WORKDIR /app
EXPOSE 10080
CMD mvn clean package & java -jar target/ban.jar
