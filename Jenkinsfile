pipeline {
	agent {
		docker {
			image 'maven:3-alpine'
		}
	}
	stages {
		stage('Pull') {
			steps {
				sh 'git pull'
			}
		}
		stage('Build') {
			steps {
				sh 'mvn -B -DskipTests clean package'
			}
		}
		stage('Run') {
			steps {
				sh 'echo Run'
			}
		}
	}
}
