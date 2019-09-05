// 需要在jenkins的Credentials设置中配置docker-hub-creds参数

def getHost(){
    def remote = [:]
    remote.name = 'mysql'
    remote.host = ${ECS_CREDS_USR}
    remote.user = 'root'
    remote.port = 22
    remote.password = ${ECS_CREDS_PSW}
    remote.allowAnyHosts = true
    return remote
}

pipeline {
    agent any
    environment {
        DOCKER_HUB_CREDS = credentials('docker-hub-creds')
        GIT_TAG = sh(returnStdout: true,script: 'git describe --tags --always').trim()
        ECS_CREDS = credentials('ecs-creds')
        def server = ''
    }

    parameters {
        string(name: 'APP_NAME', description: '需要重新部署的服务名')
    }

    stages {


        stage('init-server'){
                    steps {
                        script {
                           server = getHost()
                    }
            }
        }
        stage('deploy'){
            steps {
                script{
                 sshScript remote: getHost,script: "./jenkins/scripts/deploy.sh"
                }
            }
        }
    }
}
