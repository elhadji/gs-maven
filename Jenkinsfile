pipeline {
	agent any
    tools {
        maven 'maven'
        jdk 'jdk'
		nodejs 'nodejs'
    }
	stages {
		stage("Initialize ...") {
			steps {
                sh '''
                    echo "PATH = ${PATH}"
                '''
            }
		}
		stage ('Build') {
			steps {
                sh 'mvn -Dmaven.test.failure.ignore=true install' 
            }
		}
		stage("Smoke Test"){
			steps{
				sh 'mvn test'
			}
		}
		// stage("Sonar analysis"){
		// 	steps{
		// 		echo "====++++Sonar analysis++++===="
		// 		sh 'git -Dsonar.host.url=http://localhost:9000 -Dsonar.login=b2ca8da41bec62d8cad88de1eccaaacea13b9341'
			
		// 	timeout(time: 10, unit: 'MINUTES') {
        //             waitForQualityGate abortPipeline: true
        //         }
		// 	}
		// }
		stage('Sonar analysis') {
            environment {
                scannerHome = tool 'SonarScanner'
            }
            steps {
                withSonarQubeEnv('SonarServer') {
                    sh 'mvn clean package sonar:sonar'
                }
            }
        }
		stage("Quality Gate 1") {
            steps {
				timeout(time: 10, unit: 'MINUTES') {
					waitForQualityGate(webhookSecretId: 'b2ca8da41bec62d8cad88de1eccaaacea13b9341') 
                    //waitForQualityGate abortPipeline: true
                }
            }
        }
		stage("Deploy"){
			steps{
				echo "====++++Deploy++++===="
			}
		}
	}
}
