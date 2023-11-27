package VarMiYokMu;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class Game {
	
	public static void Mesaj(String Mesaj) {
		System.out.println("n" + Mesaj);
	}

	
	public static int RandomSec(int Max) {
		Random rnd = new Random();
		int s = rnd.nextInt(Max);
		return s;
	}
	
	
	
	public static void ParaKutusu(int[] p, int[] RandomMoney) {
		int rast;
		for(int i = 0; i < 22; i++) {
		  rast = RandomSec(22);
		  
		  if(p[rast] != 0) {
			  RandomMoney[i] = p[rast];
			  p[rast] = 0;
		  }
		  else {
			  i--;
		  }
		}
	}
	
	
	public static void KutulariYaz(int[] RandomMoney) {
		for(int i = 0; i < 22; i++) {
			System.out.println("n" + (i + 1) + ". kutu: " + RandomMoney[i]);
		}
	}
	
	public static String Teklif(int[] AcikKutu, int[] ParaKutusu) {
		
		long AcikOlmayanKutu = 0;
		long AcikOlanKutu = 0;
		int AcikKutuSayisi = 0;
		
		
		for(int i = 0; i < 22; i++) {
			if(AcikKutu[i] != 0) {
				AcikOlanKutu += ParaKutusu[i];
				AcikKutuSayisi++;
			}
			else {
				AcikOlanKutu += ParaKutusu[i];
			}
		}
		return Long.toString((AcikOlmayanKutu - AcikOlanKutu) / AcikKutuSayisi);
	}
	
	public static void KutuDurumlari(int[] AcilanKutular, int[] ParaKutulari) {

        for (int i = 0; i < 22; i++) {

            String Durum, Kutu;
           
            if((ParaKutulari[i] != AcilanKutular[i])){
                Durum = "Açılmadı";
                Kutu = "[" + (i + 1) + "] . Kutu : " + ParaKutulari[i];
            }
            else {
                Durum = "AÇILDI";
                Kutu = " " +(i + 1) + " . Kutu : " + ParaKutulari[i];
            }
           
            Mesaj( Kutu + " " + Durum);
        }
    }
	
	
	
	
	
	public static void main(String[] args) {
		
		  int[] para = {1, 2, 5, 10, 25, 50, 100, 200, 300, 400, 500, 5000, 10000, 15000, 25000, 50000, 75000, 100000, 150000, 250000, 500000, 500000};
	        int[] ParaKutulari = new int[22];
	        BufferedReader Klavye = new BufferedReader(new InputStreamReader(System.in));
	        int[] AcilanKutular = new int[22];

	        ParaKutusu(para, ParaKutulari);

	        int YarismaciKutusu = RandomSec(22);
	        Mesaj("Seçtiğiniz kutu  :" + YarismaciKutusu);

	        int KutuNo = 0;
	        do {
	            Mesaj("-----------------Kutu Durumları------------------");
	            KutuDurumlari(AcilanKutular, ParaKutulari);
	            Mesaj("-----------------Açılmayan Kutu Sayısı " + (22 - KutuNo) + "------------");

	            Mesaj("Açmak İçin Kutu numarası seçiniz: ");
	            int SecilenKutu = new Integer(Klavye.readLine());

	            if (SecilenKutu - 1 == YarismaciKutusu) {
	                Mesaj("Kendi kutunuzu açamazsınız");
	                continue;
	            }

	            AcilanKutular[SecilenKutu - 1] = ParaKutulari[SecilenKutu - 1];

	            if (KutuNo % 2 == 0) {
	                Mesaj("Banka Teklifi :" + Teklif(AcilanKutular, ParaKutulari));
	            }

	            KutuNo++;

	        } while (KutuNo < 18);
		
		
		

	}

}
