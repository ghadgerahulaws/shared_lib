def call(String repoUrl, String branch = 'main', String credentialsId = 'github-creds') {
    pipeline {
        agent any
        stages {
            stage('Clone Repository') {
                steps {
                    script {
                        checkout([
                            $class: 'GitSCM',
                            branches: [[name: "*/${branch}"]],
                            userRemoteConfigs: [[
                                url: repoUrl,
                                credentialsId: credentialsId
                            ]]
                        ])
                    }
                }
            }
        }
    }
}
