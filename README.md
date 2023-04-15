

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
   

Commands:-->
.. kubectl apply -f k8s-be-service.yaml
.. kubectl apply -f k8s-be-deployment.yaml
.. kubectl apply -f k8s-fe-service.yaml
.. kubectl apply -f k8s-fe-deployment.yaml


Services:----------> For FE: LoadBalancer For BE: ClusterIP/NodePort/LoadBalancer
1) ClusterIP: Communication allowed only within cluster
   provide clusterIP: 10.104.24.165 
   and also do below to forward port to external:host
   kubectl port-forward deployment/be-deploy 8080:8080
   FE url: 'http://localhost:8080/api/version_1/customers'

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


--------------------------------------- Helm
install from https://helm.sh/docs/intro/install/

.. for FE & BE create charts
helm create be-chart
helm install be-deploy be-chart

helm create fe-chart
helm install fe-deploy fe-chart

kubectl port-forward deployment/be-deploy 8080:8080

and now use app

--------- uninstall app
helm uninstall be-deploy (here app name should be provided)
helm uninstall fe-deploy


----------------------------------- Argocd
https://blog.risingstack.com/argo-cd-kubernetes-tutorial/

this is another tool to provide CD, provide git to deployment to kubernetes cluster.
its via pull based approach rather than push based of other CD tools

Execute below commands:-->

kubectl create namespace argocd
kubectl apply -n argocd -f https://raw.githubusercontent.com/argoproj/argo-cd/stable/manifests/install.yaml

kubectl -n argocd port-forward svc/argocd-server 8080:443
.. This will expose the service on localhost:8080 
go to this url and sign in screen appears
username = admin , for password use below command
kubectl -n argocd get secret argocd-initial-admin-secret -o jsonpath="{.data.password}" | base64 -d

.. now sign in into Argocd






