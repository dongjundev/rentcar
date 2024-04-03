# 

## Model
www.msaez.io/#/60119368/storming/rentcar

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd infra
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- reserve
- car
- notification
- customercenter


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- reserve
```
 http :8088/reserves id="id" userId="userId" carId="carId" qty="qty" 
```
- car
```
 http :8088/cars id="id" carName="carName" stock="stock" 
```
- notification
```
 http :8088/messages id="id" userId="userId" content="content" 
```
- customercenter
```
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```

# Check List
## MSA 아키텍처 구성도

## 도메인 분석 - 이벤트스토밍
![image](https://github.com/dongjundev/rentcar/assets/60119368/643575c4-0994-4760-9ed0-11dcca711602)

## 분산트랜잭션 - Saga

![image](https://github.com/dongjundev/rentcar/assets/60119368/c50245b7-f282-44de-94f5-018b3881d7ac)

![image](https://github.com/dongjundev/rentcar/assets/60119368/ab2d2b58-2bf5-49f5-bcda-4c8dd7968a6e)

![image](https://github.com/dongjundev/rentcar/assets/60119368/83dcb74f-70a1-4836-b2fd-d0436dcc7f7a)

![image](https://github.com/dongjundev/rentcar/assets/60119368/038f779c-3dff-446e-872c-e29647189f27)


## 보상처리 - Compensation

## 단일 진입점 - Gateway

## 분산 데이터 프로젝션 - CQRS

## 클라우드 배포 - Container 운영

## 컨테이너 자동확장 - HPA

## 컨테이너로부터 환경분리 - ConfigMap/Secret

## 클라우드스토리지 활용 - PVC

## 셀프 힐링/무정지 배포 - Liveness/Rediness Probe

## 서비스 메쉬 응용 - Mesh

## 통합 모니터링 - Loggregation/Monitoring
