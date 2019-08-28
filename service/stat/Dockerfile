FROM openjdk:8u111-jdk-alpine
VOLUME /tmp
ADD target/stat-0.0.1-SNAPSHOT.jar stat.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","-Dfile.encoding=utf-8","-Dclient.encoding.override=utf-8","-Djava.net.preferIPv4Stack=true","-server","/stat.jar"]