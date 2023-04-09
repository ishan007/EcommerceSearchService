pipeline {

    agent any
    tools {
            maven 'maven'
        }

    stages{
        stage('Build'){
            steps{
                echo '---------- BUILD STAGE STARTED --------------'
                sh '${bin}/kubectl apply -f k8s/namespace.yml'
                sh 'mvn install'
                sh '${bin}/docker build -t i-searchservice:latest -f docker/Dockerfile .'
                sh '${bin}/docker tag i-searchservice:latest ishangaurav/i-searchservice:latest'
                sh '${bin}/docker push ishangaurav/i-searchservice:latest'
                sh '${bin}/kubectl apply -f k8s/deployment.yml'
                echo '---------- BUILD STAGE FINISHED --------------'
            }
        }
    }

}