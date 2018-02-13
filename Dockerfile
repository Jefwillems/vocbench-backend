FROM redhat-openjdk18-openshift:latest

COPY . /opt/app-root/src

# RUN bash /opt/app-src/src/bin/st_server_run