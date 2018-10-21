# Webapp
## Basic Overview
```text
Pragmatic Dockerised End to End Webapp
1. API
    a. SpringBoot API
    b. LogAppender to send logs to Elastic
2. Database
    a. Redis Cache
    b. Mysql Database
3.  Monitoring
    a. Elastic 
    b. Kibana
```
## Prerequsite
```text
1. Java
2. Docker 
3. Developer Mindset
4. Maven 
```
## Setup
```bash
# To start or restart
sh run.sh
# To close
sh destroy.sh 
```
## End Goals
```text
1. API
    a. localhost:8301 REST API end points
    b. http://localhost:8301/swagger-ui.html#/
    c. curl -X GET "http://localhost:8301/" -H "accept: */*" --REST API
2. Database
    a.localhost:3306 mysql
    b. localhost:6379 redis
 http://localhost:5601/app/kibana#/management/kibana/index?_g=()
3. Monitoring
    a. localhost:9200 elastic database endpoint
    b. localhost:5601 kibana 
```
## References
1. https://docker-curriculum.com
2. http://caseyscarborough.com/blog/2014/12/18/caching-data-in-spring-using-redis/
3. https://gist.github.com/bastman/5b57ddb3c11942094f8d0a97d461b430 

## Creator
```bash
@supermonk
```
<p align="center"><img width=95% src=""></p>
<br>
#### Output
```text
------------ Data Features ------------
---------------------------------------
```