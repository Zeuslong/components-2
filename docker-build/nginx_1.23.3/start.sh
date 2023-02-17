docker run -d --name nginx \
  -p 80:80 \
  -v ./conf.d:/etc/nginx/conf.d \
  nginx:1.23.3
