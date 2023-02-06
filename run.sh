#!/usr/bin/env bash

set -e -o pipefail

mvn clean package -DskipTests
cd lambda-module
docker build . -f src/main/docker/Dockerfile.jvm -t mydockertag

docker stop mymongodb || true && docker rm mymongodb || true
docker run --name mymongodb -p 27017:27017 -d mongo:6.0.4
docker stop myawslambda || true && docker rm myawslambda || true
docker run --name myawslambda --add-host host.docker.internal:host-gateway -p 9000:8080 -d mydockertag
echo "Starting lambda container..."
curl -XPOST "http://localhost:9000/2015-03-31/functions/function/invocations" -d '{}'
