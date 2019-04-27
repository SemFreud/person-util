#!/usr/bin/env bash

file="/Users/amber/IdeaProjects/jeeidp/pom.xml"
key="artifactId"
echo `awk -v key=${key} "/${key}/{print}" ${file}`