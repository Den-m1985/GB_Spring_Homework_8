
создаем образ базы данных:
docker-compose up

выводим в консоль все запущенные контейнеры:
docker ps

Копируем имя контейнера. Заходим внутрь контейнера:
docker exec -it  gb_spring_homework_5-postgresdb-1 bash

Мы должны быть внутри контейнера. Заходим в базу данных:
psql -U myuser -d notes

Показать таблицы:
\dt

выводим всех:
select * from notes;

Выход \q
Выход exit

docker-compose down
