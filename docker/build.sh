#!/bin/sh

mvn install
docker build -t i-searchservice:latest -f docker/Dockerfile .
docker tag i-searchservice:latest ishangaurav/i-searchservice:latest
docker push ishangaurav/i-searchservice:latest

