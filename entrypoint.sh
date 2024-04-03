#!/bin/sh
set -eu
export GITHUB="true"
echo "Starting with args path: $path"
echo "Starting with args url: $url"
echo "Starting with args username: $username"
echo "Starting with args password: $password"
sh -c "java -jar /app.jar --app.path=$path --spring.datasource.url=$url --spring.datasource.username=$username --spring.datasource.password=$password"