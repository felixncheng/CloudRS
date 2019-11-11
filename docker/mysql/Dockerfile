FROM mysql

COPY ./config/master.cnf /etc/mysql/conf.d/my.cnf
COPY ./init/master_init.sql /docker-entrypoint-initdb.d/init.sql

ENV MYSQL_ROOT_PASSWORD 123456