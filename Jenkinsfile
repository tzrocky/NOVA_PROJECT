pipeline {
  agent any
  tools {
    maven 'M3'
  }
  stages {
    stage('Build') {
      steps {
        powershell(script: 'mvn clean test package', encoding: 'UTF-8', label: ' build')
      }
    }

  }
}