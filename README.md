# 

## Model
www.msaez.io/#/111743282/storming/990762cbd2f8a9b1c8d9d48f658ce645

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

- authormanage
- writingmangaement
- aimanagement
- bookmanagement
- user
- pointmanagement
- BoundedContext2063


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- authormanage
```
 http :8088/authors authorId="authorId"email="email"authorName="authorName"portfolioUrl="portfolioUrl"masterpiece="masterpiece"isApproved="isApproved"createdAt="createdAt"updatedAt="updatedAt"
```
- writingmangaement
```
 http :8088/writings writingId="writingId"authorId="authorId"authorName="authorName"title="title"content="content"aiGenre="aiGenre"aiCoverUrl="aiCoverUrl"aiSummary="aiSummary"createdAt="createdAt"modifiedAt="modifiedAt"status="status"
```
- aimanagement
```
 http :8088/coverDesigns coverId="coverId"writingId="writingId"authorId="authorId"penName="penName"content="content"imageUrl="imageUrl"generatedAt="generatedAt"
 http :8088/contentAnalyzers contentAnalyzerId="contentAnalyzerId"writingId="writingId"authorId="authorId"aiSummary="aiSummary"aiGenre="aiGenre"
```
- bookmanagement
```
 http :8088/books bookId="bookId"authorName="authorName"authorId="authorId"genre="genre"summary="summary"coverUrl="coverUrl"price="price"content="content"publishedDate="publishedDate"purchaseCount="purchaseCount"subscriptionCount="subscriptionCount"totalReadCount="totalReadCount"isBestSeller="isBestSeller"
```
- user
```
 http :8088/users userId="userId"loginId="loginId"password="password"name="name"isKt="isKt"isSubscribed="isSubscribed"subscribedAt="subscribedAt"subscriptionEndAt="subscriptionEndAt"
 http :8088/subscriptions subscriptionId="subscriptionId"bookId="bookId"startedAt="startedAt"accessType="accessType"bookPrice="bookPrice"
```
- pointmanagement
```
 http :8088/points pointId="pointId"userId="userId"balance="balance"lastUpdatedAt="lastUpdatedAt"totalCharged="totalCharged"totalUsed="totalUsed"
```
- BoundedContext2063
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
