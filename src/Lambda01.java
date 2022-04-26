import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda01 {
    public static void main(String[] args) {
        /*
   1) Lambda "Functional Programming"-->mathod(action) kullanma pr dili.
      Lambda --> mathod create  etme değil mevcut method'ları(library)secip kullanmaktır...
      Lambda  kendi başına tanımlanabilen parametre alıp gönderebilen fonksiyonlardır.
      Lambda'lar sayesinde daha az kod ve hızlı geliştirme sağlanabilmektedir.
      Java 8 ile gelen bu özellik, Java 8’in en önemli özelliğidir.

      "Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
   2) "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur
   3) "Functional Programming" hiz, code kisaligi, code okunabilirligi
       ve hatasiz code yazma acilarindan cok faydalidir.
   4) Lambda sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak map'lerde kullanılmaz.
      Lambda kullanmak hatasız code kullanmaktır.

          Collections Nedir?
          Çoğu yazılım tek tek öğeler yerine öğelerden oluşan toplulukları depolar ve onlar üzerinde işlem
          yapar. Array'ler onlardan birisidir. Java Collections Framework, arraylerle yapılan işleri daha kolay
          yaptığı gibi, daha fazlasını da yapar.
          Java'da bir koleksiyon (collection - bazen container, ambar diye adlandırılır) nesnelerden oluşan bir
          topluluğu bir arada tutan bir yapıdır. 'Collections Framework' ise arayüzler ve onların kurgularından
          (implementations) oluşur.
*/


        List<Integer> sayi = new ArrayList<>(Arrays.asList(34, 22, 16, 11, 35, 20, 63, 21, 65, 44, 66, 64, 81, 38, 15));
        //Task : Structured Programming kullanarak list elemanlarini aralarinda bosluk olacak sekilde print ediniz.
        printEtStructured(sayi);
        System.out.println("\n*********************");
        printEtFunctional(sayi);
        System.out.println("\n*********************");
        printEtFunctional1(sayi);
        System.out.println("\n*********************");
        printEtFunctional2(sayi);
        System.out.println("\n*********************");
        printCiftElemanStructured(sayi);
        System.out.println("\n*********************");
        printCiftElemanFunctional(sayi);
        System.out.println("\n*********************");
        printCiftElemanFunctional1(sayi);
        System.out.println("\n*********************");
        kücükCiftFunctional(sayi);
        System.out.println("\n*********************");
        kücükCiftFunctional1(sayi);
    }

    public static void printEtStructured(List<Integer> sayi) {
        for (Integer each : sayi) {
            System.out.print(each + " ");
        }
    }

    //Task : Functional Programming kullanarak list elemanlarini aralarinda bosluk olacak sekilde print ediniz.
    public static void printEtFunctional(List<Integer> sayi) {
        sayi.stream().forEach(t -> System.out.print(t + " "));
    }

    /*
 stream() : datalari yukaridan asagiya akis sekline getirir. Stream bir interface olduğundan dolayı doğrudan nesne almaz.
 forEach() :datanin parametresine gore her bir elemanı isler
 t-> : Lambda operatoru
  Lambda Expression-->(parameter list) -> {action body}
      Parameter list: Fonksiyonun parametreleri tanımlanır. Hiç parametre geçirmeden boşta olabilir.
      -> Arrow-token: Argüman listesi ile expression gövdesini birbirine bağlamak için kullanılır.
      Body: Expressionları ve statementları içerir.

     Bir kod bloğundan oluşan bir body...
     Bu tip lambda body, block body olarak bilinir. Blok gövdesi, lambda gövdesinin birden çok ifade içermesine izin verir.
     Bu ifadeler parantez içine alınır ve parantezlerden sonra noktalı virgül eklemeniz gerekir.

         () -> {
          double pi = 3.1415;
             return pi;
         };
  Lambda Expression  yapisi cok tavsiye edilmez daha cok METHOD REFERENCE kullanilir

 */


    public static void yazdir(int a) {  //verilen int degeri ayni satirda bosluk birakarak
        // yazdirma aksiyonu yapan seed(tohum) method create edildi
        System.out.print(a + " ");
    }

    public static void printEtFunctional1(List<Integer> sayi) {
        sayi.stream().forEach(System.out::print); //method referance --> System.out yapisinda print methodu cagir
        //Bu aksiyon taskdeki ayni satira ve bosluk ile yazmayi karsilamaz
        //bunun icin seed() method kullanilir
    }


    public static void printEtFunctional2(List<Integer> sayi) {
        sayi.stream().forEach(Lambda01::yazdir); //method referance --> System.out yapisinda print methodu cagir
    }

    //structured Programming ile list elemanlarinin  cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz
    public static void printCiftElemanStructured(List<Integer> sayi) {
        for (Integer each : sayi) {
            if (each % 2 == 0) {
                System.out.print(each + " ");
            }
        }
    }

    //Functional Programming ile list elemanlarinin  cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz
    public static void printCiftElemanFunctional(List<Integer> sayi) {
        sayi.stream().filter(t -> t % 2 == 0).forEach(Lambda01::yazdir);
    }

    public static boolean ciftBul(int a) { //seed method kendisine verilen integer degerin cift olmasini kontrol eder
        return a % 2 == 0;
    }

    public static void printCiftElemanFunctional1(List<Integer> sayi) {
        sayi.stream(). //list elemanlari akisa alindi
                filter(Lambda01::ciftBul). //cift bul method refere edilerek akistaki elemanlar filtrelendi
                forEach(Lambda01::yazdir); //filtreden gelen elemanlar yazdir methodu refere edilerek print edildi
    }

    //Task: functional prog ile list elemanlarinin 34den kücük cift olanlarini ayni satirda aralarina bosluk birakarak print
    public static void kücükCiftFunctional(List<Integer> sayi) {
        sayi.stream().
                //filter(t->t<34 && t%2==0).
                        filter(Lambda01::ciftBul). //method refere edildi
                filter(t -> t < 34). //34ten kücükler alindi
                forEach(Lambda01::yazdir);
    }

    //Task: functional prog ile list elemanlarinin 34den büyük veya cift olanlarini ayni satirda aralarina bosluk birakarak print
    public static void kücükCiftFunctional1(List<Integer> sayi) {
        sayi.stream().filter(t -> t % 2 == 0 || t < 34).forEach(Lambda01::yazdir);
    }

}





