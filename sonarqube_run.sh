#docker run -d --name sonarqube -e SONAR_ES_BOOTSTRAP_CHECKS_DISABLE=true -p 9000:9000 sonarqube:latest

mvn clean verify sonar:sonar \
  -Dsonar.projectKey=devops-springboot-book \
  -Dsonar.projectName='devops-springboot-book' \
  -Dsonar.host.url=http://localhost:9000/ \
  -Dsonar.token=sqp_c31694745c8b1e3146c4d4dd5baec6877a8a40b6
