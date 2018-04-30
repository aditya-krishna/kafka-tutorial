FROM alpine:latest

RUN { \
		echo '#!/bin/sh'; \
		echo 'set -e'; \
		echo; \
		echo 'dirname "$(dirname "$(readlink -f "$(which javac || which java)")")"'; \
	} > /usr/local/bin/docker-java-home \
	&& chmod +x /usr/local/bin/docker-java-home

ENV JAVA_HOME /usr/lib/jvm/java-1.8-openjdk
ENV PATH $PATH:/usr/lib/jvm/java-1.8-openjdk/jre/bin:/usr/lib/jvm/java-1.8-openjdk/bin
ENV JAVA_VERSION 8u151
ENV JAVA_ALPINE_VERSION 8.151.12-r0

RUN set -x \
	&& apk add --no-cache \
		openjdk8="$JAVA_ALPINE_VERSION" \
	&& [ "$JAVA_HOME" = "$(docker-java-home)" ]

RUN apk update && apk upgrade && \
    apk add --no-cache bash git openssh

ENV MAVEN_VERSION 3.5.2
ENV MAVEN_HOME /usr/lib/mvn
ENV PATH $MAVEN_HOME/bin:$PATH
ENV APP_VERSION 1.0-SNAPSHOT
ENV APP_NAME kafka-consumer-spring

RUN wget http://archive.apache.org/dist/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz && \
  tar -zxvf apache-maven-$MAVEN_VERSION-bin.tar.gz && \
  rm apache-maven-$MAVEN_VERSION-bin.tar.gz && \
  mv apache-maven-$MAVEN_VERSION /usr/lib/mvn

RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

RUN git clone https://github.com/aditya-krishna/kafka-tutorial.git

WORKDIR /usr/src/app/kafka-tutorial/kafka-consumer-spring

RUN mvn clean install && \
    mv /usr/src/app/kafka-tutorial/kafka-consumer-spring/target/$APP_NAME-$APP_VERSION.jar \
        /usr/src/app

CMD java -jar -Dspring.profiles.active=$environment /usr/src/app/$APP_NAME-$APP_VERSION.jar