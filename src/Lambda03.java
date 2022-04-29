import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambda03 {
    public static void main(String[] args) {
        List<String> menü = new ArrayList<>(Arrays.asList("Küsleme", "Adana", "Trilece", "HavucDilim", "Büryan", "Yaglama", "Kokorec", "Arabasi", "Güvec"));

        alfabetikBüyükHarfTekrarsiz(menü);
        System.out.println("\n*********************");
        characterSayisiniTersSiraliYazdir(menü);
        System.out.println("\n*********************");
        characterSayisinaGöre(menü);
        System.out.println("\n*********************");
        sonHarfeGöreTers(menü);
        System.out.println("\n*********************");

        // Task : listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan,ve karelerini tekrarsiz buyukten kucuge sirali  print ediniz..
        // Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
        // Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.
        // Task : List elelmanlarinin "x" ile biten en az bir elemaı kontrol ediniz.
        // Task : Karakter sayisi en buyuk elemani yazdiriniz.
        // Task : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
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

}
