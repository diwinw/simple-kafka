# simple-kafka

## Getting Started
simple published and consumed messages from Kafka.
### Prerequisites
- Java 17 or higher

### Running docker file for setup postgres
```
git clone https://github.com/diwinw/simple-kafka.git
cd simple-kafka
```
install zookeeper and kafka
```
docker-compose up -d
```
### Running the Application
install
```
mvn clean install
```
Consume message to kafka use file kafka.jmx with jmeter.


### Built With
- Spring Boot
- Zookeeper
- Kafka
- Jmeter