pipeline {
    agent any 
    environment {
        DOCKER_IMAGE_NAME = "moisecore/tingeso-2-2020"
    }
    stages {
        stage('Build') {
             steps {	
                echo 'Running build automation...'
                sh 'chmod +x ./webapp/gradlew'
                sh './webapp/gradlew build'
		sh 'cd webapp/build/libs | ls'
            }
        }
	stage('Test') {
		steps {
			echo 'Testing the application...'
			sh './webapp/gradlew test -p ./webapp'
			sh 'cd webapp/build/libs | ls'
		}

		post {
			always {
				junit '**/webapp/build/test-results/test/TEST-*.xml'
			}
		}

	}
        stage('Build Docker Image') {
            steps {
		script {
                    app = docker.build(DOCKER_IMAGE_NAME)
		}
            }
        }
        stage('Push Docker Image') {
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
            steps {
                milestone(1)
                kubernetesDeploy(
                    kubeconfigId: 'kubeconfig',
                    configs: 'k8s_deploy.yaml',
                    enableConfigSubstitution: true
                )
            }
        }
    }
}
