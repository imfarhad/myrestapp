node{
    stage('SCM Checkout'){
        git credentialsId: 'git-creds', url: 'https://github.com/imfarhad/myrestapp'
    }

    stage('MVN package'){
    	sh 'mvn clean package'
    }

    stage('Build Docker Image'){
    	sh 'docker build . -t farhadtx/myrestapp:${BUILD_NUMBER}'
    }
    
    stage('Push Docker Image'){
        withCredentials([string(credentialsId: 'docker-pwd', variable: 'dockerHubPassword')]) {
            sh "docker login -u farhadtx -p ${dockerHubPassword}"
        }
        
    	sh 'docker push farhadtx/myrestapp:${BUILD_NUMBER}'
    	sh "sed -i 's/#BUILD_NUMBER/${BUILD_NUMBER}/g' deployment.yaml"
    }

      stage ('K8S Deploy') {

                kubernetesDeploy(
                    configs: 'deployment.yaml',
                    kubeconfigId: 'K8s',
                    enableConfigSubstitution: true
                    )
        }
    
}
