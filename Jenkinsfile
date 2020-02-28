pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        script {
          powershell(script: def mvnHome = tool name:'maven-3.6.3', type: 'maven' "'${mvnHome}\\bin\\mvn.cmd' clean test package", encoding: 'UTF-8', label: ' build')
        }

      }
    }

  }
}