package LambdaPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class C2_StringList_StreamOrnekleri {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Java");
        list.add("ogrenmek");
        list.add("cok");
        list.add("eglenceliydi");
        list.add("lambda");
        list.add("gelince");
        list.add("Daha");
        list.add("da");
        list.add("Cok");
        list.add("Eglenceli");
        list.add("Oldu");

        System.out.println(dVeyaCListele(list));
        System.out.println("\n----------------\n");
        yildizEkle(list);
        System.out.println("\n----------------\n");
        System.out.println(alfabetikSirala(list));
        System.out.println("\n----------------\n");
        System.out.println(lHarfiniSil(list));
        System.out.println("\n----------------\n");
        System.out.println(eIleYeniListe(list));
        System.out.println("\n----------------\n");

        System.out.println("\n----------------\n");


    }

    // S1: ilk harfi d ve ya c olanlari listeleyelim
    public static List<String> dVeyaCListele(List<String> list) {
        return list.stream().filter(t -> t.startsWith("d") || t.startsWith("c")).collect(Collectors.toList());
    }


    //S2: tum stringlerin basina ve sonuna yildiz ekleyerek yazdiralim
    public static void yildizEkle(List<String> list) {
        list.stream().map(t -> "*" + t + "*").forEach(t -> System.out.print(t + " "));

    }


    //S3: alfabedik  gore siralayalim list olarak
    public static List<String> alfabetikSirala(List<String> list) {
        return list.stream().sorted().collect(Collectors.toList());
    }


    //S4: tum 'l' leri silelim yazdiralim
    public static List<String> lHarfiniSil(List<String> list) {
        return list.stream().map(t -> t.replaceAll("l", "")).collect(Collectors.toList());
    }


    //S5 : icinde e olanlardan yeni bir list olusturunuz
    public static List<String> eIleYeniListe(List<String> list) {
        return list.stream().filter(t -> t.contains("e")).collect(Collectors.toList());
    }


    // S6 : ilk harfini 3 kere tekrar edip yazalim ornek jjjava gibi


    // S7: tum elemanlarin ilk harfini buyuk digerlerini kucuk yaziniz


    // S8: uzunlugu 4 ve 6 olanlar haric bir liste olusturunuz


}
