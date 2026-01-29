pipeline {
    agent any

    stages {

        stage('Build & Test') {
            steps {
                bat 'mvn -version'
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
