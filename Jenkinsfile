pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        powershell(script: "${MAVEN_HOME}\\bin\\mvn.cmd" clean test package, encoding: 'UTF-8', label: ' build')
      }
    }

  }
}