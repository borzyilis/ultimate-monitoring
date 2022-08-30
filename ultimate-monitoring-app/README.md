# ultimate-monitoring Documentation

## Setup

1. Change the "targets" IP Address to your local IP address (localhost will not work)
2. Open up IntelliJ Terminal and type "docker compose up -d"
3. Run the application

## Available End-Points

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

started promotheus with its basic configuration and accessed it at localhost:9090

didn't understand anything im doing so watched a youtube vid https://www.youtube.com/watch?v=jb9j_IYv4cU

Slowly everything starts to make sense

Step 1. Create Spring boot application
followed this guide to
https://attacomsian.com/blog/http-requests-resttemplate-spring-boot

split up into service and controller layer for best practice

read this guide to get a better understanding
https://docs.spring.io/spring-metrics/docs/current/public/prometheus

set up docker compose for Prometheus and Grafana

in prometheus configuration file i had to change localhost to my ip address as localhost was not visible for prometheus as
its running in a docker container. => found an explanation and a better solution to use http://host.docker.internal:port instead of local ip address

explanation:
The localhost of one container is not the localhost of another container, even if you published the port to the host – you can't reach the Prometheus container or the host using localhost from the Grafana container.
You need to use the IP address of the Prometheus container, or the hostname if you are using Docker Compose.


grafana set up was pretty simple
added the datasource http://host.docker.internal:9090
then i set up 2 simple dashboards showing the application status using the up{application="$application",instance="$instance"} query
and requests per second using following query increase(http_server_requests_seconds_count{application="$application", instance="$instance"}[1m])

added my own metric request_counter which increases every time a request is sent to a specific endpoint.






