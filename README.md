

Steps:------------> 
1) Build FE react js app
   docker build -t frontend . 
   Command from frontend directory, to build frontend image
2) Build BE spring boot app
   docker build -t backend .
   Command from backend directory, to build backend image
   to run stand alone just run docker image as container or docker compose
   Docker compose:->
    docker-compose -f docker-compose-fe_be.yaml up

3) Docker desktop should have kubernetes enabled
   execute k8s-be-service.yaml for creating BE service
   execute k8s-be-deployment.yaml for creating BE deployment
4) execute k8s-fe-service.yaml for creating FE service
   execute k8s-fe-deployment.yaml for creating FE deployment

Services:----------> For FE: LoadBalancer For BE: ClusterIP/NodePort/LoadBalancer
1) ClusterIP: Communication allowed only within cluster
   provide clusterIP: 10.104.24.165 
   and also do below to forward port to external:host
   kubectl port-forward deployment/be-deploy 8080:8080
   FE url: 'http://localhost:8080 /api/version_1/customers'

2) NodePort: Communication allowed to node from outside world
   type: NodePort
   NodePort: 30008
   IP will be of machine itself
   FE url: 'http://192.168.15.5:30008/api/version_1/customers'
   
3) LoadBalancer: Communication allowed to cluster from outside world
   type: LoadBalancer
   

---------------- Kubectl commands
kubectl cluster-info
kubectl get nodes -n my-namespace -owide
kubectl get deployments -owide
kubectl get services -owide
kubectl get pods
kubectl get svc <NAME>

kubectl describe svc <NAME>

kubectl apply -f xxx.yaml [service, deployment, pod etc]

kubectl logs <POD_NAME>

https://fullstackwithpr.hashnode.dev/crud-application-tutorial-using-mysql-spring-boot-react-hooks-and-docker-part-1


https://fullstackwithpr.hashnode.dev/crud-application-tutorial-using-mysql-spring-boot-react-hooks-and-docker-part-2
