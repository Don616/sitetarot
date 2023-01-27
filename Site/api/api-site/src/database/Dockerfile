FROM mysql:latest

ENV MYSQL_ROOT_PASSWORD=root

COPY /sql.sql /docker-entrypoint-initdb.d/sql.sql

EXPOSE 3306

CMD ["mysqld"]