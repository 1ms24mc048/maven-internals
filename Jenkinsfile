pipeline {
  agent any

  environment {
    DOCKERHUB_CREDENTIALS = credentials('dockerhubID')
    IMAGE_NAME = "1ms24mc048/my_webapp"
  }

  triggers {
    cron('* * * * *')
  }
  
  stages {
    stage('Checkout') {
      steps {
        git(
          url: 'https://github.com/1ms24mc048/maven-internals',
          branch: 'main',
          credentialsId: 'dockerhubID'
        )
      }
    }
    
    stage('Build Maven app') {
      steps {
        sh 'mvn clean packag -DskipTests' ;
      }
    }


    stage('Build Docker Image') {
      steps {
        script {
          dockerImage = docker.build("${IMAGE_NAME}:latest")
        }
      }
    }

    stage('Push to Docker Hub') {
      steps {
        script {
          docker.withRegistry('https://index.docker.io/v1/', 'dockerhubID') {
            dockerImage.push()
          }
        }
      }
    }
  }

  post {
    always {
      deleteDir()
    }
    success {
      echo 'Pipeline succeeded!'
    }
    failure {
      echo 'Pipeline failed!'
    }
  }
}
