#!/bin/bash

# collects release artifacts and copies them to the release directory

projectFolder="."
buildName=$(mvn -q -Dexec.executable="echo" -Dexec.args='${project.artifactId}' --non-recursive exec:exec)
buildVersion=$(mvn -q -Dexec.executable="echo" -Dexec.args='${project.version}' --non-recursive exec:exec)

# check all is in order
if [ ! -e ${projectFolder}/target/${buildName}-${buildVersion}.tar.gz ]
then
  echo "File ${projectFolder}/target/${buildName}-${buildVersion}.tar.gz not found: exiting"
  exit 1
fi

# make the release directory pristine again
if [ ! -d ${projectFolder}/release ]
then
  echo "Creating release folder"
  mkdir ${projectFolder}/release
fi

echo "Removing old files"
rm -rf ${projectFolder}/release/*

echo "Copying release artifacts"
cp ${projectFolder}/target/${buildName}-${buildVersion}.tar.gz release
md5sum release/${buildName}-${buildVersion}.tar.gz | awk '{ print $1 }' > release/${buildName}-${buildVersion}.md5