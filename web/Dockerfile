
FROM  node:12.7-alpine AS build 
WORKDIR /usr/src/app
COPY ./src/main/web/package.json ./src/main/web/package-lock.json ./
RUN npm install
COPY ./src/main/web/ .
RUN npm run build
### STAGE 2: Run ###
FROM nginx:1.17.1-alpine
COPY ./src/main/web/nginx.conf /etc/nginx/nginx.conf
COPY --from=build /usr/src/app/dist/creditapp-web /usr/share/nginx/html