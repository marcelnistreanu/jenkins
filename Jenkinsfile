pipeline {
    agent any
    stages {
        stage('Clone'){
            steps{
                git branch:'main', url: 'https://github.com/marcelnistreanu/jenkins'
            }
        }
        stage('Build') {
            steps {
              bat '''
             cd spring/
             docker build -t spring-image .
             cd ..
             cd angular/
             docker build -t angular-image .
             cd database
             docker build -t postgres-image .
             cd ../..
              '''
            }
        }
    stage('Build and Run Docker Compose') {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com/', 'dockerhub-creds') {
                        bat 'docker-compose up -d'
                    }
                }
            }
        }
    }
}