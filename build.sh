./gradlew build
rm -rf build/dependency
mkdir -p build/dependency && (cd build/dependency; jar -xf ../libs/Invenus-0.0.1-SNAPSHOT.jar)
docker-compose build