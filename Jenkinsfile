pipeline {
    environment {
      registry = "13465506/esprit"
      registryCredential = 'dockerhub'
      dockerImage = ''
      DOCKERHUB_CREDENTIALS=credentials('dockerhub')
    }
    agent any
    stages {
        stage ('GIT') {
            steps {
                echo "Getting Project from Git";
                git "https://github.com/achrafxor/devopsesprit"
            }
        }
        stage ('build no push') {
            steps {
                echo "MVN PACKAGE AND DEPLOY TO nexus";
                sh '/usr/local/apache-maven-3.5.0/bin/mvn clean package  -DskipTests=true -e -U --batch-mode --fail-at-end --show-version -DinstallAtEnd=true -DdeployAtEnd=true' ;
            }
        }
        stage ('MVN TEST') {
            steps {
                echo "Maven Test JUnit";
                sh '/usr/local/apache-maven-3.5.0/bin/mvn test' ;
            }
        }


        stage ('deploy to nexus') {
            steps {
                echo "MVN PACKAGE AND DEPLOY TO nexus";
                sh '/usr/local/apache-maven-3.5.0/bin/mvn clean deploy -DskipTests=true -e -U --batch-mode --fail-at-end --show-version -DinstallAtEnd=true -DdeployAtEnd=true' ;
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

        stage ('docker PUSH') {
            steps {
                echo "pushing to docker hub";
                script {
                     docker.withRegistry( 'registry-1.docker.io/v1 ', DOCKERHUB_CREDENTIALS ) {
                       dockerImage.push()
                     }
                }
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