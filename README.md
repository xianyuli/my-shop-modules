# MY-SHOP-MODULES
### 前言
跟着[千锋教育-李卫民](https://www.funtl.com/)完成`SpringMvc`的`Maven`模块化开发,复习`SpringMvc`阶段的知识点。都是一些很简单的东西，就当是手生了练练手。  
### 项目部署
- **项目中几个模块默认都是根目录部署。**
> **P.S.** 只怪IDEA开发时调整`tomcat`的`Application context`太方便了
- **以下为`docker`部署，顺便熟悉一下`docker`的基本操作。**  

1. ##### my-shop-admin示例
修改`myShop.properties`中的数据库地址，将项目用maven打包成war，上传至服务器。
```bash
#解压
unzip my-shop-web-admin-1.0.0-SNAPSHOT.war -d admin
cd admin
#新建文件夹
sudo mkdir -p /usr/local/docker/tomcat/admin/ROOT
#复制项目到指定目录
sudo cp -rf * /usr/local/docker/tomcat/admin/ROOT


#docker启动tomcat指定根目录数据卷
docker run -p 8080:8080 --name tomcat:admin \
-v /usr/local/docker/tomcat/admin:/usr/local/tomcat/webapps \
-d tomcat
```
2. ##### API项目和UI项目部署类似，不再赘述，贴出启动脚本：
```bash
#my-shop-api
docker run -p 8081:8080 --name tomcat.api \
-v /usr/local/docker/tomcat/api:/usr/local/tomcat/webapps \
-d tomcat
#my-shop-ui
docker run -p 8082:8080 --name tomcat.ui \
-v /usr/local/docker/tomcat/ui:/usr/local/tomcat/webapps \
-d tomcat
```

3. ##### 项目总览

项目 | 描述 | 地址
---|---|---
my-shop-admin| 后台管理             | IP:8080
my-shop-api  | 中间数据接口，无前台 | IP:8081
my-shop-ui   | 前台门户             | IP:8082
