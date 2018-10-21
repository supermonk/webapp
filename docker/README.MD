# Webapp-Docker
## Basic Overview
```text
Dockerised Infrastrcuture
1. docker-webapp
    a. Loads the jar into image and start the app 
    b. Network connection established with elastic
2. Database
    a. Redis Cache docker
    b. Mysql Database docker
3.  Monitoring
    a. Elastic docker
    b. Kibana  docker
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
sh recreate.sh
#or In each folder
docker-compose up -d
# To close
sh destroy.sh 
# or in each folder
docker-compose kill 
```

## Helpful docker Commands
```markdown
docker kill $(docker ps -a -q)
docker rm $(docker ps -a -q)
docker volume rm $(docker volume ls)
docker network rm $(docker network ls)
docker ps -aq --no-trunc -f status=exited | xargs docker rm -f
docker rm $(docker ps -qa --no-trunc --filter "status=exited")
docker network rm $(docker network ls | grep "bridge" | awk '/ / { print $1 }')
docker volume rm $(docker volume ls -qf dangling=true)
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
4. https://stackoverflow.com/questions/38088279/communication-between-multiple-docker-compose-projects
5. https://github.com/nimmis/docker-java-centos 

## Creator
![supermonk](https://github.com/supermonk)
<p align="center"><img width=50% src="https://avatars3.githubusercontent.com/u/5060860?s=400&u=06fa0ee43a0830f9c038e49468e258319c316437&v=4"></p>
<br>