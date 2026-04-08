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

        // Stop existing application on port 8080 (ignore if none)
        bat '''
        for /f "tokens=5" %%a in ('netstat -aon ^| findstr :8080') do (
            echo Stopping process %%a
            taskkill /PID %%a /F
        )
        '''

        // Start application in a fully detached background process
        bat '''
        start "" /B cmd /c java -jar build\\libs\\*.jar
        '''
    		}
	  }

    }
}