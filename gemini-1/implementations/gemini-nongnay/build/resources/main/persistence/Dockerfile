FROM postgres:16.2

COPY init.sql /docker-entrypoint-initdb.d/

ENV POSTGRES_DB ocs
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD password