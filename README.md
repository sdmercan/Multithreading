# Multithreading
1'den 100.000'e kadarki sayılar arasında maksimum bölen sayısı olan sayıyı ve bölen sayısını bulan multithreading uygulama

Bunu 4 paralel processte yapalım. Bunun için 4 thread oluşturulacak.Her bir thread'e mainde name set edilecek.

Her bir thread ilgili aralıktaki maksimum bölen sayısı olan sayıyı ve bölen sayısını kendi isminde bir txt dosyasına yazdıracak.
(Örnek:
1.thread 1-25000
2.thread 25000-50000
3.thread 50000-75000
4.thread 75000-100000 aralığında)

Main her 2 sn'de bir dosyaları kontrol edecek.
Tüm dosyalar oluşmuşsa o dosyalardan verileri okuyup 1-100000 arasında maksimum bölen sayısı olan sayıyı ve bölen sayısını ekrana yazdıracak.

