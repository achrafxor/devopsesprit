pipeline {
    environment {
      registry = "13465506/esprit"
      registryCredential = '13465506'
      dockerImage = ''
    }
    agent any
    stages {
        stage ('GIT') {
            steps {
                echo "Getting Project from Git";
                git "https://github.com/achrafxor/devopsesprit"
            }
        }
        stage ('MVN CLEAN') {
            steps {
                echo "Maven Clean";
                sh '/usr/local/apache-maven-3.5.0/bin/mvn clean';
            }
        }
        stage ('MVN TEST') {
            steps {
                echo "Maven Test JUnit";
                sh '/usr/local/apache-maven-3.5.0/bin/mvn test' ;
            }
        }
        stage ('MVN PACKAGE AND DEPLOY TO nexus') {
            steps {
                echo "MVN PACKAGE AND DEPLOY TO nexus";
                sh '' ;
            }
        }
        stage ('Docker image build') {
            steps {
                echo "building docker image";
                script {
                  dockerImage = docker.build registry + ":$BUILD_NUMBER"
                }
            }
        }
        stage ('docker push to docker hub') {
            steps {
                echo "MVN PACKAGE AND DEPLOY TO nexus";
                sh '' ;
            }
        }
        stage ('cleaning up') {
            steps {
                echo "MVN PACKAGE AND DEPLOY TO nexus";
                sh '' ;
            }
        }

    }
}