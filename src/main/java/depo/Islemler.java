package depo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Islemler {

    public static HashMap<Integer,Urunler> depo=new HashMap<>();
    public static final String W = "\u001B[37m";
    public static final String R = "\u001B[31m";
    public static final String G = "\u001B[32m";
    public static final String Y = "\u001B[33m";
    public static final String B = "\u001B[34m";
    static Scanner input=new Scanner(System.in);

    public  static Integer urunEkle(){

        System.out.println(Y+"Ekleme yapilacak urun id girin");
        Integer id= input.nextInt();



        System.out.println(Y+"Ekleme yapmak istediginiz miktarini giriniz");
        Integer miktar= input.nextInt();
        Integer eskiMiktar=depo.get(id).miktar;
        Integer sonMiktar=eskiMiktar+miktar;
        return depo.get(id).miktar=sonMiktar;


    }
    public static Map<Integer,Urunler> urunOlustur (){


        System.out.println(G+"Urun Id giriniz");
        Integer id= input.nextInt();
        input.nextLine();
        System.out.println(G+"Urun ismi giriniz");
        String urunIsmi=input.nextLine();
        System.out.println(G+"Urun ureticisi giriniz");
        String urunUretici=input.nextLine();
        System.out.println(G+"Urun miktari giriniz");
        Integer urunMiktar= input.nextInt();
        input.nextLine();
        System.out.println(G+"Miktar birimi giriniz");
        String birim=input.nextLine();
        System.out.println(G+"Urun rafini giriniz");
        String urunRafi=input.nextLine();



        depo.put(id,new Urunler(urunIsmi,urunUretici,urunMiktar,birim,urunRafi));
        return depo;
    }
    public static void urunYazdir(){
        Set<Map.Entry<Integer,Urunler>> urunListesi=depo.entrySet();
        for (Map.Entry<Integer,Urunler> w: urunListesi){
            System.out.println(w);
        }
    }

    public  static Integer urunCikar(){

        System.out.println(R+"Cikarma yapilacak urun id girin");
        Integer id= input.nextInt();
        System.out.println(R+"Cikarilacak urun miktarini giriniz");
        Integer girilenmiktar= input.nextInt();
        Integer eskiMiktar=depo.get(id).miktar;
        Integer sonMiktar=eskiMiktar;
        if (eskiMiktar<girilenmiktar){
            System.out.println(R+"Depoda olandan fazla miktarda urun cikisi yapilamaz");
        }else{
           sonMiktar=eskiMiktar-girilenmiktar;
        }
        return depo.get(id).miktar=sonMiktar;
    }



    public static String rafSec(){
        System.out.println("Raf degistirmek istediginiz urunun id seciniz");
        Integer id= input.nextInt();
        System.out.println("hangi raf");
        String secilenRaf=input.next();
        depo.get(id).raf=secilenRaf;
        return secilenRaf;
    }
    public static void programiBitir(){
        System.out.println("Islemler tamamlandi..");
    }
    public static void islemSec(){
        int secilenIslem=0;
      while (secilenIslem!=6){
          System.out.println(Y+ "========================== İŞLEMLER =======================\r\n"
                  + "   ____________________              ____________________   \n"
                  + "   | 1-URUN TANIMLAMA |              |  2-URUN LİSTELE  |   \n"
                  + "   ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯              ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯   \n"
                  + "   ____________________              ____________________   \n"
                  + "   | 3-URUN GIRISI    |              |  4-URUN RAFA KOY |   \n"
                  + "   ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯              ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯   \n"
                  + "   ____________________              ____________________   \n"
                  + "   | 5-URUN CIKISI    |              |  6-BITIRME       |   \n"
                  + "   ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯              ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯  "+R);
          System.out.println("Secmek istediginiz islem no giriniz");
          secilenIslem=input.nextInt();
          switch (secilenIslem){
              case 1:
                  urunOlustur();
                  break;
              case 2:
                  urunYazdir();
                  break;
              case 3:
                  urunEkle();
                  break;
              case 4:
                  rafSec();
                  break;
              case 5:
                  urunCikar();
                  break;
              case 6:
                  programiBitir();
                  break;
              default:
                  System.out.println(R+"Hatali giris yaptiniz, tekrar deneyiniz");
          }
      }

    }


}
