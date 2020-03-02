pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        powershell(script: 'C:\\dev\\tools\\apache-maven-3.6.3\\bin\\mvn.cmd clean test package', encoding: 'UTF-8', label: 'buld', returnStatus: true)
      }
    }
    
    stage('deploy: stg') {
        when {
          allOf {
            branch 'develop'
            expression { return currentBuild.result == null || currentBuild.result == 'SUCCESS' }
          }
        }
        steps {
          notifyBitbucket('INPROGRESS', env.STAGE_NAME, env.STAGE_NAME)
          releaseHeroku(pipelineParams.stagingRepositoryUrl, 'staging')
        }
        post {
          success {
            notifySuccess(env.STAGE_NAME, pipelineParams.slackNotificationChannel)
          }
          failure {
            notifyFailure(env.STAGE_NAME, pipelineParams.slackNotificationChannel)
          }
        }
      }

  }
}
