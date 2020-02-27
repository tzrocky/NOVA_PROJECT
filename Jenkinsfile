pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        powershell(script: 'C:\\dev\\tools\\apache-maven-3.6.3\\bin\\mvn.cmd clean test package-DJAVA_HOME="C:\\Program Files\\Java\\jdk1.8.0_161"', encoding: 'UTF-8', label: ' build')
      }
    }

  }
}