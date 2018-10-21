Run 
sh recreate.sh

in shell



docker kill $(docker ps -a -q)
docker rm $(docker ps -a -q)
docker volume rm $(docker volume ls)
docker network rm $(docker network ls)

docker ps -aq --no-trunc -f status=exited | xargs docker rm -f 



http://localhost:8301/swagger-ui.html#/

http://localhost:5601/app/kibana#/management/kibana/index?_g=()



ref: https://stackoverflow.com/questions/38088279/communication-between-multiple-docker-compose-projects