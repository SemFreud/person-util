#!/usr/bin/env bash

file=$1 #"/Users/amber/IdeaProjects/jeeidp/pom.xml"
key=$2 #"artifactId"
echo `awk -v key=${key} "/${key}/{print}" ${file}`