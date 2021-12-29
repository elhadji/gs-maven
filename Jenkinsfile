pipeline {
	agent any
    tools {
        maven 'maven'
        jdk 'jdk'
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
				echo "====++++executing Smoke Test++++===="
			}
		}
		stage("Sonar analysis"){
			steps{
				echo "====++++Sonar analysis++++===="
			}
		}
		stage("Deploy"){
			steps{
				echo "====++++Deploy++++===="
			}
		}
	}
}
