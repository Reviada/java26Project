package constants;

public interface Constants {
    //одна из строк будет всегда закомментирована,в зависимости от того ,где делают проект локально или на удаленном сервере
    //local(локальное подключение)
    String DB_URL_CONNECTION = "jdbc:mysql://localhost:3306/students_26?user=root&password=revi180488";
    //remote(удаленный сервер)
    //String DB_URL_CONNECTION = "jdbc:mysql://localhost:3306/students_26?user=revi&password=revi180488";
}
