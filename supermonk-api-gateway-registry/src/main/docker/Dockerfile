FROM nimmis/java-centos
RUN yum update -y
RUN yum install wget -y
RUN yum install vim -y
RUN yum install telnet -y
VOLUME /opt
VOLUME /var/log
ADD supermonk-springboot-app-1.0.0.jar /var/opt/supermonk-springboot-app-1.0.0.jar
RUN bash -c 'touch /var/opt/supermonk-springboot-app-1.0.0.jar'
ENTRYPOINT ["java","-jar","/var/opt/supermonk-springboot-app-1.0.0.jar"]