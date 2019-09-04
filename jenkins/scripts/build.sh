#!/usr/bin/env bash

docker login -u ${DOCKER_HUB_CREDS_USR} -p ${DOCKER_HUB_CREDS_PSW}

jars_path=$(find . -name *.jar |grep -v source |grep -v remote |grep -v common)

for jar_path in ${jars_path[*]}

do

    jar_file=$(echo $jar_path | awk -F "[/]" '{print $NF}')
    image=chengmboy/$(echo $jar_file|cut -d '-'  -f 1-2)

    docker build --build-arg JAR_PATH=$jar_path JAR_FILE=$jar_file -t $image:${GIT_TAG} .

    docker push $image:${GIT_TAG}

    docker rmi  $image:${GIT_TAG}
done



