def call(ip,warName,credTd){
  sshagent(["${credId}"]) {
      sh "scp -o StrictHostKeyChecking=no target/${warName}-war ec2-user@${ip}:/opt/tomcat9/webapps"
      sh "ssh ec2-user@${ip} /opt/tomcat9/bin/shutdown.sh"
      sh "ssh ec2-user@${ip} /opt/tomcat9/bin/startup.sh"
  }
}
