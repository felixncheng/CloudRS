# CloudRS
一套微服务的架构的整合，包含基于springcloud的微服务实现，通用业务解决方案，运维监控等

## Features
* 服务注册与发现
* 服务调用
* 链路追踪日志
* 服务网关
* 统一配置中心
* CI/CD
* spring cloud OAuth2
* spring admin 系统监控
* turbine断路器聚合监控
* zipkin调用链监控
* pinpoint监控
* gitlab 代码仓库
* harbor 镜像仓库
* Jenkins pipeline CI/CD
* apollo配置中心
* seata分布式事务

# 启动服务
分别按顺序启动register/config/auth/gateway/uc/payment service

运行script/cloudrs.sql

```bash
# 获取token
curl --request POST 'http://localhost:8080/auth/oauth/token?grant_type=password&username=cheng&password=123456&client_id=cloudrs&client_secret=123456' 

{"access_token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJsaWNlbnNlIjoibWFkZSBieSBjbG91ZHJzIiwidXNlcl9uYW1lIjoiY2hlbmciLCJzY29wZSI6WyJzZXJ2ZXIiXSwiZXhwIjoxNTkyODUxNjc1LCJ1c2VySWQiOjEsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiIsIkFETUlOIl0sImp0aSI6IjQ3YmQ3NzJmLWY1YmQtNDkzZi1hODNmLTM4ODhlNGM0MzdkNSIsImNsaWVudF9pZCI6ImNsb3VkcnMifQ.Zlil_UIlkzSYyXPY9Br_W4AVr-czFMBIIjPgkS-jiZI","token_type":"bearer","refresh_token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJsaWNlbnNlIjoibWFkZSBieSBjbG91ZHJzIiwidXNlcl9uYW1lIjoiY2hlbmciLCJzY29wZSI6WyJzZXJ2ZXIiXSwiYXRpIjoiNDdiZDc3MmYtZjViZC00OTNmLWE4M2YtMzg4OGU0YzQzN2Q1IiwiZXhwIjoxNTk1NDAwNDc1LCJ1c2VySWQiOjEsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiIsIkFETUlOIl0sImp0aSI6IjM5NjBjNDIzLWRiMmMtNDMxOS1hNDkzLTkwNGRjNDE2ZDA0NCIsImNsaWVudF9pZCI6ImNsb3VkcnMifQ.ok1m04NpBlqSkW36xHgDmcK5-ePR41fnucopEX3o7PI","expires_in":40171,"scope":"server","license":"made by cloudrs","userId":1,"jti":"47bd772f-f5bd-493f-a83f-3888e4c437d5"}

# 访问请求
curl --request GET 'http://localhost:8080/payment/balance/query' \
> --header 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJsaWNlbnNlIjoibWFkZSBieSBjbG91ZHJzIiwidXNlcl9uYW1lIjoiY2hlbmciLCJzY29wZSI6WyJzZXJ2ZXIiXSwiZXhwIjoxNTkyODUxNjc1LCJ1c2VySWQiOjEsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiIsIkFETUlOIl0sImp0aSI6IjQ3YmQ3NzJmLWY1YmQtNDkzZi1hODNmLTM4ODhlNGM0MzdkNSIsImNsaWVudF9pZCI6ImNsb3VkcnMifQ.Zlil_UIlkzSYyXPY9Br_W4AVr-czFMBIIjPgkS-jiZI'

{"requestId":"89f3e0c28e10c063","code":200,"message":null,"data":"Hello, cheng!, id: 1"}
```

