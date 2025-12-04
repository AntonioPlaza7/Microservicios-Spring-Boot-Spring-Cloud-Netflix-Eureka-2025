📌 Proyecto de Arquitectura de Microservicios con Spring Boot & Spring Cloud

Este repositorio contiene el proyecto final del curso “Microservicios Spring Boot, Spring Cloud Netflix Eureka 2025”, donde se desarrolló una arquitectura completa basada en microservicios totalmente preparada para su despliegue en AWS.

🏗 Arquitectura del Proyecto

El sistema está compuesto por múltiples microservicios independientes, comunicados por HTTP y gestionados por un ecosistema de Spring Cloud:

├── config-server            # Configuración centralizada
├── docker-compose           # Orquestación y despliegue local
├── eureka-server            # Registro y descubrimiento de servicios
├── libs-msvc-commons        # Librería común para compartir modelos y utilidades
├── msvc-gateway-server      # API Gateway - entrada a los microservicios
├── msvc-items               # Servicio de Items / Ventas
├── msvc-oauth               # Servicio de Autorización y generación de JWT
├── msvc-products            # Servicio de Productos
├── msvc-users               # Servicio de Usuarios
├── zipkin                   # Trazabilidad distribuida para diagnóstico
└── .gitignore


Cada servicio se ejecuta de manera independiente, permitiendo escalabilidad, despliegues aislados y resiliencia.

🚀 Tecnologías y herramientas utilizadas
Categoría	Tecnologías
Backend	Spring Boot 3, Java
Cloud & Discovery	Spring Cloud (Eureka, Gateway, Config Server, LoadBalancer)
Seguridad	Spring Security, OAuth2, JWT
Comunicación	Feign Client, WebClient
Resiliencia	Resilience4J (Circuit Breaker, Retry, Rate Limiter)
Observabilidad	Micrometer Tracing & Zipkin
DevOps	Docker, Docker Compose, Docker Networks
Base de Datos	MySQL
AWS Deployment Ready	EC2, VPC, Security Groups
Herramientas de desarrollo	VS Code, Postman
🎯 Funcionalidades Conseguídas

✔️ Microservicios RESTful con responsabilidades separadas
✔️ Configuración centralizada y dinámica
✔️ Registro automático y descubrimiento mediante Eureka
✔️ API Gateway con filtrado, rutas seguras y cross-cutting concerns
✔️ Balanceo de carga en cliente con LoadBalancer
✔️ Seguridad distribuida: login, roles y JWT
✔️ Tolerancia a fallos y control de latencia con Resilience4J
✔️ Trazabilidad distribuida entre servicios con Zipkin
✔️ Contenerización y despliegue con Docker
✔️ Preparado para servidor en la nube (AWS EC2)

▶️ Ejecución del proyecto
Opción 1️⃣ – Ejecución local

Cada microservicio se puede ejecutar desde su propio proyecto:

mvn spring-boot:run


Asegúrate del siguiente orden:

config-server

eureka-server

msvc-gateway-server

El resto de microservicios

Opción 2️⃣ – Ejecución con Docker Compose 🐳 (Recomendado)

Entra a la carpeta docker-compose y ejecuta:

docker-compose up -d


Esto levantará:

MySQL

Config Server

Eureka Server

Gateway

Microservicios

Zipkin

Todos los contenedores se conectan mediante redes Docker internas.

🔐 Seguridad y Autenticación

El flujo de seguridad se basa en:

Autenticación en msvc-oauth → Genera JWT

El Gateway valida el token

Los microservicios confirman el rol y permisos del usuario

Roles disponibles:

ROLE_ADMIN

ROLE_USER

🔍 Observabilidad y Trazabilidad

Se implementó:

Micrometer Tracing

Zipkin para visualizar los flujos distribuidos de peticiones

Ejemplo de dashboards en Zipkin:

📌 Traza completa desde Gateway → Usuarios → Productos → Items

☁️ Despliegue en AWS

El proyecto está totalmente preparado para:
✔ Ejecutar cada microservicio como contenedor
✔ Crear redes privadas entre contenedores
✔ Levantar infraestructura en EC2 (Elastic Compute Cloud)
✔ Configurar acceso seguro mediante grupos de seguridad

Próximo objetivo: automatizar despliegues con Docker Hub + EC2
