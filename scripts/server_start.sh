#!/usr/bin/env bash
cp /home/ec2-user/server/build/libs/*.jar cp /home/ec2-user/server/
cd /home/ec2-user/server
sudo java -jar -Dserver.port=80 \
    *.jar > /dev/null 2> /dev/null < /dev/null &
