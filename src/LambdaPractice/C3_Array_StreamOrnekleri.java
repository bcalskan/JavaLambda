package LambdaPractice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class C3_Array_StreamOrnekleri {
    public static void main(String[] args) {

        // Arraylerde Stream kullanabilmek icin 2 yol vardir
        // 1) Stream <Integer> isim=StreamOf(cevrilecek olan) -> Stream objesi
        // 2) Arrays.stream(arr).  ->  Array sinifindan yararlanarak
        //Array ler collection sinifinda degillerdir..set ve MAp ler gibi degildir..
        // kullanabilmek icin donusum yapilmalidir

        Integer arr1[] = {1, 5, -5, 6, 12, -8, 9, 3, 4};
        arraydenListYap(arr1);
        System.out.println("\n--------------------\n");
        System.out.println(elemanlariniTopla(arr1));
        System.out.println("\n--------------------\n");
        System.out.println(ortalamaBul(arr1));

    }

    //S1: arrayin elemanlarini bir liste yazdiralim
    public static void arraydenListYap(Integer arr1[]) {
        System.out.println(Arrays.stream(arr1).collect(Collectors.toList()));
    }


    //S2: Arrayin elemanlarini toplamini bulalim
    public static int elemanlariniTopla(Integer arr1[]) {
        return Arrays.stream(arr1).mapToInt(t -> t).sum();
    }


    // S3: Array in elemanlarinin ortalamasini bulalim yazdir
    public static Double ortalamaBul(Integer arr1[]) {
        return Arrays.stream(arr1).mapToInt(t -> t).average().orElseThrow();
    }


}
