def getHost(){
    def remote = [:]
    remote.name = 'mysql'
    remote.host = '192.168.8.108'
    remote.user = 'root'
    remote.port = 22
    remote.password = 'qweasd'
    remote.allowAnyHosts = true
    return remote
}
pipeline {
    agent any
    environment{
        def server = ''
    }   
    stages {
        stage('init-server'){
            steps {
                script {                 
                   server = getHost()                                   
                }
            }
        }
        stage('use'){
            steps {
                script {
                  sshCommand remote: server, command: """                 
                  if test ! -d aaa/ccc ;then mkdir -p aaa/ccc;fi;cd aaa/ccc;rm -rf ./*;echo 'aa' > aa.log
                  """
                }
            }
        }
    }
}