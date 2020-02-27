pipeline {
  agent any
  PATH = "C:\\Program Files\\Git\\usr\\bin;C:\\Program Files\\Git\\bin;${env.PATH}"
  stages {
    stage('Build') {
      steps {
        sh 'mvn clean install -Dlicense.skip=true'
      }
    }

  }
}
