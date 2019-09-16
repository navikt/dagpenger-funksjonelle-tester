pipeline {
  agent any

  stages {
    stage('Build code and Docker Image') {
      steps {
        sh "./gradlew docker --info"
      }
    }

    stage('Push to dockerhub') {
      steps {
        withDockerRegistry([ credentialsId: "dockerhub", url: "" ]) {
          sh 'docker push navikt/dagpenger-funksjonelle-tester:latest'
        }
      }
    }

    stage('Run feature tests') {
      steps {
        sh "kubectl config use-context dev-fss && kubectl delete -k kustomize/tests/app/ --ignore-not-found=true && kubectl apply -k kustomize/tests/app && kubectl wait --for=condition=complete --timeout=300s job/dagpenger-funksjonelle-tester -n dagpenger-test"
        sh "kubectl logs -n dagpenger-test -l app=dagpenger-funksjonelle-tester --tail=1000"
      }
    }
  }
}
