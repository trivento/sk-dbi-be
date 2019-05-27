#!/usr/bin/env bash

mvn clean package
docker build -t triventoit-docker.jfrog.io/sk-dbi-be:latest .
#docker push triventoit-docker.jfrog.io/sk-dbi-be:latest
