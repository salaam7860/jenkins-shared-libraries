def call(String url, String branch) {
  if (!url || !branch) {
    sh "echo ERROR: +++++++++++++++++++ URL AND BRANCH ARE REQUIRED +++++++++++++++++++++++"
    return
  }

  def validBranch = 'main' 
  if (branch != validBranch) {
    sh "echo ERROR: INVALID BRANCH"
    return
  }

  try {
    echo 'This is coping the code.'
    git url: url, branch: branch, credentialsId: 'your-credentials-id'
    echo "The code has been successfully cloned"
  } catch (Exception e) {
    sh 'echo ERROR: Failed to clone repository - ${e.getMessage()}'
  }
      
}
