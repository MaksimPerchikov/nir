Веб приложение с многофакторной аутентификацией.

Первый этап - ввод пользователя и пароль соответственно, второй - ввод почты и последующий ввод кода, пришедшего на почту.

(Jar-файл постараюсь в ближайшее времся упаковать и так же выложить сюда, для удобной проверки.)

Запуск приложения через jar-файл:

1)Скачать jar-файл

2)Поместить в любую директорию (в дальнейшем используется C:\Users\MPerchikov\IdeaProjects\nir\project\target )

3)Запускаем консоль CMD

4)Переходим в директорию (с помощью: cd IdeaProjects\.....), в которой у вас лежит jar-файл (у меня C:\Users\MPerchikov\IdeaProjects\nir\project\target)

5)Исполняем упакованный файл

java -jar НАЗВАНИЕ_ДЖАРНИКА_С_РАСШИРЕНИЕМ

(java -jar projects-17.jar) 


Рекомендованный сценарий приложения:

1)Перейти на http://localhost:8080/greeting

2)Далее нажать кнопку "Войти"

3)Ввести пользователя и пароль (имя:user,пароль:password)

4)Попробовать угадать код и в поле "Code with mess" вписать значение для дальнейшего прохода.
Так как к этому пользователю не привязана ваша почта, почту придется ввести вручную в поле "your email".

5)Проверить почту на письма.

6)Скопировать/запомнить код из письма (ВАЖНО!Копировать все знаки, даже если есть знак '-')

7)Ввесли в поле "Code with mess"

8)Получить доступ к ресурсам.
