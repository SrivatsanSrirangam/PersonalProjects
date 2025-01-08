#!/bin/bash
cd /home/ec2-user
aws s3 cp s3://my-bucket-srivatsan/SpringBootApp1-0.0.1-SNAPSHOT.jar
java -jar SpringBootApp1-0.0.1-SNAPSHOT.jar
