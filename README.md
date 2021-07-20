### Mô tả

Xây dựng microservice sử dụng Spring Cloud Api Gateway, Keycloak Authorization Server, Eureka Discovery Service, Oauth2 Resource Server

### Dependencies

- Oauth2 Resource Server để tạo các api service
- Keycloak tạo authorization server
- Spring Cloud Api Gateway tạo api gateway để routing
- Eureka để đăng kí các service biến api gateway thành load balancer

### Nhược điểm

- Thời gian request lâu hơn
- Rối, phức tạp

### Setup

- docker run -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=spring_db -d mysql
- Start Keycloak (docker hoặc standalone)
- Start Eureka Server
- Start Api Gateway
- Start các service còn lại
