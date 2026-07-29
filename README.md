# 📝 Заметки

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Platform](https://img.shields.io/badge/Platform-Android-lightgrey)]()
[![Version](https://img.shields.io/badge/Version-1.0.0-blue)]()

Простое, быстрое и удобное приложение для создания заметок с поддержкой изображений. Закрепляйте важное, ищите нужное мгновенно и держите всё под рукой.

---

## ✨ Основные возможности

- **📌 Закрепление заметок** — важные заметки всегда наверху списка. Закрепите в один тап и так же легко открепите, когда надобность пройдёт.
- **➕ Создание и удаление** — добавляйте новые заметки за секунды, удаляйте ненужные через кнопку на верхней панели.
- **🔍 Мгновенный поиск** — находите любую заметку по содержимому текста или заголовка. Поиск работает сразу при вводе.
- **🖼️ Изображения в заметках** — прикрепляйте одно или несколько фото. При добавлении двух и более изображений они автоматически группируются в аккуратную галерею. Ненужное изображение можно удалить отдельно.
- **👀 Предпросмотр в списке** — на главном экране каждая заметка показывает первое прикреплённое изображение и первые строки текста, чтобы вы легко ориентировались в своих записях.
- **🎨 Современный интерфейс** — полностью на Jetpack Compose, с плавными анимациями и лаконичным интерфейсом.

---

## 🛠 Технологический стек

![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white)
![Room](https://img.shields.io/badge/Room-03DAC5?style=for-the-badge&logo=sqlite&logoColor=white)
![Coil](https://img.shields.io/badge/Coil-000000?style=for-the-badge&logo=coil&logoColor=white)
![Hilt](https://img.shields.io/badge/Hilt-FF5722?style=for-the-badge&logo=dagger&logoColor=white)
![Coroutines](https://img.shields.io/badge/Coroutines-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![MVVM](https://img.shields.io/badge/MVVM-FF6F00?style=for-the-badge&logo=android&logoColor=white)
![Clean Architecture](https://img.shields.io/badge/Clean%20Architecture-808080?style=for-the-badge&logo=blueprint&logoColor=white)
![Splash Screen API](https://img.shields.io/badge/Splash%20Screen-3DDC84?style=for-the-badge&logo=android&logoColor=white)

---

## 🧱 Архитектура

Приложение построено по принципам **Clean Architecture** с разделением на слои `data`, `domain` и `presentation`. Внутри presentation используется паттерн **MVVM**, что обеспечивает чёткое разделение ответственности и лёгкость тестирования.

- **Data** — Room (локальная база данных), сохранение изображений в Internal Storage, репозитории.
- **Domain** — use cases для всех операций (добавление, удаление, поиск, закрепление).
- **Presentation** — Jetpack Compose UI, ViewModel, управление состоянием с помощью `StateFlow`.

Внедрение зависимостей осуществляется с помощью Hilt. Splash Screen API формирует начальный экран до загрузки данных. Для загрузки изображений используется Coil с дисковым и кэш-памятью.

---

<img width="400" alt="Screenshot_20260427_161301_Notes" src="https://github.com/user-attachments/assets/b7a0b8ca-ec8b-4eba-a8c7-6bfd4a8c9139" />
<img width="400" alt="Screenshot_20260427_161317_Notes" src="https://github.com/user-attachments/assets/afe44d9c-c72a-4036-b2d6-6c71ff2bee00" />
<img width="400" alt="Screenshot_20260427_164256_Notes" src="https://github.com/user-attachments/assets/0aea0170-33ad-4589-b07f-5c2800f2c8d1" />
