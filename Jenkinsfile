pipeline {
    agent any
    environment {
            XRAY_AUTH_URL = "https://xray.cloud.getxray.app/api/v2/authenticate"
            XRAY_IMPORT_FEATURE = "https://xray.cloud.getxray.app/api/v2/export/cucumber?keys=POEI20252-528"
            XRAY_RENVOIE_JSON = "https://xray.cloud.getxray.app/api/v2/import/execution/cucumber"
            CLIENT_ID = "81C7FEA9A5464340974B1548E5ADFA37"
            CLIENT_SECRET = "c3d20d2db84ce7fd05f4ca00bdd07d9aae16fe14b59b96712af9a1bf8c6171fe"
        }
    stages {
        stage('Authenticate with Xray') {
            steps {
                script {
                    def authResponse = bat(
                        script: """
                            curl -H "Content-Type: application/json" -X POST --data ^
                            "{\\"client_id\\": \\"${CLIENT_ID}\\", \\"client_secret\\": \\"${CLIENT_SECRET}\\"}" ^
                            ${XRAY_AUTH_URL}
                        """,
                        returnStdout: true
                    ).trim()

                    echo "Xray Authentication Response: ${authResponse}"

                   // Extraire le token depuis la réponse JSON
                    def token = authResponse.replaceAll('"', '').trim()
                    env.XRAY_TOKEN = token
                }
            }
        }
        stage ('Import des Features'){
            steps{
                script{
                    def importResponse = bat(
                        script: """
                            curl -H "Content-Type: application/json" -X GET -H "Authorization: Bearer ${env.XRAY_TOKEN}" ${XRAY_IMPORT_FEATURE} -o features.zip
                            """,
                            returnStdout: true
                    ).trim()
                        echo "Xray import response: ${importResponse}"
                }
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
        stage('Export report à XRAY')
            steps{
                script{
                    def exportResponse = bat(
                    script: """
                        curl -H "Content-Type: application/json" -X GET -H "Authorization: Bearer ${env.XRAY_TOKEN}" --data @'target/cucumber.json' ${XRAY_EXPORT_FEATURE}
                        """
                    ).trim

                    echo "Xray export response: ${exportResponse}"
                }
            }

	}
	post {
			always{
				junit 'target/surefire-reports/*.xml'
				cucumber fileIncludePattern: 'target/cucumber.json'
			}
	}

}
