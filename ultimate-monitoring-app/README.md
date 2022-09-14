# ultimate-monitoring Documentation

## Setup

1. Change the "targets" IP Address to your local IP address (localhost will not work)
2. Open up IntelliJ Terminal and type "docker compose up -d"
3. Run the application

## Available End-Points

* http://localhost:8080/swagger-ui/index.html#/ - HTTP End-Point Documentation

* http://host.docker.internal:9090 - Prometheus Server
* http://host.docker.internal:3000 - Pre-Configured Grafana Server

* http://localhost:8080/coffees - 30 random coffees
* http://localhost:8080/addresses - 30 random addresses
* http://localhost:8080/vehicles - 30 random vehicles
* http://localhost:8080/ - home page with buttons linked to specific HTTP Endpoints

## Decisions And Thoughts

prometheus is an open-source monitoring tool (time series database - stores sequences of flotaing point numbers together with timestamp)
prometheus intention is that applications need to provide the metrics - detailed data
taking a look at promotheus and following the getting started guide to geta better understanding of what promotheus is and
what its purpouse is.
https://prometheus.io/docs/introduction/first_steps/

## Application Setup Process

Create Spring boot application
Followed this guide: https://attacomsian.com/blog/http-requests-resttemplate-spring-boot
Split up into service and controller layer for best practice
Read this guide to get a better understanding: https://docs.spring.io/spring-metrics/docs/current/public/prometheus
Set up docker compose for Prometheus and Grafana

(In prometheus configuration file i had to change localhost to my ip address as localhost was not visible for prometheus as
it's running in a docker container.)

Explanation:
The localhost of one container is not the localhost of another container, even if you published the port to the host – you can't reach the Prometheus container or the host using localhost from the Grafana container.
You need to use the IP address of the Prometheus container, or the hostname if you are using Docker Compose.


## Grafana

My goal was to have an already configured grafana server available for the user after he pulls the git directory.
The goal was achieved using the grafana provisioning feature. The only thing that the user has to change is his ip address
for prometheus to pull data from, the rest is done automatically. The grafana has also pre configured dashboards with various metrics
being displayed.







