FROM adoptopenjdk/openjdk11:ubi
RUN mkdir /usr/app
COPY ./target/AnalyticServices-1.0.jar /usr/app
WORKDIR /usr/app
RUN sh -c 'touch AnalyticServices-1.0.jar'
ENTRYPOINT ["java", "-jar", "AnalyticServices-1.0.jar"]