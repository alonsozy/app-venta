FROM postgres:9.5-alpine 
ENV POSTGRES_PASSWORD postgres 
ENV POSTGRES_DB store 
COPY init.sql /docker-entrypoint-initdb.d/