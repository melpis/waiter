FROM node:10.13.0-alpine
RUN mkdir -p /app/user/
COPY node/* /app/
COPY user/dist/ /app/user/
WORKDIR /app
RUN npm install --only=production
EXPOSE 80
CMD [ "npm", "start" ]
