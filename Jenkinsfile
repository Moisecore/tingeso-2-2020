pipeline {
    agent any
    environment {
        DOCKER_IMAGE_NAME = "moisecore/tingeso-2-2020"
    }
    stages {
        stage('Build') {	
             steps {	
                echo 'Running build automation'
                sh 'chmod +x ./webapp/gradlew'	
                sh './webapp/gradlew build'
            }
        }
	stage('Test') {
		steps {
			echo 'Testing the application...'
			sh './webapp/gradlew tasks'
			sh './webapp/gradlew test --scan'
		}

		post {
			always {
				junit '**/webapp/build/test-results/test/TEST-*.xml'
			}
		}

	}
        stage('Build Docker Image') {
            when {
                branch 'master'
            }
            steps {
                script {
                    app = docker.build(DOCKER_IMAGE_NAME)
                }
            }
        }
        stage('Push Docker Image') {
            when {
                branch 'master'
            }
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'docker_hub_login') {
                        app.push("${env.BUILD_NUMBER}")
                        app.push("latest")
                    }
                }
            }
        }
        stage('DeployToProduction') {
            when {
                branch 'master'
            }
            steps {
                milestone(1)
                kubernetesDeploy(
                    kubeconfigId: 'kubeconfig',
                    configs: 'k8s_svc_deploy.yaml',
                    enableConfigSubstitution: true
                )
            }
        }
    }
}
