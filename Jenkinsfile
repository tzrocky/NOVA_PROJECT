pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'mvn clean install -Dlicense.skip=true'
        powershell(script: 'mvn clean install -Dlicense.skip=true', encoding: 'UTF-8', label: ' build')
      }
    }

  }
}