def call(String ProjectName, String ImageTag, String DockerHubUser) {
  def imageName = "${DockerHubUser}/${ProjectName}:${ImageTag}"

  def exitStatus = sh(script: "docker build -t ${imageName} .", returnStatus: true)

  if (exitStatus != 0) {
    echo "ERROR: Docker build failed with exit status ${exitStatus}."
    }else {
     echo "Docker build successful"
    } 
}
