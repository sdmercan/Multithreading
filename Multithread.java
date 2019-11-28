import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class MyThread implements Runnable {
	int bolenSayisi=0;
	int maxBolenSayisi=0;
	int maxOlanSayi=0;
	int ilkLimit;
	int sonLimit;
	String name;
	File file;
	boolean fileExists;
	
	public boolean isFileExists() {
		return fileExists;
	}

	public void setFileExists(boolean fileExists) {
		this.fileExists = fileExists;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public MyThread(int ilkLimit, int sonLimit,String name) {
		super();
		this.ilkLimit = ilkLimit;
		this.sonLimit = sonLimit;
		this.name=name;
	}
	
	@Override
	public void run() {
		for(int i=ilkLimit;i<sonLimit;i++) 
		{
			if(maxBolenSayisi<bolenSayisi) 
			{
				maxBolenSayisi=bolenSayisi;
				maxOlanSayi=i;
			}
			bolenSayisi=0;
			for(int j=1;j<=i;j++) 
			{
				if(i%j==0) {
					bolenSayisi++;
				}
			}
		}
		file=new File(name+".txt");
		try {
			if(file.createNewFile()) 
			{
				this.setFile(file);
				this.setFileExists(true);
				FileWriter writer=new FileWriter(file);
				writer.write(maxOlanSayi+" "+maxBolenSayisi);
				writer.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public int readFiles(int maxBolenSayisi,int[] dizi) {

		try {
			Scanner reader = new Scanner(this.getFile());
			String[] satir;
			int sayi;
			int bolenSayisi;
			while(reader.hasNextLine()) 
			{
				satir=reader.nextLine().split(" ");
				sayi=Integer.parseInt(satir[0]);
				bolenSayisi=Integer.parseInt(satir[1]);
				if(maxBolenSayisi<bolenSayisi) {
					maxBolenSayisi=bolenSayisi;
					dizi[0]=sayi;
				}
			}
			reader.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return maxBolenSayisi;
	}
	
}
public class Multithread {

	
	public static void main(String[] args) throws InterruptedException {
		
		MyThread t1=new MyThread(1,25000,"1");
		MyThread t2=new MyThread(25000,50000,"2");
		MyThread t3=new MyThread(50000,75000,"3");
		MyThread t4=new MyThread(75000,100000,"4");
		
		Thread thread1=new Thread(t1);
		Thread thread2=new Thread(t2);
		Thread thread3=new Thread(t3);
		Thread thread4=new Thread(t4);
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
		boolean kontrol=false;
		while(!kontrol) 
		{
			Thread.sleep(2000);
			if(t1.isFileExists() && t2.isFileExists() && t3.isFileExists() && t4.isFileExists()) 
			{
				kontrol=true;
			}
		}
		
		int[] sayi=new int[1];
		int maxBolenSayisi=t1.readFiles(0,sayi);
		int maxBolenSayisi1=t2.readFiles(maxBolenSayisi,sayi);
		int maxBolenSayisi2=t3.readFiles(maxBolenSayisi1,sayi);
		int maxBolenSayisi3=t4.readFiles(maxBolenSayisi2,sayi);
		
		System.out.println("1-100000 arasýnda bölen sayýsý maksimum  olan \nSayý: "+sayi[0]+" Bölen Sayýsý: "+maxBolenSayisi3);
		
		
	}
}
