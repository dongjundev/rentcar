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

![image](https://github.com/dongjundev/rentcar/assets/60119368/9f6731b6-3cda-46de-b40e-c32cb41a5e94)

![image](https://github.com/dongjundev/rentcar/assets/60119368/038f779c-3dff-446e-872c-e29647189f27)


## 보상처리 - Compensation
<img width="943" alt="1" src="https://github.com/dongjundev/rentcar/assets/60119368/750d2837-8643-448f-b593-bb64e4c5d505">

<img width="1165" alt="2" src="https://github.com/dongjundev/rentcar/assets/60119368/88b5079e-2a02-4bef-a774-830f538f9a24">

<img width="918" alt="3" src="https://github.com/dongjundev/rentcar/assets/60119368/e9d2605d-ecdc-4e82-9dad-f1a3aa9bfd2c">

<img width="937" alt="4" src="https://github.com/dongjundev/rentcar/assets/60119368/81d43e83-5431-49ad-9a72-56c3db1e4097">


## 단일 진입점 - Gateway
<img width="1161" alt="2" src="https://github.com/dongjundev/rentcar/assets/60119368/88551312-48f6-4875-8f67-be943aa5ffb0">

<img width="506" alt="1" src="https://github.com/dongjundev/rentcar/assets/60119368/2bf0e415-9207-45e7-b68f-13480db9c2c6">

<img width="1081" alt="3" src="https://github.com/dongjundev/rentcar/assets/60119368/5778ce19-93f0-4be4-9a26-43a18d53b8df">


## 분산 데이터 프로젝션 - CQRS
<img width="1127" alt="1" src="https://github.com/dongjundev/rentcar/assets/60119368/ba7a77d1-58e4-46be-8cf6-a2f239546bda">

<img width="1127" alt="2" src="https://github.com/dongjundev/rentcar/assets/60119368/c41eeda7-87da-4c6f-be88-f62cf5018066">

<img width="1045" alt="3" src="https://github.com/dongjundev/rentcar/assets/60119368/222e28b0-6428-4c68-9ae6-637bb5afbb7f">


## 클라우드 배포 - Container 운영
<img width="1219" alt="1" src="https://github.com/dongjundev/rentcar/assets/60119368/793ebe06-6d1e-4b52-a3f0-57ffcc4535a3">


## 컨테이너 자동확장 - HPA

## 컨테이너로부터 환경분리 - ConfigMap/Secret

## 클라우드스토리지 활용 - PVC

<img width="1192" alt="2" src="https://github.com/dongjundev/rentcar/assets/60119368/5a390b3e-b4e2-4598-a94b-f95adfddd81d">


## 셀프 힐링/무정지 배포 - Liveness/Rediness Probe

## 서비스 메쉬 응용 - Mesh

## 통합 모니터링 - Loggregation/Monitoring
