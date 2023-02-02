Reproducer for the following error:

`org.hibernate.HibernateException: Generation of HibernateProxy instances at runtime is not allowed when the configured BytecodeProvider is 'none'; your model requires a more advanced BytecodeProvider to be enabled.`

# Build the entities project
`mvn clean install`

# Build and run native image
```
mvn -Pnative spring-boot:build-image &&
docker run -p 9080:9080 docker.io/library/reproduce-server:0.0.1-SNAPSHOT
```

visit http://127.0.0.1:8080/read

Sample stacktrace:

