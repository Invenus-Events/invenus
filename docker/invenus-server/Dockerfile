# Prior to building:
# 1. gradle build
# 2. mkdir -p build/dependency && (cd build/dependency; jar -xf ../libs/Invenus-0.0.1-SNAPSHOT.jar)

FROM amazoncorretto:18-alpine-jdk

RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

ARG DEPENDENCY=build/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
COPY docker/invenus-server/application.properties /app/application.properties
ENTRYPOINT ["java","-cp","app:app/lib/*","club.invenus.invenus.InvenusApplication"]
