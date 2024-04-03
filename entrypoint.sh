#!/bin/sh
set -eu
export GITHUB="true"
sh -c "java -jar /app.jar --app.path=$path --spring.datasource.url=\"$url\" --spring.datasource.username=$username --spring.datasource.password=$password"