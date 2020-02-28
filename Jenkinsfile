pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        powershell(script: '\'C:\\\\dev\\\\tools\\\\apache-maven-3.6.3\\\\bin\\\\mvn.cmd\' clean test package', encoding: 'UTF-8', label: 'buld', returnStatus: true)
      }
    }

  }
}