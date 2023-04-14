
FROM node:latest
RUN mkdir -p /src/app
WORKDIR /src/app
COPY microservices/SearchService .
RUN npm install
EXPOSE 3003
CMD [ "npm", "start" ]