node{
    stage('SCM Checkout'){
        git credentialsId: 'git-creds', url: 'https://github.com/imfarhad/myrestapp'
    }

    stage('MVN package'){
    	sh 'mvn clean package'
    }

    stage('Build Docker Image'){
    	sh 'docker build . -t farhadtx/myrestapp:1.0.1'
    }
    
    stage('Push Docker Image'){
        withCredentials([string(credentialsId: 'docker-pwd', variable: 'dockerHubPassword')]) {
            sh "docker login -u farhadtx -p ${dockerHubPassword}"
        }
        
    	sh 'docker push farhadtx/myrestapp:1.0.1'
    }

      stage ('K8S Deploy') {

                kubernetesDeploy(
                    configs: 'deployment.yaml',
                    kubeconfigId: 'K8s',
                    enableConfigSubstitution: true
                    )
        }
    
}
