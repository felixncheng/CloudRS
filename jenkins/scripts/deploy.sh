#!/usr/bin/env bash

app_name=${APP_NAME}

#删除原有容器
container_name=`docker ps -a -f name=$app_name -q`;
if [ $container_name ];then
        echo 删除容器$container_name
        docker rm --f $container_name;
fi

#删除原有镜像
image_name=`docker images|grep -i $app_name|awk '{print $1":"$2}'`;
if [ $image_name ];then
        echo 删除镜像$image_name
        docker rmi -f $image_name;
fi

#选一个可用端口
map=(["cloudrs-register"]=9991 ["cloudrs-ram"]=8700 ["cloudrs-config"]=8701)
port=${map[$app_name]}
docker run -idt  -p $port:8080 \
  --add-host rabbitmq-node1.cloudrs:14.116.177.218 \
  --add-host register-node1.cloudrs:14.116.177.218 \
  --add-host register-node2.cloudrs:14.116.177.218 \
  --add-host register-node3.cloudrs:14.116.177.218 \
  --name=$app_name $image:${GIT_TAG}