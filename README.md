# Müşteri Yönetim Sistemi

Bu proje, *Java (Swing GUI)* ve *MySQL* kullanılarak geliştirilen bir masaüstü uygulamasıdır. Kullanıcıların ürünleri ve müşterileri yönetebildiği, sepet oluşturabildiği ve sipariş verebildiği basit bir müşteri yönetim sistemidir.

---

## 🖥 Özellikler

- 🔐 *Giriş Sistemi*  
  Kullanıcı adı ve şifre ile güvenli giriş.

- 🏠 *Dashboard Arayüzü*  
  Giriş sonrası genel işlemlere erişim ekranı.

- 👤 *Müşteri Yönetimi*  
  Müşteri ekleme, silme, düzenleme ve listeleme.

- 📦 *Ürün Yönetimi*  
  Ürün ekleme, stok ve fiyat bilgisi düzenleme.

- 🛒 *Sepet Oluşturma*  
  Müşteri ve ürün seçilerek sipariş sepeti oluşturma.

- 📄 *Sipariş Oluşturma*  
  Sepet üzerinden müşteri adına sipariş oluşturma ve siparişleri görüntüleme.

---

## 🗄 Kullanılan Teknolojiler

- *Java 17+*
- *NetBeans IDE*
- *Swing (GUI)*
- *MySQL* (veritabanı)
- *JDBC* (veritabanı bağlantısı)

---

## ⚙ Kurulum ve Çalıştırma

1. MySQL üzerinde customer_management adında bir veritabanı oluşturun.
2. Gerekli tabloları ve örnek verileri içeren SQL dosyasını veritabanına aktarın (varsa database.sql).
3. DbHelper.java veya benzeri bağlantı sınıfında *kullanıcı adı, şifre ve veritabanı adı* kısmını kendi bilgilerinize göre düzenleyin.
4. Projeyi NetBeans ile açın.
5. LoginUI sınıfını çalıştırarak uygulamayı başlatın.

---

## 🧪 Ekranlar

- LoginUI.java – Giriş ekranı
- DashboardUI.java – Ana panel
- CustomerUI.java – Müşteri işlemleri
- ProductUI.java – Ürün işlemleri
- CartUI.java – Sepet işlemleri
- RegisterUI.java - Kullanıcı oluşturma

---

## 👤 Geliştirici

- *Gizem Coşkun*  
  GitHub: [github.com/GizemCoskun0](https://github.com/GizemCoskun0)

---

## 📌 Notlar

- Kod yapısı MVC (Model-View-Controller) düzenine uygundur.
- Uygulama sadece masaüstü ortamında çalışır (web değil).
- JDBC bağlantı hatalarına karşı DbHelper.showMsg() gibi yardımcı sınıflar kullanılmıştır.
- Bu uygulama tamamen İngilizce olarak tasarlanmıştır. Tüm ekran metinleri ve kullanıcı etkileşimleri İngilizcedir.

---


Bu proje kişisel veya eğitim amaçlı kullanım için serbesttir.

---

## 🌍 English

### 🧾 Project: Customer Management System

This project is a *desktop application* developed using *Java (Swing GUI)* and *MySQL*. It provides basic functionalities such as managing customers and products, creating shopping carts, and placing orders.

---

### 🖥 Features

- 🔐 *Login System*  
  Secure login with username and password.

- 🏠 *Dashboard UI*  
  A central interface for managing all operations after login.

- 👤 *Customer Management*  
  Add, edit, delete, and list customers.

- 📦 *Product Management*  
  Add and update product details like price and stock.

- 🛒 *Cart Creation*  
  Create a shopping cart by selecting customer and products.

- 📄 *Order Placement*  
  Create and track customer orders based on the cart.

---

### 💻 Technologies Used

- Java 17+
- NetBeans IDE
- Swing (Java GUI)
- MySQL (Database)
- JDBC (Database Connection)

---

### ⚙ How to Run the Project

1. Create a MySQL database (e.g., customer_management).
2. Import the SQL structure and sample data if provided (database.sql).
3. Update your database credentials in the DbHelper.java file.
4. Open the project in NetBeans.
5. Run the LoginUI class to start the application.

---

### 🧪 UI Screens

- LoginUI.java – Login screen
- DashboardUI.java – Main control panel
- CustomerUI.java – Customer operations
- ProductUI.java – Product operations
- CartUI.java – Cart creation
- RegisterUI.java - Creat a new user

---

### 👩‍💻 Developer

- *Gizem Coşkun*  
  GitHub: [github.com/GizemCoskun0](https://github.com/GizemCoskun0)

---

### 📌 Notes

- The project follows a simplified *MVC (Model-View-Controller)* structure.
- Designed for *desktop use only*, not web-based.
- Helper classes such as DbHelper are used for database operations and error handling.
- This application is fully designed in English. All UI texts and interactions are in English.

---


Free to use for personal or educational purposes.
