package LambdaPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class C1_IntList_StreamOrnekleri {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(-5, -8, -2, -12, 0, 1, 12, 5, 6, 9, 15, 8));
        boslukluYaz(list);
        negatifleriYaz(list);
        System.out.println(pozitiflerdenYeniListe(list));
        System.out.println("Karelerden liste : " + karelerdenList(list));
        System.out.println(karelerTekrarsiz(list));
        kücüktenBüyüge(list);
        büyüktenKücüge(list);
        System.out.println(birlerBasamagi(list));
        System.out.println(pozitifKarelerbirlerBasamagi5Olmayan(list));
        System.out.println("Elemanlar toplami : " + elemanlarToplami(list));
        System.out.println("Negatif karelerden liste : " + negatiflerinKarelerindenList(list));
        System.out.println(bestenBüyük(list));
        System.out.println(sifirdanKücükMü(list));
        yüzeEsitEleman(list);
        sifiraEsitEleman(list);
        System.out.println(ilkBesElemanToplami(list));
        System.out.println(sonBesElemanToplami(list));

    }

    // S1:listi aralarinda bosluk birakarak yazdiriniz //
    public static void boslukluYaz(List<Integer> list) {
        list.stream().forEach(t -> System.out.print(t + " "));
    }


    //S2: sadece negatif olanlari yazdir
    public static void negatifleriYaz(List<Integer> list) {
        System.out.println();
        list.stream().filter(t -> t < 0).forEach(t -> System.out.print(t + " "));
    }


    //S3: pozitif olanlardan yeni bir liste olustur
    public static List<Integer> pozitiflerdenYeniListe(List<Integer> list) {
        System.out.println();
        return list.stream().filter(t -> t > 0).collect(Collectors.toList());
        //List<Integer> yeniListe =
    }


    // S4: list in elemanlarin karelerinden yeni bir list olusturalim
    public static List<Integer> karelerdenList(List<Integer> list) {
        System.out.println();
        return list.stream().map(t -> t * t).collect(Collectors.toList());
    }


    //S5 : list in elemanlarin karelerinden tekrarsiz yeni bir list olusturalim
    public static List<Integer> karelerTekrarsiz(List<Integer> list) {
        System.out.println();
        return list.stream().map(t -> t * t).distinct().collect(Collectors.toList());
    }


    //S6: listin elemanlarini kucukten buyuge siralayalim
    public static void kücüktenBüyüge(List<Integer> list) {
        System.out.println();
        list.stream().sorted().forEach(t -> System.out.print(t + " "));
    }


    //S7: listin elemanlarini buyukten kucuge siralayalim
    public static void büyüktenKücüge(List<Integer> list) {
        System.out.println();
        list.stream().sorted(Comparator.reverseOrder()).forEach(t -> System.out.print(t + " "));
    }


    // S8: list pozitif elemanlari icn kuplerini bulup birler basamagi 5 olanlardan yeni bir list olusturalim
    public static List<Integer> birlerBasamagi(List<Integer> list) {
        System.out.println();
        return list.stream().filter(t -> t > 0).map(t -> t * t * t).filter(t -> t % 10 == 5).collect(Collectors.toList());
    }

    //S9: list pozitif elemanlari icn karelerini bulup birler basamagi 5 olmayanlardan yeni bir list olusturalim
    public static List<Integer> pozitifKarelerbirlerBasamagi5Olmayan(List<Integer> list) {
        return list.stream().filter(Methods::pozitifMi).map(t -> t * t).filter(t -> t % 10 != 5).collect(Collectors.toList());
    }


    // S10 :list elemanlarini toplamini bulalim
    public static int elemanlarToplami(List<Integer> list) {
        return list.stream().mapToInt(t -> t).sum();
    }


    // S11 : peek ornegi cozelim - negatiflerin karelerinden list olusturalim
    public static List<Integer> negatiflerinKarelerindenList(List<Integer> list) {
        return list.stream().filter(t -> t < 0).map(t -> t * t).collect(Collectors.toList());
    }


    // S12 : listeden 5 den buyuk  sayi var mi?
    public static boolean bestenBüyük(List<Integer> list) {
        return list.stream().anyMatch(t -> t > 5);
    }

    // S13 : listenin tum elemanlari sifirdan kucuk mu?
    public static boolean sifirdanKücükMü(List<Integer> list) {
        return list.stream().allMatch(t -> t > 5);
    }


    // S14: listenin 100 e esit elemani yok mu ?
    public static void yüzeEsitEleman(List<Integer> list) {
        System.out.println(list.stream().anyMatch(t -> t == 100) ? "Var" : "Yok");
    }


    // S15: listenin sifira esit elemani yok mu?
    public static void sifiraEsitEleman(List<Integer> list) {
        System.out.println(list.stream().anyMatch(t -> t == 0) ? "Var" : "Yok");
    }


    // S16:  listenin ilk 5 elemanini topla?
    public static int ilkBesElemanToplami(List<Integer> list) {
        return list.stream().limit(5).mapToInt(t -> t).reduce(Integer::sum).orElseThrow();
    }


    //S17: listenin son bes elemaninin  listele
    public static int sonBesElemanToplami(List<Integer> list) {
        return list.stream().skip(list.size()-5).mapToInt(t -> t).reduce(Integer::sum).orElseThrow();
    }


}