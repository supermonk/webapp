#!/usr/bin/env bash
print_something_red () {
 printf "\033[1;31m"$1""
 printf "\033[0m\n"
}

SECONDS=0
print_something_red "BUILDING_SPRING_PARENT"
cd supermonk-services
mvn install
cd -
print_something_red "BUILDING_DOCKER_SPRINGBOOT"
cd supermonk-services/supermonk-springboot-app
mvn package docker:build
cd -
print_something_red "BUILDING_REST_OF_INFRA"
cd docker
sh recreate.sh
cd -

duration=$SECONDS
echo "$(($duration / 60)) minutes and $(($duration % 60)) seconds elapsed."