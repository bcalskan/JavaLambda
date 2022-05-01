package lambdaTutorial;

import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {

    /*
    TASK :
    fields --> Universite (String)
               bolum (String)
               ogrcSayisi (int)
               notOrt (int)
               olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.
     */
    public static void main(String[] args) {
        Üniversite bogazici = new Üniversite("bogazici", "matematik", 571, 93);
        Üniversite itü = new Üniversite("istanbul teknik", "matematik", 622, 81);
        Üniversite istanbul = new Üniversite("istanbul", "hukuk", 1453, 71);
        Üniversite marmara = new Üniversite("marmara", "bilgisayar", 1071, 77);
        Üniversite ytu = new Üniversite("yildiz teknik", "gemi", 333, 74);

        List<Üniversite> ünv = new ArrayList<>(Arrays.asList(bogazici, itü, istanbul, marmara, ytu));

        System.out.println(notOrtalamasiKontrol(ünv));
        System.out.println("\n*********************");

        System.out.println(ögrenciSayisiKontrol(ünv));
        System.out.println("\n*********************");

        System.out.println(bölümKontrol(ünv));
        System.out.println("\n*********************");

        System.out.println(ögrenciSayisiSirala(ünv));
        System.out.println("\n*********************");

        ögrenciSayisiVoid(ünv);
        System.out.println("\n*********************");

        notOrtalamasiSirala(ünv);
        System.out.println("\n*********************");

        ögrenciSayisienAzIkinci(ünv);
        System.out.println("\n*********************");

        System.out.println(enAzOgrcSaysi2Unv(ünv));
        System.out.println("\n*********************");

        notOrtalamasi63tenBüyüklerinÖgrenciSayisi(ünv);
        System.out.println("\n*********************");

        System.out.println(notOrtalamasi63tenBüyüklerinÖgrenciSayisi2(ünv));
        System.out.println("\n*********************");

        System.out.println(notOrtalamasi63tenBüyüklerinÖgrenciSayisiToInt(ünv));
        System.out.println("\n*********************");

        System.out.println(notOrtalamasi130danBüyüklerinNotOrtalamasi(ünv));
        System.out.println("\n*********************");

        System.out.println(matematikBölümleriSayisi(ünv));
        System.out.println("\n*********************");

        System.out.println(ögrenciSayilari130danBüyüklerinEnBüyükNotOrtalamasi(ünv));
        System.out.println("\n*********************");

        System.out.println(ögrenciSayilari130danBüyüklerinEnBüyükNotOrtalamasi2(ünv));
        System.out.println("\n*********************");

        System.out.println(ögrenciSayilari150denAzEnKücükNotOrtalamasi(ünv));
        System.out.println("\n*********************");


    }

    //task 01--> notOrt'larinin 74' den buyuk oldg kontrol eden pr create ediniz.
    public static boolean notOrtalamasiKontrol(List<Üniversite> ünv) {
        return ünv.stream().allMatch(t -> t.getNotOrt() > 74);
    }

    //task 02-->ogrc sayilarinin   110 den az olmadigini  kontrol eden pr create ediniz.
    public static boolean ögrenciSayisiKontrol(List<Üniversite> ünv) {
        return ünv.stream().allMatch(t -> t.getÖgrcSayisi() > 110);
    }


    //task 03-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.
    public static boolean bölümKontrol(List<Üniversite> ünv) {
        return ünv.stream().anyMatch(t -> t.getBölüm().equals("matematik"));
    }


    //task 04-->universite'leri ogr sayilarina gore b->k siralayiniz.
    public static List<Üniversite> ögrenciSayisiSirala(List<Üniversite> ünv) {
        return ünv.
                stream().
                sorted(Comparator.comparing(Üniversite::getÖgrcSayisi).reversed()).
                collect(Collectors.toList());
        /*
        collect() akistaki elemanlari istenen sarta göre toplar
         */
    }

    public static void ögrenciSayisiVoid(List<Üniversite> ünv) {
        System.out.println(ünv.
                stream().
                sorted(Comparator.comparing(Üniversite::getÖgrcSayisi).reversed()).
                collect(Collectors.toList()));
    }


    //task 05-->universite'leri notOrt gore  b->k siralayip ilk 3 'unu print ediniz.
    public static void notOrtalamasiSirala(List<Üniversite> ünv) {
        System.out.println(ünv.stream().sorted(Comparator.comparing(Üniversite::getNotOrt).reversed()).limit(3).collect(Collectors.toList()));
    }


    //task 06--> ogrc sayisi en az olan 2. universite'yi  print ediniz.
    public static void ögrenciSayisienAzIkinci(List<Üniversite> ünv) {
        System.out.println(ünv.stream().sorted(Comparator.comparing(Üniversite::getÖgrcSayisi)).skip(1).findFirst());

        System.out.println(ünv.stream().sorted(Comparator.comparing(Üniversite::getÖgrcSayisi)).skip(1).iterator().next());

    }

    //task 06--> ogrc sayisi en az olan 2. universite'yi  print ediniz.
    public static List<Üniversite> enAzOgrcSaysi2Unv(List<Üniversite> unv) {
        return unv.
                stream().
                sorted(Comparator.comparing(Üniversite::getÖgrcSayisi)).
                limit(2).
                skip(1).
                collect(Collectors.toList());

    }

    //task 07--> notOrt 63 'den buyuk olan universite'lerin ogrc sayilarini toplamini print ediniz
    public static void notOrtalamasi63tenBüyüklerinÖgrenciSayisi(List<Üniversite> ünv) {
        int toplam = ünv.stream().filter(t -> t.getNotOrt() > 63).map(t -> t.getÖgrcSayisi()).reduce(0, (a, b) -> a + b);
        System.out.println(toplam);
    }

    public static int notOrtalamasi63tenBüyüklerinÖgrenciSayisi2(List<Üniversite> ünv) {
        return ünv.stream().filter(t -> t.getNotOrt() > 63).map(t -> t.getÖgrcSayisi()).reduce(0, (a, b) -> a + b);
    }

    public static int notOrtalamasi63tenBüyüklerinÖgrenciSayisiToInt(List<Üniversite> ünv) {
        return ünv.stream().
                filter(t -> t.getNotOrt() > 63).
                mapToInt(t -> t.getÖgrcSayisi()). //mapToInt methodu hepsini inte cevirecegi icin ekstra reduce(toplama) islemine gerek yoktur
                //sonuna .sum() methodu kullanarak int degerlerin toplamini alabiliriz
                        sum();
        //mapToInt() --> akistaki elemanlarin data typeini parametresindeki() degere göre Int update eder

    }

    //task 08--> Ogrenci sayisi 130'dan buyuk olan universite'lerin notOrt'larinin ortalamasini bulunuz.
    public static OptionalDouble notOrtalamasi130danBüyüklerinNotOrtalamasi(List<Üniversite> ünv) {
        return ünv.stream().filter(t -> t.getÖgrcSayisi() > 130).mapToDouble(t -> t.getNotOrt()).average();
        //mapToDouble() --> akistaki elemanlarin data typeini parametresindeki() degere göre double update eder
    }

    //task 09-->"matematik" bolumlerinin sayisini  print ediniz.
    public static int matematikBölümleriSayisi(List<Üniversite> ünv) {
        return (int) ünv.stream().filter(t -> t.getBölüm().equalsIgnoreCase("matematik")).count();
    }


    //task 10-->Ogrenci sayilari 571'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz
    public static Optional<Üniversite> ögrenciSayilari130danBüyüklerinEnBüyükNotOrtalamasi(List<Üniversite> ünv) {
        return ünv.stream().filter(t -> t.getÖgrcSayisi() > 571).sorted(Comparator.comparing(Üniversite::getNotOrt).reversed()).findFirst();
    }

    public static OptionalInt ögrenciSayilari130danBüyüklerinEnBüyükNotOrtalamasi2(List<Üniversite> ünv) {
        return ünv.stream().filter(t -> t.getÖgrcSayisi() > 571).mapToInt(t -> t.getNotOrt()).max();
    }


    //task 11-->Ogrenci sayilari 1071'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.
    public static OptionalInt ögrenciSayilari150denAzEnKücükNotOrtalamasi(List<Üniversite> ünv) {
        return ünv.stream().filter(t -> t.getÖgrcSayisi() < 1071).mapToInt(t -> t.getNotOrt()).min();
    }


}

