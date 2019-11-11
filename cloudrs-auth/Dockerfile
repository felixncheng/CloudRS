FROM chengmboy/java8-jre-enhance

ENV JAVA_OPTS="-javaagent:/pinpoint-agent/pinpoint-bootstrap-1.8.5.jar -Dpinpoint.agentId=clodurs-auth-1 -Dpinpoint.applicationName=cloudrs-auth"

VOLUME ["/cloudrs/heap_dump"]

ARG ACTIVE
ENV ACTIVE $ACTIVE

EXPOSE 8764

COPY target/cloudrs-auth-1.0-SNAPSHOT.jar /app.jar
ENTRYPOINT ["sh","-c","dockerize -timeout 5m -wait http://cloudrs-register:9991/ -wait http://cloudrs-config:8888/actuator/info java ${JAVA_OPTS} -Xms128M -Xmx128M -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/cloudrs/heap_dump -Dspring.profiles.active=$ACTIVE -jar /app.jar"]

