#!/bin/bash

for jar_path in $(find . -name 'cloudrs*SNAPSHOT.jar' |grep -v common |grep -v order |grep -v resource|grep -v remote)
do
  c=$(echo "$jar_path"|awk -F "[/]" '{print $NF}')
  name=${c%*-1.0-SNAPSHOT.jar}
  target_path=./docker/jar/"$name".jar
  cp "$jar_path" "$target_path"
  echo "deploy $jar_path to $target_path success"
done

