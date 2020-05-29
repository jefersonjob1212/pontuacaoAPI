FROM openjdk:8-jdk-alpine
VOLUME tmp/
ADD target/pontuacaofamilia-0.0.1-SNAPSHOT.jar pontuacao.jar
ENTRYPOINT ["java", "-jar", "casapopular.jar"]