# 💻 Arquitectura de Microservicios con Spring Boot & Spring Cloud

Proyecto final del curso “Microservicios Spring Boot, Spring Cloud Netflix Eureka 2025”, construido con un diseño cloud-native, seguridad distribuida, resiliencia, trazabilidad y despliegue en contenedores totalmente listo para AWS.

# 🧰 Tech Stack

☕ Java · 🌱 Spring Boot / Spring Cloud · 🐳 Docker · ☁️ AWS EC2 · 🛢️ MySQL · 📬 Postman · 🔎 Zipkin · 🔐 OAuth2 / JWT

# 🧱 Arquitectura del Proyecto

📌 **Servicios separados, independientes y desplegables de manera autónoma:**

📂 config-server
   └── Configuración centralizada

📂 docker-compose
   └── Orquestación y redes Docker

📂 eureka-server
   └── Registro y descubrimiento dinámico de servicios

📂 libs-msvc-commons
   └── Librería compartida entre microservicios

📂 msvc-gateway-server
   └── API Gateway (enrutamiento, filtros, seguridad)

📂 msvc-items
   └── Servicio de Items y cálculos de ventas

📂 msvc-oauth
   └── Autenticación y generación de JWT

📂 msvc-products
   └── Gestión de productos

📂 msvc-users
   └── Gestión de usuarios y roles

📂 zipkin
   └── Observabilidad y trazabilidad distribuida

# ⚙ Características Principales

✔️ REST APIs y comunicación entre microservicios
✔️ Balanceo de carga del lado cliente con LoadBalancer
✔️ Configuraciones dinámicas con Config Server
✔️ Seguridad con OAuth2 + JWT, validación vía Gateway
✔️ Resiliencia con Resilience4J
✔️ Eureka para descubrimiento de servicios
✔️ Zipkin para trazabilidad distribuida
✔️ Docker para contenerización y redes privadas
✔️ Preparado para despliegue en AWS EC2

# ▶️ Ejecución del Proyecto
🔸 **Opción 1 – Local (Spring Boot)**

Ejecutar en orden:

config-server
eureka-server
msvc-gateway-server

Luego el resto de microservicios

mvn spring-boot:run

🔸 **Opción 2 – Docker Compose (recomendado)** 🐳

En la carpeta docker-compose:

docker-compose up -d


**Este comando levanta:**
➡️ DB MySQL
➡️ Config + Eureka + Gateway
➡️ Microservicios
➡️ Zipkin

# 🔐 Seguridad

Login delegado a msvc-oauth

Validación de JWT en Gateway

Roles:

ROLE_ADMIN

ROLE_USER

# 🔍 Observabilidad

Completa trazabilidad del flujo de peticiones mediante Zipkin, facilitando diagnóstico en sistemas distribuidos.

# ☁️ Preparado para AWS

✔ Contenedores listos
✔ Redes internas configuradas
✔ Despliegue directo en EC2
