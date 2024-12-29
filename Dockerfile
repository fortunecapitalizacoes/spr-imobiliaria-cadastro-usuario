FROM openjdk:17-jdk-alpine

# Definindo o argumento de build com um valor padrão
ARG BUILDID=1.0.0

# Atribuindo o valor do argumento de build a uma variável de ambiente
ENV BUILD_ID=$BUILDID

RUN apk update && apk upgrade

RUN apk add --no-cache ttf-dejavu

RUN apk --no-cache add msttcorefonts-installer fontconfig && update-ms-fonts && fc-cache -f

COPY sec/*.crt  $JAVA_HOME/lib/security/

COPY sec/security.properties security.properties

RUN keytool -importcert -file $JAVA_HOME/lib/security/_.tbg.com.br.crt -storepass changeit -noprompt -alias TBGCOMBR -keystore $JAVA_HOME/lib/security/cacerts

COPY target/*.jar app.jar

RUN adduser -D appuser

ENV TZ=America/Sao_Paulo

USER appuser

ENTRYPOINT ["java","-jar","-Djava.security.properties=security.properties","app.jar"]