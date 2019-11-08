FROM chengmboy/java8-jre-enhance


VOLUME ["/cloudrs/heap_dump"]

ARG ACTIVE
ENV ACTIVE $ACTIVE

EXPOSE 9991

COPY target/cloudrs-register-1.0-SNAPSHOT.jar /app.jar
ENTRYPOINT ["sh","-c","java -Xms128M -Xmx128M -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/cloudrs/heap_dump -Dspring.profiles.active=$ACTIVE -jar /app.jar"]

