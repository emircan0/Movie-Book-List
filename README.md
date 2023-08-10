<<<<<<< HEAD
Bu proje, Java Swing kütüphanesi kullanılarak geliştirilen bir GUI uygulamasını içermektedir. Model-View-Controller (MVC) tasarım modeli benimsenmiş ve verilerin saklanması için MySQL veritabanı entegrasyonu yapılmıştır. Bu README dosyası, proje hakkında detaylı teknik bilgiler ve açıklamalar sunacaktır.

Proje Açıklaması
Projenin amacı, kullanıcıların "Okuduğum Kitaplar" ve "Okunacaklar" başlıklı iki ayrı liste oluşturabilmesini sağlamaktır. Kullanıcılar, kitaplar, makaleler veya diğer okuma materyallerini bu listelere ekleyebilir, düzenleyebilir ve silebilirler. MVC modeli, uygulamanın kodunun daha organize ve bakımı kolay bir şekilde ayrıştırılmasını sağlamaktadır.

MVC Modeli
MVC modeli, uygulamanın farklı katmanlarını mantıklı bir şekilde organize ederek geliştirmeyi kolaylaştırır.

Model: Veri yönetimi işlevselliği bu katmanda yer alır. Veritabanı bağlantısı ve sorguları burada ele alınır. Örneğin, kullanıcıların okuma listeleri ve öğeleri bu katmanda tutulur.

View: Kullanıcı arayüzü bu katmanda oluşturulur. Java Swing kullanılarak oluşturulan formlar ve bileşenler (butonlar, metin kutuları vb.) bu katmanda yer alır. Kullanıcının listeleri görüntülemesi ve düzenlemesi sağlanır.

Controller: Kullanıcının etkileşimlerini yöneten kod burada bulunur. Kullanıcının butonlara tıklaması veya veri girişi gibi olaylar, controller tarafından alınır ve uygun model ve view işlevlerini etkiler.

Veritabanı Entegrasyonu
Projede MySQL veritabanı kullanılmıştır. Kullanıcıların okuma listeleri ve öğeleri veritabanında saklanır. Bu sayede veri kalıcılığı sağlanır ve kullanıcıların farklı oturumlarda bile erişimi mümkün olur. Veritabanı bağlantısı, JDBC (Java Database Connectivity) aracılığıyla gerçekleştirilir.

Teknik Detaylar
Proje, Java Swing kütüphanesi kullanılarak GUI oluşturur. Butonlar, metin alanları, liste kutuları gibi Swing bileşenleri kullanılarak kullanıcı arayüzü tasarlanır.

Veritabanı bağlantısı için JDBC kullanılır. Kullanıcıların okuma listeleri ve öğeleri için ayrı tablolar oluşturulur.

MVC modeli için Java sınıfları oluşturulur. Örneğin, ListModel sınıfı modeli temsil ederken, ListView sınıfı görüntüyü oluşturur.

Kullanıcılar, uygulama aracılığıyla yeni öğeler ekleyebilir, mevcut öğeleri düzenleyebilir veya silebilir.

Uygulama, kullanıcıların girişlerini doğrulamak ve hatalara karşı korumak için gerekli kontrolleri içerir.
=======

>>>>>>> 4ee89319c5defda44e750808d82bba658afadbae
