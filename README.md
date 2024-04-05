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
<img width="705" alt="arch" src="https://github.com/dongjundev/rentcar/assets/60119368/8a406333-a5d7-46d5-8e0e-61b1f762da7c">

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
<img width="1159" alt="1" src="https://github.com/dongjundev/rentcar/assets/60119368/dafbc21a-d50c-41fe-8ebc-99f7f8c24e16">

<img width="573" alt="2" src="https://github.com/dongjundev/rentcar/assets/60119368/b7e6f619-9f48-4cb6-8e38-b3761ae92064">

<img width="921" alt="3" src="https://github.com/dongjundev/rentcar/assets/60119368/8afaac7a-a86f-405c-be4a-c3fffbc10146">



## 분산 데이터 프로젝션 - CQRS
<img width="1127" alt="1" src="https://github.com/dongjundev/rentcar/assets/60119368/ba7a77d1-58e4-46be-8cf6-a2f239546bda">

<img width="1127" alt="2" src="https://github.com/dongjundev/rentcar/assets/60119368/c41eeda7-87da-4c6f-be88-f62cf5018066">

<img width="1045" alt="3" src="https://github.com/dongjundev/rentcar/assets/60119368/222e28b0-6428-4c68-9ae6-637bb5afbb7f">


## 클라우드 배포 - Container 운영
<img width="1219" alt="1" src="https://github.com/dongjundev/rentcar/assets/60119368/793ebe06-6d1e-4b52-a3f0-57ffcc4535a3">


## 컨테이너 자동확장 - HPA
<img width="515" alt="1" src="https://github.com/dongjundev/rentcar/assets/60119368/35b53f96-92c9-4120-96a1-5b3729c30130"><br>
<img width="445" alt="2" src="https://github.com/dongjundev/rentcar/assets/60119368/a2d95bd7-3661-47c7-997f-a71b76807252">
<img width="567" alt="3" src="https://github.com/dongjundev/rentcar/assets/60119368/c0941db7-e881-4d1f-a136-2ee60e641ccc">




## 컨테이너로부터 환경분리 - ConfigMap/Secret
<img width="562" alt="1" src="https://github.com/dongjundev/rentcar/assets/60119368/6daa0d5e-7d19-46d5-973d-dd594abd1d2b">

<img width="412" alt="2" src="https://github.com/dongjundev/rentcar/assets/60119368/49ba3e69-88a5-4610-8c75-385413b0054e">
<img width="943" alt="스크린샷 2024-04-04 오후 11 15 19" src="https://github.com/dongjundev/rentcar/assets/60119368/e5536d23-39d9-492e-8ee3-162f1a5da0f3">

<img width="1000" alt="3" src="https://github.com/dongjundev/rentcar/assets/60119368/cb4d2b60-03b7-4285-9f9d-2b39a8e5ea28">


## 클라우드스토리지 활용 - PVC

<img width="420" alt="image" src="https://github.com/dongjundev/rentcar/assets/60119368/197560da-2251-490b-ad7f-9a97440c1f45"> <br>

<img width="558" alt="1" src="https://github.com/dongjundev/rentcar/assets/60119368/2fe0ac45-a1d8-4750-830e-22e2b16a6d00">

<img width="1192" alt="2" src="https://github.com/dongjundev/rentcar/assets/60119368/5a390b3e-b4e2-4598-a94b-f95adfddd81d">


## 셀프 힐링/무정지 배포 - Liveness/Rediness Probe
<img width="583" alt="1" src="https://github.com/dongjundev/rentcar/assets/60119368/edef300c-7d68-4062-a346-2fa581117d60">

#비정상<br>
<img width="501" alt="2" src="https://github.com/dongjundev/rentcar/assets/60119368/5b61a51e-32b8-4c6d-938d-bcdd595541a3">


## 서비스 메쉬 응용 - Mesh
<img width="1141" alt="1" src="https://github.com/dongjundev/rentcar/assets/60119368/2ac95607-2a98-4edc-82d5-c597720191ed">
#reserve에만 적용<br>
#kubectl apply -f <(istioctl kube-inject -f reserve/kubernetes/deployment.yaml)
<img width="501" alt="2" src="https://github.com/dongjundev/rentcar/assets/60119368/874b6fc5-903a-4772-a82f-bcaf523d2474">



## 통합 모니터링 - Loggregation/Monitoring
<img width="1524" alt="1" src="https://github.com/dongjundev/rentcar/assets/60119368/66f76c8c-5814-4ab8-b727-b57a0f426a25">
<img width="1436" alt="2" src="https://github.com/dongjundev/rentcar/assets/60119368/946ab431-e58a-4703-8129-b5f3b830f57d">

