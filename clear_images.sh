#!/bin/bash
key=${1:-cloudrs}

while IFS='' read -r line; do docker rmi "$line"; done < <(docker images|grep -i ${key} |awk '{print $3}')