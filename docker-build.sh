#!/usr/bin/env bash

mvn clean package
docker build --build-arg JAR_FILE=./target/sk-dbi-be-0.0.1-SNAPSHOT.jar -t triventoit-docker.jfrog.io/sk-dbi-be:latest .
