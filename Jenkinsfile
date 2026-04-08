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

        stage('Deploy') {
            steps {
                echo 'Starting deployment of Spring Boot application'

                // Stop any process running on port 8080 (ignore errors if none found)
                bat '''
                for /f "tokens=5" %%a in ('netstat -aon ^| findstr :8080') do taskkill /PID %%a /F
                '''

                // Start the Spring Boot JAR in background
                bat '''
                start /B java -jar build\\libs\\*.jar
                '''
            }
        }
    }
}