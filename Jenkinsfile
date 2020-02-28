pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        script {
          def mvnHome = tool name:'maven-3.6.3', type: 'maven'
          powershell(script: "'${mvnHome}\\bin\\mvn.cmd' clean test package", encoding: 'UTF-8', label: ' build')
        }

      }
    }

  }
}