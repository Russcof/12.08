pipeline {
    agent any

    stages {
        stage('Clone') {
            steps {
                // Клонируем репозиторий
                git url: 'https://github.com/Russcof/12.08.git'
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    // Собираем Docker образ
                    sh 'docker build -t j1 .'
                }
            }
        }
        stage('Push Docker Image') {
            steps {
                script {
                    // Пушим Docker образ в реестр
                    sh 'docker tag j1 papaprog/j1'
                    sh 'docker push papaprog/j1'
                }
            }
        }
    }
}
