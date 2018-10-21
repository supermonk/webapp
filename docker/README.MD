Run 
sh recreate.sh

in shell



docker kill $(docker ps -a -q)
docker rm $(docker ps -a -q)
docker volume rm $(docker volume ls)
docker network rm $(docker network ls)

docker ps -aq --no-trunc -f status=exited | xargs docker rm -f 



1. http://localhost:8301/swagger-ui.html#/
2. http://localhost:5601/app/kibana#/management/kibana/index?_g=()
3. curl -X GET "http://localhost:8301/" -H "accept: */*" --REST API
4. localhost:3306 mysql
5. localhost:6379 redis
6. localhost:9200 elastic database endpoint
7. localhost:5601 kibana
8. localhost:8301 REST API end points



ref: https://stackoverflow.com/questions/38088279/communication-between-multiple-docker-compose-projects
