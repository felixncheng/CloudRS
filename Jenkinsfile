// 需要在jenkins的Credentials设置中配置docker-hub-creds参数
pipeline {
    agent any
    environment {
        DOCKER_HUB_CREDS = credentials('docker-hub-creds')
        GIT_TAG = sh(returnStdout: true,script: 'git describe --tags --always').trim()
    }
    stages {
        stage('Maven Build') {
            when { expression { env.GIT_TAG != null } }
            agent {
                docker {
                    image 'maven:3-jdk-8-alpine'
                    args '-v $HOME/.m2:/root/.m2'
                }
            }
            steps {
                sh 'mvn clean package -Dfile.encoding=UTF-8 -DskipTests=true'
                stash includes: 'target/*.jar', name: 'app'
            }

        }
        stage('Docker Build') {
            when { 
                allOf {
                    expression { env.GIT_TAG != null }
                }
            }
            agent any
            steps {
               sh 'sh ./jenkins/scripts/build.sh'
            }
            
        }
    }
}
