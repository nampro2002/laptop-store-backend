D# 🏗 STAGE 1: Build ứng dụng (sử dụng Maven)
FROM maven:3.8.6-eclipse-temurin-17 AS builder
WORKDIR /app

# Copy file cấu hình Maven (nếu có) để cache dependencies
COPY pom.xml .
COPY src ./src

# Cài đặt dependencies trước để tối ưu caching
RUN mvn clean package -DskipTests

# 🏗 STAGE 2: Chạy ứng dụng với JDK 17 (Tối ưu bộ nhớ)
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copy file JAR từ stage 1
COPY --from=builder /app/target/*.jar app.jar

# Expose port
EXPOSE 8080

# Chạy ứng dụng
ENTRYPOINT ["java", "-jar", "app.jar"]
