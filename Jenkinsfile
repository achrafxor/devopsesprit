pipeline {
    agent any

    stages {
        stage ('GIT') {
            steps {
                echo "Getting Project from Git";
                sh 'cd /var/lib/jenkins/workspace/springProjectPipeline@2'
                sh 'git pull'
                git "https://github.com/achrafxor/devopsespritsex"
            }
        }
        stage ('MVN CLEAN') {
            steps {
                echo "Maven Clean";
                sh '/usr/local/apache-maven-3.5.0/bin/mvn clean';
            }
        }
        stage ('MVN TEST2') {
            steps {
                echo "Maven Test JUnit";
                sh '/usr/local/apache-maven-3.5.0/bin/mvn test';
            }
        }
    }
}