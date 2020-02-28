pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        script {
          def mvnHome = tool name:'maven-3.3.9', type: 'maven'
          powershell(script: "'${mvnHome}\\bin\\mvn.cmd' clean test package", encoding: 'UTF-8', label: ' build')
        }

      }
    }

  }
}