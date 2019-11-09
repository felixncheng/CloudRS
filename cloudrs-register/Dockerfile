FROM chengmboy/java8-jre-enhance

ENV JAVA_OPTS="-javaagent:/pinpoint-agent/pinpoint-bootstrap-1.8.5.jar -Dpinpoint.agentId=clodurs-register-1 -Dpinpoint.applicationName=cloudrs-register"


VOLUME ["/cloudrs/heap_dump"]

ARG ACTIVE
ENV ACTIVE $ACTIVE

EXPOSE 9991

COPY target/cloudrs-register-1.0-SNAPSHOT.jar /app.jar
ENTRYPOINT ["sh","-c","java ${JAVA_OPTS} -Xms128M -Xmx128M -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/cloudrs/heap_dump -Dspring.profiles.active=$ACTIVE -jar /app.jar"]

