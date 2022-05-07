package lambdaTutorial;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda06 {
    public static void main(String[] args) throws IOException {
        //TASK 01 --> haluk.txt dosyasini okuyunuz.(Console'a yazdiriniz)
        System.out.println("\n*** haluk.txt dosyasini okuyunuz -->  ");
        //Files.lines(Paths.get("src/lambdaTutorial/metin")).forEach(System.out::println);
        Path obj = Path.of("src/lambdaTutorial/metin"); //path objeye atandi
        Stream<String> akis = Files.lines(obj);
        //1.YOL
        Files.lines(obj).forEach(System.out::println);
        //2.YOL
        akis.forEach(System.out::println);


        //TASK 02 --> haluk.txt dosyasini buyuk harflerle okuyunuz.(Console'a buyuk harflerle yazdiriniz)
        System.out.println("\n*** haluk.txt dosyasini buyuk harflerle okuyunuz -->  ");
        Files.lines(Paths.get("src/lambdaTutorial/metin")).map(String::toUpperCase).forEach(System.out::println);


        //TASK 03 --> haluk.txt dosyasindaki ilk satiri kucuk harflerle yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki ilk satiri kucuk harflerle okuyunuz 01 -->  ");
        //1.YOL -- limit();
        Files.lines(Paths.get("src/lambdaTutorial/metin")).map(String::toLowerCase).forEach(System.out::println);
        //2.YOL -- findFirst();
        System.out.println(Files.lines(Paths.get("src/lambdaTutorial/metin")).map(String::toLowerCase).findFirst());


        //TASK 04 --> haluk.txt dosyasinda "basari" kelimesinin kac satirda gectiginiz yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda basari kelimesinin kac satirda gectiginiz yazdiriniz -->  ");
        System.out.println(Files.lines(obj).map(String::toLowerCase).filter(t -> t.contains("basari")).count());


        //TASK 05 --> haluk.txt dosyasindaki farkli kelimeleri  yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki farkli kelimeleri  yazdiriniz. -->  ");
        //1.YOL --> distinct();
        System.out.println(Files.lines(obj).
                map(t -> t.split(" ")). //satirlardaki kelimeler arraye atandi
                        flatMap(Arrays::stream).//2D arraydeki elemanlar tek eleman olarak akisa alindi
                        distinct(). //akistaki elemanlar tekrarsiz hale getirildi
                        collect(Collectors.toList())); //liste atandi

        //2.YOL --> toSet();
        System.out.println(Files.lines(obj).map(t -> t.split(" ")).collect(Collectors.toSet()));

        /*
         Stream.flatMap, adıyla tahmin edilebileceği gibi, bir map ve flat işleminin birleşimidir. Bu, ilk önce elemanlarınıza bir
         fonksiyon uyguladığınız ve daha sonra düzleştirdiğiniz anlamına gelir.
         Stream.map yalnızca akışı düzleştirmeden bir işlevi uygular.

         Bir akışın düzleştirme'in neyi içerdiğini anlamak için, "iki seviye" olan [ [1,2,3],[4,5,6],[7,8,9] ] gibi bir yapı düşünün.
         Bunun düzleştirilmesi, "bir seviye" yapısında dönüştürülmesi anlamına gelir: [ 1,2,3,4,5,6,7,8,9 ].
         flatMap yöntemi, bir akışın her bir değerini başka bir akışla değiştirmenizi sağlar
         ve ardından oluşturulan tüm akışları tek bir akışa birleştirir.
        */


        //TASK 06 --> haluk.txt dosyasindaki tum kelimeleri natural order  yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki tum kelimeleri natural order  yazdiriniz. -->  ");
        Files.lines(obj).map(t -> t.split(" ")).flatMap(Arrays::stream).
                sorted().//natural order siraladi
                forEach(System.out::println);


        //TASK 07 --> haluk.txt dosyasinda "basari" kelimesinin kac kere gectigini buyuk harf kucuk harf bagımsız yaziniz.
        System.out.println("\n*** haluk.txt dosyasinda basari kelimesinin kac kere gectigini  yazdiriniz. -->  ");
        System.out.println(Files.lines(obj).map(t -> t.toLowerCase().split(" ")).flatMap(Arrays::stream).filter(t -> t.equals("basari")).count());


        //TASK 08 --> haluk.txt dosyasinda "a" harfi gecen kelimelerin sayisini ekrana yazdiran programi yaziniz
        System.out.println("\n*** haluk.txt dosyasinda a harfi gecen kelimelerin sayisini ekrana yazdiran programi yazdiriniz. -->  ");
        System.out.println(Files.lines(obj).map(t -> t.toLowerCase().split(" ")).flatMap(Arrays::stream).filter(t -> t.contains("a")).count());


        //TASK 09 --> haluk.txt dosyasinda icinde "a" harfi gecen kelimeleri yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda a harfi gecen kelimeler yazdiriniz. -->  ");
        System.out.println(Files.lines(obj).map(t -> t.split(" ")).flatMap(Arrays::stream).filter(t -> t.contains("a")).collect(Collectors.toList()));


        //TASK 10 --> haluk.txt dosyasinda kac /farklı harf kullanildigini yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda kac /farklı harf kullanildigini  yazdiriniz. -->  ");
        System.out.println(Files.lines(obj).
                map(t -> t.replaceAll("\\W", "").
                        replaceAll("\\d", "").
                        split(" ")).
                flatMap(Arrays::stream).
                distinct().
                count());


        //TASK 11 --> haluk.txt dosyasinda kac farkli kelime kullanildigini yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. -->  ");
        System.out.println(Files.lines(obj).map(t -> t.replaceAll("[.!,:)(\\-]", "").split(" ")).flatMap(Arrays::stream).distinct().count());
        //System.out.println(Files.lines(obj).map(t -> t.split(" ")).flatMap(Arrays::stream).distinct().count());


        //TASK 12 --> haluk.txt dosyasinda  farkli kelimeleri print ediniz
        System.out.println("\n*** haluk.txt dosyasinda  farkli kelimeleri print ediniz -->  ");
        Files.lines(obj).map(t -> t.split(" ")).flatMap(Arrays::stream).collect(Collectors.toSet()).forEach(System.out::println);
        //2.YOL
        Files.lines(obj).map(t -> t.replaceAll("[.!,:)(\\-]", "").split(" ")).flatMap(Arrays::stream).distinct().forEach(System.out::println);

    }
}

