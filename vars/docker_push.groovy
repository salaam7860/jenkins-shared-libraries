def call(String projectName, String imageTag) {
  withCredentials([usernamePassword(credentialsId: "dockerHubCred", passwordVariable: "dockerHubPass", usernameVariable: "dockerHubUser")]) {
    try {
      sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
      sh "docker image tag notes-app:latest ${dockerHubUser}/${projectName}:${imageTag}"
      sh "docker push ${dockerHubUser}/${projectName}:${imageTag}"
    } catch (Exception e) {
      echo 'ERROR: Docker operation failed - ${e.getMessage()}'
    } finally {
      sh "docker logout"
    }
    
  }
  
}
