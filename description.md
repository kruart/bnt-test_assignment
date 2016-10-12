####   Test assignment

## Запуск:
1) Создать mysql БД: CREATE DATABASE parsingfiles;<br/>
2) Логин и пароль к БД: root. При необходимости изменить данные можно в файле resource/db/mysql.properties<br/>
3) Деплой в Tomcat: можно сразу в Intellij IDEA подключить tomcat(local) и запустить. <br/>
Второй вариант, самому создать и положить war-архив в tomcat/webapps. Запустить tomcat, зайти в админку и перейти по пути задеплоиного приложения. Или после деплоя вбить адрес самому, root == имя war-архива. Пример: TestTask-Bintime.war ==> http://localhost:8080/TestTask-Bintime/

##Работа приложения:
На стартовой странице присутствует html-форма для загрузки txt-файлов. После отправки формы сервер парсит данные, сохраняет результат парсинга в бд и отдаёт ответ в виде json.<br> Каждый файл обрабатается в отдельном потоке, но не больше 3 работающих потоков одновременно.

####Example:
Input data:

file1:<br/>
dog<br/>
dog<br/>
cat<br/>

file2:<br/>
cat<br/>
dog<br/>


Output data:
[{"value":"dog","count":3},{"value":"cat","count":2}]