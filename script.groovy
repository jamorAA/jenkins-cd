def buildJar() {
//    echo "building the application..."
//    sh "mvn clean package"
}

def buildImage() {
//    echo "building the docker image..."
//    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
//        sh "docker build -t jamoraa/demo-java-maven-app:1.1.0 ."
//        sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin"
//        sh "docker push jamoraa/demo-java-maven-app:1.1.0"
//    }
}

def deployApp() {
    echo "deploying the application..."
    sshagent(['ssh-key']) {
        def dockerCmd = "docker run -d -p 8080:8080 --name java-maven-app jamoraa/demo-java-maven-app:1.1.0"
        sh "ssh -o StrictHostKeyChecking=no morant@158.160.226.219 $dockerCmd"
    }
}
return this
