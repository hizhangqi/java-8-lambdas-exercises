#!/usr/bin/env bash

projects=(

micro-service-parent/zhgd-activity-parent/zhgd-activity-microservice
#micro-service-parent/zhgd-base-parent/zhgd-base-microservice
#micro-service-parent/zhgd-customer-parent/zhgd-customer-cs-microservice
#micro-service-parent/zhgd-customer-parent/zhgd-customer-mall-microservice
#micro-service-parent/zhgd-customer-parent/zhgd-customer-microservice
#micro-service-parent/zhgd-customer-parent/zhgd-customer-product-microservice
#micro-service-parent/zhgd-customer-parent/zhgd-dealer-charge-microservice
#micro-service-parent/zhgd-finance-parent/zhgd-finance-microservice
#micro-service-parent/zhgd-order-parent/zhgd-order-microservice
#micro-service-parent/zhgd-product-parent/zhgd-product-microservice
#micro-service-parent/zhgd-report-parent/zhgd-report-microservice
#micro-service-parent/zhgd-resource-parent/zhgd-resource-microservice
#micro-service-parent/zhgd-shopcar-parent/zhgd-shopcar-microservice
#micro-service-parent/zhgd-system-parent/zhgd-system-microservice
#micro-service-parent/zhgd-user-parent/zhgd-user-base-microservice
#micro-service-parent/zhgd-user-parent/zhgd-user-hjk-microservice
#micro-service-parent/zhgd-warehouse-parent/zhgd-grid-warehouse-microservice
#micro-service-parent/zhgd-wms-parent/zhgd-external-wms-microservice
#micro-service-parent/zhgd-wms-parent/zhgd-wms-microservice
#micro-service-parent/zhgd-yunxuetang-parent/zhgd-yunxuetang-microservice
#service-parent/activity-parent/activity-microservice
#service-parent/activity-parent/collage-microservice
#service-parent/activity-parent/hxdgame-microservice
#service-parent/activity-parent/hxdmall-microservice
#service-parent/activity-parent/orderphoto-microservice
#service-parent/activity-parent/shareinvite-microservice
#service-parent/activity-parent/srlevel-microservice
#service-parent/activity-parent/taskpackage-microservice
#service-parent/activity-parent/teamwar-microservice
#service-parent/brandhub-parent/brandhub-admin-microservice
#service-parent/brandhub-parent/brandhub-performance-microservice
#service-parent/brandhub-parent/brandhub-tenant-microservice
#service-parent/brandpromotion-parent/promotion-admin-microservice
#service-parent/brandpromotion-parent/promotion-microservice
#service-parent/coupon-parent/coupons-analysis
#service-parent/coupon-parent/coupons-feign
#service-parent/coupon-parent/coupons-microservice
#service-parent/coupon-parent/coupons-platform
#service-parent/cps-parent/cps-microservice
#service-parent/customer-parent/customer-microservice
#service-parent/customer-parent/dealer-microservice
#service-parent/customer-parent/dealer-product-microservice
#service-parent/customer-parent/sr-microservice
#service-parent/customer-parent/sr-vote-microservice
#service-parent/docking-parent/docking-dingding-microservice
#service-parent/docking-parent/docking-weiban-microservice
#service-parent/hdh-parent/hdh-microservice
#service-parent/hdh-parent/hdh-platform
#service-parent/hph-parent/hph-microservice
#service-parent/hph-parent/hph-platform
#service-parent/htv-parent/htv-microservice
#service-parent/htv-parent/htv-platform
#service-parent/huipay-parent/alipay-microservice
#service-parent/huipay-parent/baofoo-microservice
#service-parent/huipay-parent/dockpay-microservice
#service-parent/huipay-parent/huipay-microservice
#service-parent/huipay-parent/huipaytask-microservice
#service-parent/huipay-parent/lakala-direct-microservice
#service-parent/huipay-parent/lakala-microservice
#service-parent/huipay-parent/mongo-microservice
#service-parent/huipay-parent/mybank-microservice
#service-parent/huipay-parent/pinganbank-microservice
#service-parent/huipay-parent/webank-microservice
#service-parent/huipay-parent/wxpay-microservice
#service-parent/huipay-parent/yeepay-microservice
#service-parent/kingdee-parent/kingdee-microservice
#service-parent/live-parent/live-gateway
#service-parent/live-parent/live-microservice
#service-parent/log-parent/log-microservice
#service-parent/lts-parent/lts-microservice
#service-parent/message-process-parent/message-process-microservice
#service-parent/msg-parent/msg-microservice
#service-parent/openapi-parent/open-api-service
#service-parent/order-parent/order-microservice
#service-parent/product-parent/hxdproduct-microservice
#service-parent/product-parent/hxdsku-microservice
#service-parent/risk-parent/risk-admin-microservice
#service-parent/risk-parent/risk-base-microservice
#service-parent/risk-parent/risk-etl-microservice
#service-parent/schedule-parent/schedule-microservice
#service-parent/search-parent/search-microservice
#service-parent/sfa-parent/performance-microservice
#service-parent/sfa-parent/questionnaire-microservice
#
#service-parent/shared-parent/cloud-base-microservice
#service-parent/shared-parent/cloud-huanxin-microservice
#service-parent/shared-parent/cloud-job-microservie
#service-parent/shared-parent/cloud-netease-microservice
#service-parent/shared-parent/cloud-neteasenew-microservice
#service-parent/shared-parent/cloud-sms-microservice
#service-parent/shared-parent/cloud-template-microservice
#service-parent/shared-parent/cloud-user-microservice
#service-parent/sku-parent/sku-microservice
#service-parent/sku-parent/sku-platform
#service-parent/storage-parent/storage-microservice
#service-parent/wechatofficial-parent/wechatofficial-api-microservice
#service-parent/yunxuetang-parent/yunxuetang-microservice

#infrastructure-parent/cloud-monitor-server
#infrastructure-parent/gateway-parent/brandhub-gateway-server
#infrastructure-parent/gateway-parent/cloud-gateway-server
#infrastructure-parent/gateway-parent/hdh-gateway
#infrastructure-parent/gateway-parent/hph-gateway
#infrastructure-parent/gateway-parent/htv-gateway
#infrastructure-parent/gateway-parent/huipay-gateway
#infrastructure-parent/gateway-parent/open-gateway-server
#infrastructure-parent/gateway-parent/search-gateway
#infrastructure-parent/xxl-job-admin
#micro-infrastructure-parent/zhgd-admin-gateway
#micro-infrastructure-parent/zhgd-app-gateway
#micro-infrastructure-parent/zhgd-finance-gateway

#micro-service-parent/zhgd-warehouse-parent/zhgd-grid-warehouse-task
#micro-service-parent/zhgd-activity-parent/zhgd-activity-task-microservice
#micro-service-parent/zhgd-customer-parent/zhgd-customer-task
#micro-service-parent/zhgd-base-parent/zhgd-base-task
#micro-service-parent/zhgd-report-parent/zhgd-report-task
#micro-service-parent/zhgd-system-parent/zhgd-system-task
#micro-service-parent/zhgd-yunxuetang-parent/zhgd-yunxuetang-task
#service-parent/activity-parent/activity-task
#service-parent/brandhub-parent/brandhub-task
#service-parent/coupon-parent/coupons-task
#service-parent/cps-parent/cps-task
#service-parent/customer-parent/customer-task
#service-parent/customer-parent/dealer-product-task
#service-parent/hdh-parent/hdh-task
#service-parent/hph-parent/hph-task
#service-parent/htv-parent/htv-task
#service-parent/kingdee-parent/kingdee-task
#service-parent/live-parent/live-task
#service-parent/lts-parent/lts-task
#service-parent/msg-parent/msg-task
#service-parent/openapi-parent/open-task-server
#service-parent/risk-parent/risk-task
#service-parent/thirdparty-parent/thirdparty-microservice
#service-parent/user-parent/user-center-gateway-server
#service-parent/user-parent/user-center-microservice
#service-parent/shared-parent/admin-gateway
#service-parent/shared-parent/cloud-xxl-job-microservie
#service-parent/yunxuetang-parent/yunxuetang-task

)

