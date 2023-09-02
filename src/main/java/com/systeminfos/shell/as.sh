#!/usr/bin/env bash

#micro-service-parent/zhgd-activity-parent/zhgd-activity-microservice
#micro-service-parent/zhgd-activity-parent/zhgd-activity-task-microservice
projects=(
micro-service-parent/zhgd-activity-parent/zhgd-activity-task-microservice
)
#length=${#arr}
#echo "长度为：$length"

IFS="/"


# for 遍历
for item in ${projects[*]}
do


# echo $item
# cd /opt/hsgd/hxd-parent
## /opt/hsgd/hxd-parent/micro-service-parent/zhgd-activity-parent/zhgd-activity-microservice/target/zhgd-activity-microservice.jar

#array=(${item//V/ })
#echo ${#array[@]}

#echo length=${#array_name[@]}
# projectPaht=$pwd
# jarPath='/opt/hsgd/hxd-parent/'$item
## nohup java -jar  /opt/www/sr-microservice.jar --spring.profiles.active=dev


read -ra array <<< "$item"

  for var in ${array[@]}
  do
     echo array[-1]
  done

done



