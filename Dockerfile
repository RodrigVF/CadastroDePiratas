FROM eclipse-temurin:17
LABEL maintainer="rodrigvf"
WORKDIR /app
COPY target/CadastroDePiratas-0.0.1-SNAPSHOT.jar /app/cadastro-piratas.jar
ENTRYPOINT ["java", "-jar", "cadastro-piratas.jar"]
VOLUME ["/data"]

ENV DATABASE_URL="jdbc:h2:file:./data/CadastroDePiratasDb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE";
ENV DATABASE_USERNAME="cadastro_db"
ENV DATABASE_PASSWORD="cadastro_db"