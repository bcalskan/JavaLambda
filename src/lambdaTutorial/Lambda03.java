package lambdaTutorial;

import java.util.*;
import java.util.stream.Stream;

public class Lambda03 {
    public static void main(String[] args) {
        List<String> menü = new ArrayList<>(Arrays.asList("Küsleme", "Adana", "Trilece", "Büryan", "HavucDilim", "Yaglama", "Kokorec", "Arabasi", "Güvec", "Waffle", "Trilece", "Trilece"));

        alfabetikBüyükHarfTekrarsiz(menü);
        System.out.println("\n*********************");
        characterSayisiniTersSiraliYazdir(menü);
        System.out.println("\n*********************");
        characterSayisinaGöre(menü);
        System.out.println("\n*********************");
        sonHarfeGöreTers(menü);
        System.out.println("\n*********************");
        karakterCiftKareTekrarsiz(menü);
        System.out.println("\n*********************");
        karakterSayisiKontrol(menü);
        System.out.println("\n*********************");
        wIleBasliyorMu(menü);
        System.out.println("\n*********************");
        xIleBitiyorMu(menü);
        System.out.println("\n*********************");
        karakterSayisiEnBüyük(menü);
        System.out.println("\n*********************");
        sonHarfeGöreSirala(menü);
        System.out.println("\n*********************");

    }

    // Task : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
    public static void alfabetikBüyükHarfTekrarsiz(List<String> menü) {
        menü.
                stream().
                map(String::toUpperCase).  //map(t-> t.toUpperCase())
                sorted().distinct(). // benzersiz tekrarsiz hale getirildi
                forEach(t -> System.out.print(t + " "));
    }

    // Task : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
    public static void characterSayisiniTersSiraliYazdir(List<String> menü) {
        menü.stream().
                map(String::length).
                sorted(Comparator.reverseOrder()).distinct().
                forEach(t -> System.out.print(t + " "));
    }

    // Task : List elemanlarini character sayisina gore kckten byk e gore print ediniz..
    public static void characterSayisinaGöre(List<String> menü) {
        menü.stream().sorted(Comparator.comparing(String::length)).forEach(t -> System.out.print(t + " "));
    }

    // Task : list elemanlarinin son harfine gore ters sirali print ediniz.
    public static void sonHarfeGöreTers(List<String> menü) {
        menü.stream().sorted(Comparator.
                        comparing(t -> t.toString(). //52-53 --> son harflere göre getirecek --> a b c d e .. --> reverse ters cevirecek
                                charAt(t.toString().length() - 1)).
                        reversed()).
                forEach(t -> System.out.print(t + " "));
    }

    // Task : listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan,ve karelerini tekrarsiz buyukten kucuge sirali  print ediniz..
    public static void karakterCiftKareTekrarsiz(List<String> menü) {
        menü.stream().map(String::length).filter(t -> t % 2 == 0).map(t -> t * t).sorted(Comparator.reverseOrder()).distinct().forEach(t -> System.out.print(t + " "));
    }

    // Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
    public static void karakterSayisiKontrol(List<String> menü) {
        //uzun cözüm
        boolean kontrol = menü.stream().allMatch(t -> t.length() <= 7);
        if (kontrol) System.out.println("List elemanlari 7 veya daha az harften olusuyor");
        else System.out.println("List elemanlari 7 harften büyük");
        System.out.println(kontrol);

        //kisa cözüm
        System.out.println("=== Clean code ===");
        System.out.println(menü.stream().allMatch(t -> t.length() <= 7) ? "List elemanlari 7 veya daha az harften olusuyor" : "List elemanlari 7 harften büyük");
        /*
        1- anyMatch() --> en az bir eleman sarti saglarsa true aksi durumda false return eder
        2- allMatch() --> tüm elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder
        3- noneMatch()--> hicbir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder
        */
    }

    // Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.
    public static void wIleBasliyorMu(List<String> menü) {
        System.out.println(menü.stream().
                noneMatch(t -> t.startsWith("w")) ? "Menüde W harfi ile baslayan yemek bulunmaktadir" : "Menüde W harfi ile baslayan yemek bulunmamaktadir");
    }

    // Task : List elelmanlarinin "x" ile biten en az bir elemaı kontrol ediniz.
    public static void xIleBitiyorMu(List<String> menü) {
        System.out.println(menü.stream().
                anyMatch(t -> t.endsWith("x")) ? "Menüde x harfi ile biten yemek bulunmaktadir" : "Menüde x harfi ile biten yemek bulunmamaktadir");
    }


    // Task : Karakter sayisi en buyuk elemani yazdiriniz.
    public static void karakterSayisiEnBüyük(List<String> menü) {
        System.out.println(menü.stream().sorted(Comparator.comparing(t -> t.toString().length()).reversed()).findFirst());

        System.out.println("======");
        Optional<String> enBüyük = menü.stream().sorted(Comparator.comparing(t -> t.toString().length()).reversed()).findFirst();
        System.out.println(enBüyük);

        System.out.println("======");
        Stream<String> sonIsim = menü.stream().sorted(Comparator.comparing(t -> t.toString().length()).reversed()).limit(3);
        System.out.println(Arrays.toString(sonIsim.toArray()));
        //sonIsim.toArray() --> limit() methoddan dolayi stream type olan sonIsim toArray() method ile array type convert edildi


        /*
        findFirst() --> ilk elemani getirir

        limit(a) akistan cikan elemanlari a parametresine göre ilk a elemani alir
        limit(1) --> Sinirlandirma demek. Bu akisin elemanlarindan olusan, uzunlugu maxSize´dan uzun olmayacak
        sekilde kesilmis bir akis return eder. Strean return eder.
        */

    }

    // Task : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
    public static void sonHarfeGöreSirala(List<String> menü) {
        menü.stream().
                sorted(Comparator.comparing(t -> t.charAt(t.length() - 1))). //son harfe göre siraladi
                skip(1). //ilk elemani atladi
                forEach(t -> System.out.print(t + " "));
        /*
        skip() --> atlama demek. Akisin ilk n elemanini attikran sonra bu akisin kalan elemanlarindan olusan bir akis return eder
        Bu akis n´den daha az öge iceriyorsa, bos bir akis döndürülür. Bu, durum bilgisi olan bir ara islemdir

        skip(list.size()-) --> List´in uzunlugunun eksigini yazarsak son elemani getirir.
          */
    }


}//mainn
