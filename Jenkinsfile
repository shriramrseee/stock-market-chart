pipeline {
    agent any
    tools {
        maven 'M3'
        jdk 'JDK'
        nodejs 'NODE'
    }
    stages {
         stage('BuildBackend') {
            steps {
                git 'https://github.com/shriramrseee/stock-market-chart.git'
                dir('chart') {
                    bat 'mvn -B -DskipTests clean package -P core,user'
                }
            }
        }
        stage('BuildEureka') {
            steps {
                dir('eureka-server') {
                    bat 'mvn -B -DskipTests clean package'
                }
            }
        }
        stage('BuildFrontend') {
            steps {
                dir('frontend/stock-market-chart') {
                    bat "npm install"
                    bat "npm run-script build"
                }
            }
        }
    }
}
