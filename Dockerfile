FROM openjdk:8-jdk-alpine

#构建参数
ARG JAR_FILE
ARG WORK_PATH="/app"
ARG JAR_PATH
# 环境变量
ENV JAVA_OPTS="" \
    JAR_FILE=${JAR_FILE}\
    JAR_PATH=${JAR_PATH}

#设置时区
#RUN apk update && apk add ca-certificates && \
#    apk add tzdata && \
#    ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && \
#    echo "Asia/Shanghai" > /etc/timezone

COPY $JAR_PATH $WORK_PATH/

WORKDIR $WORK_PATH

ENTRYPOINT exec java $JAVA_OPTS -jar $JAR_FILE --server.port=8080
