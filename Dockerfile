# Using Mave+OpenJDK Docker official image:
FROM maven:3.6.2-jdk-12

# Set working directory:
RUN mkdir /usr/src/app
WORKDIR /usr/src/app

# Move entire application to container:
COPY . /app
