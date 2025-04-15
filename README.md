## Инструкция

### База данных

Это приложение настроено под работу с PostgreSQL, необходимо установить последнюю версию с [официального сайта](https://www.postgresql.org/)

Запомните параметры входа в СУБД.

Необходимые сущности должны создаться в БД при первом запуске.

### Конфигурация

Необходимо поменять файл application.properties под себя.

```
...
#DB OPTIONS
spring.datasource.url=jdbc:postgresql://localhost:1488/tech_shop - свои порт и название БД
spring.datasource.username=postgres - свой логин
spring.datasource.password=123456 - свой пароль
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
...
```

Также в конфигурации можно поменять Secret для генерации JWT токена авторизации и время жизни токена.
