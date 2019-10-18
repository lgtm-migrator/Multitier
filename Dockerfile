# Using OpenJDK CircleCI Docker image:
FROM circleci/openjdk:14-jdk-buster

# Set working directory:
RUN mkdir /app
WORKDIR /app

# Move entire application to container:
COPY . /app
