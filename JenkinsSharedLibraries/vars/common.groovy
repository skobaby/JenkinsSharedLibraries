def call(String stageName){
  
  if ("${stageName}" == "Build")
     {
       sh "mvn clean package"
     }
  else if ("${stageName}" == "SonarQube Report")
     {
       sh "mvn sonar:sonar"
     }
  else if ("${stageName}" == "Upload Into Nexus")
     {
       sh "mvn deploy"
     }
  else if ("${stageName}" == "Deploy To UAT")
  {
    sh "echo 'deploy to UAT'  "
    deploy adapters: [tomcat8(credentialsId: 'Tomcat-credentials', path: '', url: 'http://172.31.10.131:8080')], contextPath: null, onFailure: false, war: 'target/*war'
  }
}

