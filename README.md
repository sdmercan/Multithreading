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

Oluşan Dosyalar :

[1.txt](https://github.com/sdmercan/Multithreading/files/4014062/1.txt)

[2.txt](https://github.com/sdmercan/Multithreading/files/4014063/2.txt)

[3.txt](https://github.com/sdmercan/Multithreading/files/4014064/3.txt)

[4.txt](https://github.com/sdmercan/Multithreading/files/4014065/4.txt)

Console Çıktısı : 

![Screenshot_5](https://user-images.githubusercontent.com/49806516/71641550-01d72f80-2caf-11ea-977b-7908f3f6d908.png)

