#!/bin/bash

while IFS='' read -r line; do docker rmi "$line"; done < <(docker images|grep -i cloudrs |awk '{print $3}')