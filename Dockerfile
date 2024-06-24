FROM amazoncorretto:21-alpine
ENV context ""
ENV port 8182
ADD /src/main/resources/application.properties //
ADD /target/corejava21-with-maven-template-1.0-SNAPSHOT-jar-with-dependencies.jar //
ENTRYPOINT ["java","-jar", "/corejava21-with-maven-template-1.0-SNAPSHOT-jar-with-dependencies.jar","--server.port=${port}"]

