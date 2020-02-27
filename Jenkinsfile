pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        powershell(script: 'C:\\dev\\tools\\apache-maven-3.6.3\\bin\\mvn.cmd clean install  -Dmaven.test.skip=false -Dlicense.skip=true', encoding: 'UTF-8', label: ' build')
      }
    }

  }
}