FROM node:latest

RUN apt-get update 

WORKDIR /app

COPY . .

RUN npm install

EXPOSE 3000

CMD ["node","app.js"]

