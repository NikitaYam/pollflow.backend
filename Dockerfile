# Стадия сборки
FROM maven:3.9.8-eclipse-temurin-17 AS builder

WORKDIR /app

# Копируем POM для кэширования зависимостей
COPY pom.xml .

# Скачиваем зависимости
RUN mvn dependency:go-offline -B

# Копируем исходный код
COPY src ./src

# Собираем приложение
RUN mvn clean package -DskipTests

# Финальная стадия (как у тимлида)
FROM bellsoft/liberica-openjdk-alpine:17.0.12-cds

WORKDIR /backend

# Копируем JAR из стадии сборки
COPY --from=builder /app/target/*.jar /backend/backend.jar

# Создаем пользователя для безопасности (дополнение)
RUN addgroup -S appgroup && adduser -S appuser -G appuser
USER appuser

CMD ["java", "-jar", "backend.jar"]