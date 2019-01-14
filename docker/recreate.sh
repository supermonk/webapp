#!/usr/bin/env bash


print_something_red () {
 printf "\033[1;31m"$1""
 printf "\033[0m\n"
 #
}


print_something_red "Kill_All"

cd docker-database
docker-compose kill
cd ..
cd docker-monitoring
docker-compose kill
cd ..
cd docker-webapp
docker-compose kill
cd ..

sleep 5

print_something_red "remove_components"

docker rm $(docker ps -qa --no-trunc --filter "status=exited")
docker network rm $(docker network ls | grep "bridge" | awk '/ / { print $1 }')
docker volume rm $(docker volume ls -qf dangling=true)


sleep 5

print_something_red "Bring_new"

cd docker-monitoring
docker-compose up -d
cd ..
cd docker-database
docker-compose up -d
cd ..
cd docker-webapp
docker-compose up -d
cd ..

print_something_red "Waiting_for_elastic"
sleep 30
print_something_red "Creating_Index_SPRINGBOOT_LOGS"

curl -H 'Content-Type: application/json' -X PUT -d '{
  "description": "logback pipeline",
  "processors": [
    {
      "set" : {
        "field": "source",
        "value": "logback"
      }
    }
  ]
}' http://localhost:9200/_ingest/pipeline/logback



sleep 5

print_something_red "list_all"

docker ps -a
docker volume ls
docker network ls

print_something_red "GET_API_CALL"

curl -X GET "http://localhost:8301/" -H "accept: */*"

echo "\n"

echo "GO TO http://localhost:5601/app/kibana#/management?_g=() and do regular stuff, not able to automate yet"

curl -X POST "http://localhost:9200/.supermonk/doc/springboot" -H 'Content-Type: application/json' -d'
{
  "type" : "index-pattern",
  "index-pattern" : {
    "title": "supermonk",
    "timeFieldName": "execution_time"
  }
}'

cd docker-database
docker-compose run supermonk-flyway
cd ..

