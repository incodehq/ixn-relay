FROM openjdk:8-jdk
VOLUME /tmp
ADD ${docker-plugin.resource.include} app.jar
ADD entrypoint.sh /
RUN chmod 755 /entrypoint.sh
CMD /entrypoint.sh
EXPOSE 8080
