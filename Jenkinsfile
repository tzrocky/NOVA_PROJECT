pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        powershell(script: 'mvn clean install -Dlicense.skip=true', encoding: 'UTF-8', label: ' build')
      }
    }

  }
}