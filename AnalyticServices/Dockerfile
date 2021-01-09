FROM adoptopenjdk/openjdk11:ubi
EXPOSE 8080
RUN mkdir /usr/app
COPY AnalyticServices-1.0.jar /usr/app
WORKDIR /usr/app
RUN sh -c 'touch AnalyticServices-1.0.jar'
ENTRYPOINT ["java", "-jar", "AnalyticServices-1.0.jar"]