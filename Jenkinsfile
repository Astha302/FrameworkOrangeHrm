pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/Astha302/FrameworkOrangeHrm.git'
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '**/test-output/**', allowEmptyArchive: true
            archiveArtifacts artifacts: '**/extentreport/**', allowEmptyArchive: true
        }
    }
}
