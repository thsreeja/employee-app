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
                echo 'Deploying Spring Boot application'

                // Stop app running on 8080 (ignore if none exists)
                powershell '''
                $procIds = netstat -ano | Select-String ":8080" | ForEach-Object {
                    ($_ -split "\\s+")[-1]
                }

                foreach ($procId in $procIds) {
                    Write-Host "Stopping PID $procId"
                    taskkill /PID $procId /F
                }
                '''

                // Start app in a fully detached background process
                powershell '''
                Start-Process java -ArgumentList "-jar build\\libs\\*.jar" -NoNewWindow
                '''
            }
        }
    }
}