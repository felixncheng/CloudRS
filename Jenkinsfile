pipeline {
  agent {
    docker {
      image 'maven:3-alpine'
      args '-v /root/.m2:/root/.m2'
    }

  }
  stages {
    stage('Test') {
      steps {
        echo 'Testing'
      }
    }
    stage('Deploy - Staging') {
      steps {
        echo 'Staging'
      }
    }
    stage('Sanity check') {
      steps {
        input 'Does the staging environment look ok?'
      }
    }
    stage('Deploy - Production') {
      steps {
        sh 'chmod +x ./jenkins/scripts/deliver.sh'
        sh './jenkins/scripts/deliver.sh'
      }
    }
  }
}