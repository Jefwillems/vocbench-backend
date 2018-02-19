FROM registry.access.redhat.com/rhel7

RUN groupadd -g 433 sksuser && \ 
    adduser -u 431 -G sksuser -b /home/sksuser -s /sbin/nologin -D && \
    mkdir -p /home/sksuser && \ 
    chown -R sksuser:sksuser /home/sksuser

COPY . /opt/
#RUN chmod +x /opt/vocbench-backup/bin/st_server_run
USER sksuser
CMD ["sh /opt/bin/st_server_run server"]
