def call(String repoUrl, String branch = 'main') {
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
                                url: repoUrl
                            ]]
                        ])
                    }
                }
            }
        }
    }
}
