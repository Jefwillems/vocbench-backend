FROM ubuntu:16.04

COPY . /opt/
#RUN chmod +x /opt/vocbench-backup/bin/st_server_run
RUN sh /opt/bin/st_server_run server
