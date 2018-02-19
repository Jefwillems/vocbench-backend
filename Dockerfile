FROM registry.access.redhat.com/rhel7

#RUN groupadd -g 433 sksuser && \ 
#    adduser -D -u 431 -G sksuser -M -s /sbin/nologin -g "sksuser" sksuser 
# mkdir -p /home/sksuser && \ 
# chown -R sksuser:sksuser /home/sksuser
ENV JAVA_VERSION 8u31
ENV BUILD_VERSION b13
RUN subscription-manager attach --auto
# Upgrading system
RUN yum -y install wget

# Downloading Java
RUN wget --no-cookies --no-check-certificate --header "Cookie: oraclelicense=accept-securebackup-cookie" "http://download.oracle.com/otn-pub/java/jdk/$JAVA_VERSION-$BUILD_VERSION/jdk-$JAVA_VERSION-linux-x64.rpm" -O /tmp/jdk-8-linux-x64.rpm

RUN yum -y install /tmp/jdk-8-linux-x64.rpm

RUN alternatives --install /usr/bin/java jar /usr/java/latest/bin/java 200000
RUN alternatives --install /usr/bin/javaws javaws /usr/java/latest/bin/javaws 200000
RUN alternatives --install /usr/bin/javac javac /usr/java/latest/bin/javac 200000

ENV JAVA_HOME /usr/java/latest

COPY . /opt/
#RUN chmod +x /opt/vocbench-backup/bin/st_server_run
#USER sksuser
CMD ["sh /opt/bin/st_server_run server"]
