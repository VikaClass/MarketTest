# language: ru
@withdrawal
Функция: Добавление товара в корзину

  @success
  Сценарий: Успешное добавление товара в корзину
    Дано пользователь зашел на сайт
    И у него пустая корзина
    Когда пользователь заполняет поле поиска товара "APPLE iPhone 14 Pro Max 256Gb Deep Purple"
    И нажимает на кнопку enter
    И нажимает на оранжевую кнопку купить
    И нажимает на кнопку оформить доставку или резерв в магазине
    Тогда открывается корзина с одним товаром
