#!/usr/bin/env bash

docker login -u ${DOCKER_HUB_CREDS_USR} -p ${DOCKER_HUB_CREDS_PSW}


jars_path=$(find . -name *.jar |grep -v source |grep -v remote |grep -v common)

echo 1

for jar_file in ${jars_path[*]}

do

    image=chengmboy/$(echo $jar_file | awk -F "[/]" '{print $NF}'|cut -d '-'  -f 1-2)

    echo $image
    echo ${GIT_TAG}

    docker build --build-arg JAR_FILE=$jar_file -t $image:${GIT_TAG} .

    docker push $image:${GIT_TAG}

    docker rmi  $image:${GIT_TAG}
done



