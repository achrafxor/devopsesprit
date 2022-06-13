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
                sh 'mvn clean';
            }
        }
        stage ('MVN TEST') {
            steps {
                echo "Maven Test JUnit";
                sh 'mvn test';
            }
        }
    }
}