timestamp=$(date "+%Y-%m-%d %H:%M:%S")
timesDate=$(date "+%Y-%m-%d")
log_file="/Users/zhangqi/Documents/Workspaces/hsgd/shell-"$timesDate.log

echo $timestamp $log_file  >> $log_file
if [ -e "log_file" ]; then
      echo $timestamp "文件已存在" >> $log_file
  else
      touch $log_file
      echo $timestamp  "文件已创建" >> $log_file
  fi

git pull

if [ $? -eq 0 ]; then
    echo $timestamp $log_file git pull succeeded >> $log_file
else
    echo $timestamp $log_file git pull failed >> $log_file
fi

if /usr/bin/git pull; then
    echo $timestamp $log_file git pull ok >> $log_file
else
    echo $timestamp $log_file git pull error >> $log_file
    exit
fi



# for 遍历
for item in ${projects[*]}
do
  #echo $item

  # cd $item
   mvn clean install -DskipTests=true -pl $item -am -DarchetypeCatalog=internal


  array=($(echo "$item" | tr '/' ' '))
  echo $timestamp $array[-1]

  file_path="/Users/zhangqi/Documents/Workspaces/hsgd/micro-service-parent/zhgd-activity-parent/zhgd-activity-microservice/target/zhgd-activity-microservice.jar"

  if [ -e "$file_path" ]; then
      echo $timestamp "文件存在" >> $log_file
  else
      echo $timestamp "文件不存在" >> $log_file
  fi

done

echo $timestamp "end" >> $log_file
