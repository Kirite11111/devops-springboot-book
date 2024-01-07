# Utiliser une image de base Java
FROM openjdk:16-jdk

# Ajouter un point de montage pour volumes externes
VOLUME /tmp

# Ajouter le fichier .jar de l'application
ADD springboot-rest-demo-ws/target/springboot-rest-demo-ws-1.0.0-SNAPSHOT.jar app.jar

# Exécuter l'application Java à partir d'un JAR non compressé
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]