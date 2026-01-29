pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'JDK'
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/Astha302/FrameworkOrangeHrm.git'
            }
        }

        stage('Build & Run Tests') {
            steps {
                bat 'mvn clean test'
            }
        }

        stage('Archive Reports') {
            steps {
                archiveArtifacts artifacts: '**/test-output/**', allowEmptyArchive: true
                archiveArtifacts artifacts: '**/extentreport/**', allowEmptyArchive: true
            }
        }
    }
}