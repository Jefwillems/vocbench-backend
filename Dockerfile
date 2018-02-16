FROM registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift

RUN addgroup -g 433 sksuser && \ 
    adduser -u 431 -G sksuser -h /home/sksuser -s /sbin/nologin -g "Skosmos vocbench user" sksuser -D && \
    mkdir -p /home/sksuser && \ 
    chown -R sksuser:sksuser /home/sksuser

COPY . /opt/
#RUN chmod +x /opt/vocbench-backup/bin/st_server_run
USER sksuser
CMD ["sh /opt/bin/st_server_run server"]
