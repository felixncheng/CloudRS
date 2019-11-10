#!/bin/bash

while IFS='' read -r line; do docker rmi "$line"; done < <(docker images|grep -i hub.chengmboy.com:8003/cloudrs |awk '{print $1":"$2}')