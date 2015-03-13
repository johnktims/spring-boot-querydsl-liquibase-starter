```bash
mvn clean spring-boot:run
```
creates the database from the liquibase changeset in ```src/main/resources/db/changelog/db.changelog-master.yaml```

```bash
mvn hibernate:hbm2java
```
then reverse engineers that database and creates JPA entites.
