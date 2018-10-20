FROM java:8
VOLUME /opt
VOLUME /var/log
ADD supermonk-springboot-app-1.0.0.jar supermonk-springboot-app-1.0.0.jar
RUN bash -c 'touch /supermonk-springboot-app-1.0.0.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/supermonk-springboot-app-1.0.0.jar"]