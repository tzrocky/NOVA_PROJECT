pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        script {
          powershell(script: '"C:\\Program Files\\apache-maven-3.6.3\\bin\\mvn.cmd" clean test package', encoding: 'UTF-8', label: ' build')
        }

      }
    }

  }
}
