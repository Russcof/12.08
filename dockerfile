FROM ubuntu:24.04

# Устанавливаем необходимые приложения
RUN apt-get update
RUN apt-get install -y openjdk-17-jdk
RUN apt-get install -y git 
RUN apt-get install -y maven

# Скачиваем заглушку с git
RUN git clone https://github.com/Russcof/12.08.git

# Создаем директорию в контейнере для размещения кода в приложении
WORKDIR /12.08

# Собираем проект с помощью maven
RUN mvn clean package install

# Контейнер будет прослушивать порты 8081 8778
EXPOSE 8081 8778

# Команда для запуска приложения при запуске контейнера
CMD ["java", "-javaagent:./jolokia-agent-jvm-2.0.3-javaagent.jar=port=8778,host=0.0.0.0", "-jar", "./target/demo-0.0.1-SNAPSHOT.jar", "--server.port=8081"]
