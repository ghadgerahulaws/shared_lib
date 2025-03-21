def call(String repoUrl, String branch = 'main') {
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
