#!/usr/bin/env bash

docker login -u ${DOCKER_HUB_CREDS_USR} -p ${DOCKER_HUB_CREDS_PSW}

#获取所有jar包路径
jars_path=$(find . -name *.jar |grep -v source |grep -v remote |grep -v common)

for jar_file in ${jars_path[*]}

do

    image=chengmboy/$(echo $jar_file | awk -F "[/]" '{print $NF}'|cut -d '-'  -f 1-2)

    docker build --build-arg JAR_FILE=$jar_file -t ${params.DOCKER_IMAGE}:${GIT_TAG} .

    docker push $image:${GIT_TAG}

    docker rmi  $image:${GIT_TAG}
done



