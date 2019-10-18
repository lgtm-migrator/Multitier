# Using OpenJDK Docker official image:
FROM openjdk:12.0.1-jdk

RUN apt-get install maven

# Set working directory:
RUN mkdir /usr/src/app
WORKDIR /usr/src/app

# Move entire application to container:
COPY . /app
