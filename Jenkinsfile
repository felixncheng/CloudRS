// 需要在jenkins的Credentials设置中配置docker-hub-creds参数

pipeline {
    agent any
    environment {
        DOCKER_HUB_CREDS = credentials('docker-hub-creds')
        GIT_TAG = sh(returnStdout: true,script: 'git describe --tags --always').trim()
        ECS_CREDS = credentials('ecs-creds')
    }

    parameters {
        string(name: 'APP_NAME', description: '需要重新部署的服务名')
    }

    def remote = [:]
      remote.name = 'test'
      remote.host = 'test.domain.com'
      remote.user = 'root'
      remote.password = 'password'
      remote.allowAnyHosts = true
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
               sh 'bash ./jenkins/scripts/build.sh'
            }
        }

        stage('deploy'){
            steps {
                sshScript remote: remote,script: "deploy.sh"
            }
        }
    }
}
