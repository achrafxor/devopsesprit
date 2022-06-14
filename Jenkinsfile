pipeline {
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
                sh '/usr/local/apache-maven-3.5.0/bin/mvn test';
            }
        }
    }
}