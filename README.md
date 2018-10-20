# webapp
End to End Webapp Java

docker-compose down supermonk-flyway

https://github.com/huangminghuang/opentsdb-grafana-docker

https://elk-docker.readthedocs.io
docker ps -aq --no-trunc -f status=exited | xargs docker rm -f 
 docker volume rm $(docker volume ls -qf dangling=true)




opentsdb-grafana-docker
=======================
A docker compose file to setup Grafana with OpenTSDB/Hbase as the default data source.

curl --silent 'http://admin:admin@localhost:3000/api/datasources' -X POST -H 'Content-Type: application/json;charset=UTF-8' --data-binary '{"name":"OpenTSDB","type":"opentsdb","url":"http://localhost:4242","access":"proxy","isDefault":true}'


docker kill $(docker ps -a -q)

## Usage
$ docker-compose up -d


mvn install
mvn package docker:build

#supermonk app

Ref : http://caseyscarborough.com/blog/2014/12/18/caching-data-in-spring-using-redis/
https://gist.github.com/bastman/5b57ddb3c11942094f8d0a97d461b430 



