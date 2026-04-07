pipeline {
    agent any

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/thsreeja/employee-app.git'
            }
        }

        stage('Build') {
            steps {
                bat '.\\gradlew.bat clean build'
            }
        }

        stage('Test') {
            steps {
                bat '.\\gradlew.bat test'
            }
        }

    }
}