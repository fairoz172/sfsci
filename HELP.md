# Sample spring-boot app running inside docker

#### To Build the image
docker build -t spring-boot-docker .

#### To start the docker container
docker run -d -p 8080:8080 spring-boot-docker

### Sample API:-

http://localhost:8080/api/v1/customer/?page=0&size=20&sort=firstName,asc

http://localhost:8080/api/v1/customer/report

http://localhost:8080/api/v1/customer/grouped