pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        script {
                def mvnHome = tool 'Maven 3.6.3'
        		powershell(script: "'${mvnHome}\\bin\\mvn.cmd' clean test package", encoding: 'UTF-8', label: ' build')
        }
      }
    }

  }
}