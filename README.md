# Тестовое задание

Приложение на 3 экранные формы:
1. Первый экран сплэш скрин (для фона выбрать любую картинку с
котиками);
2. второй экран это пагинированный список новостей отсюда
https://newsapi.org/v2/everything?q=android&from=2019-04-00&sortBy=publishedAt&apiKey=26eddb253e7840f988aec61f2ece2907&page={меняем page c 1 до 5}
3. вывести заголовок, картинку, описание и дату;
4. пагинация должна быть с префетчингом 5 - ти элементов;
5. если во время пагинации вырубается интернет, должен в списке
появится элемент в котором говорится о том что интернет пропал и
кнопка повторить, при нажатии на эту кнопку (после того как появился
интернет) должна продолжиться загрузка списка, т.е вроде того, как
сделана лента в вк;
6. должно быть кеширование новостей в базу данных;
7. по клику на список переходим на сайт новости в webview;
8. приложение должно поддерживать переворот экрана.
Приложение не должно падать если неожиданно обрывается связь.

Можно использовать любые библиотеки для ускорения разработки.
Обязательно использование **mvp** и **di**. Очень приветствуется
использование **kotlin**.

# Что сделал

Заложил архитектуру, сплеш-скрин, экран новостей, загрузка первой страницы, показ текста
