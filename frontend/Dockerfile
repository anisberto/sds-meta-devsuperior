FROM node:16.16.0
ENV PATH /app/node_modules/.bin:$PATH

RUN npm install react-scripts@3.3.1 -g --silent

WORKDIR /app
COPY package.json /app/package.json 
EXPOSE 808
CMD ["npm", "run","dev"]