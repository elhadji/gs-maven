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
		stage("Sonar analysis"){
			steps{
				echo "====++++Sonar analysis++++===="
				sh 'mvn sonar:sonar'
			}
		}
		stage("Deploy"){
			steps{
				echo "====++++Deploy++++===="
			}
		}
	}
}
