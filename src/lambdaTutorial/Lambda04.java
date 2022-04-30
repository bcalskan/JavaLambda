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

        ögrenciSayisiSirala(ünv);
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
    public static void ögrenciSayisiSirala(List<Üniversite> ünv) {

    }


    //task 05-->universite'leri notOrt gore  b->k siralayip ilk 3 'unu print ediniz.
    public static void notOrtalamasiSirala(List<Üniversite> ünv) {

    }


    //task 06--> ogrc sayisi en az olan 2. universite'yi  print ediniz.
    public static void ögrenciSayisienAzIkinci(List<Üniversite> ünv) {

    }


    //task 07--> notOrt 63 'den buyuk olan universite'lerin ogrc sayilarini toplamini print ediniz
    public static void notOrtalamasi63tenBüyüklerinÖgrenciSayisi(List<Üniversite> ünv) {

    }




    //task 08--> Ogrenci sayisi 130'dan buyuk olan universite'lerin notOrt'larinin ortalamasini bulunuz.
    public static void notOrtalamasi130danBüyüklerinNotOrtalamasi(List<Üniversite> ünv) {

    }


    //task 09-->"matematik" bolumlerinin sayisini  print ediniz.
    public static void matematikBölümleriSayisi(List<Üniversite> ünv) {

    }


    //task 10-->Ogrenci sayilari 130'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz
    public static void ögrenciSayilari130danBüyüklerinEnBüyükNotOrtalamasi(List<Üniversite> ünv) {

    }


    //task 11-->Ogrenci sayilari 150'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.
    public static void ögrenciSayilari150denAzEnKücükNotOrtalamasi(List<Üniversite> ünv) {

    }


}

