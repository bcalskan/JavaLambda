import java.util.*;

public class Lambda02 {
    public static void main(String[] args) {
        List<Integer> sayi = new ArrayList<>(Arrays.asList(4, 2, 6, 11, -5, 7, 3, 15));
        ciftKarePrint(sayi); //16 4 36
        System.out.println("\n*********************");
        tekKarePrint(sayi); //1332 344 28 3376
        System.out.println("\n*********************");
        ciftKarekökPrint(sayi);
        System.out.println("\n*********************");
        enBüyük(sayi);
        System.out.println("\n*********************");
        ciftKareEnBüyük(sayi);
        System.out.println("\n*********************");
        elemanTopla(sayi);
        System.out.println("\n*********************");
        ciftCarpim(sayi);
        System.out.println("\n*********************");
        minBul(sayi);
        System.out.println("\n*********************");
        bestenBüyükenKücükTek(sayi);
        System.out.println("\n*********************");
        ciftElemanKücüktenBüyüge(sayi);
        System.out.println("\n*********************");
        tekKareBkPrint(sayi);
    }

    // Task : Functional Programming ile listin cift elemanlarinin  karelerini ayni satirda aralarina bosluk bırakarak print ediniz
    public static void ciftKarePrint(List<Integer> sayi) {
        sayi.stream().filter(Lambda01::ciftBul).map(t -> t * t).forEach(Lambda01::yazdir);
        //map() stream icerisindeki elemanlari baska tiplere dönüstürmek veya
        //üzerinde islem yapmak(update) icin map kullanilmaktadir
    }

    // Task : Functional Programming ile listin tek elemanlarinin  kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak print edin
    public static void tekKarePrint(List<Integer> sayi) {
        sayi.stream().filter(t -> t % 2 != 0).map(t -> (t * t * t) + 1).forEach(Lambda01::yazdir);
    }

    // Task : Functional Programming ile listin cift elemanlarinin karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void ciftKarekökPrint(List<Integer> sayi) {
        sayi.stream().filter(Lambda01::ciftBul).map(Math::sqrt).forEach(t -> System.out.print(t + " "));
    }

    // Task : list'in en buyuk elemanini yazdiriniz
    public static void enBüyük(List<Integer> sayi) {
        Optional<Integer> maxSayi = sayi.stream().reduce(Math::max);//akisa giren elemanlari action sonrasi tek eleman haline getirir
        System.out.println(maxSayi);
        System.out.println("Halukca : " + sayi.stream().reduce(Math::max));
        /*
        reduce()-->azaltmak ... bir cok datayi tek bir dataya(max min carp top vs islemlerde) cevirmek icin kullanilir.
        kullanımı yaygındır pratiktir.
        Bir Stream içerisindeki verilerin teker teker işlenmesidir. Teker teker işleme sürecinde, bir önceki adımda elde edilen sonuç
        bir sonraki adıma girdi olarak sunulmaktadır. Bu sayede yığılmlı bir hesaplama süreci elde edilmiş olmaktadır.
        reduce metodu ilk parametrede identity değeri, ikinci parametrede ise BinaryOperator türünden bir obj kullanılır.
        reduce işleminde bir önceki hesaplanmış değer ile sıradaki değer bir işleme tabi tutulmaktadır.
        İşleme başlarken bir önceki değer olmadığı için bu değer identity parametresinde tanımlanmaktadır.
        */
    }

    // Task : List'in cift elemanlarin karelerinin en buyugunu print ediniz
    public static void ciftKareEnBüyük(List<Integer> sayi) {
        System.out.println(sayi.stream().filter(Lambda01::ciftBul).map(t -> t * t).reduce(Math::max));

        System.out.println(sayi.stream().filter(Lambda01::ciftBul).map(t -> t * t).reduce(Integer::max));//spesifik class daha hizli run olur
    }

    // Task : List'teki tum elemanlarin toplamini yazdiriniz. --->Lambda expression
    public static void elemanTopla(List<Integer> sayi) {
        //sayi.stream().reduce(Integer::sum); --> method ref
        int toplam = sayi.stream().reduce(0, (a, b) -> a + b); //--> Lambda expression
        System.out.println(toplam);
        /*
        a ilk degerini her zaman atanan degerden alir(identity).
        b degerini her zaman stream()´den (akistan) alir.
        a ilk degerinden sonraki her degeri action´dan(islemden) alir
         */

        //Method Ref...
        Optional<Integer> topla = sayi.stream().reduce(Integer::sum);
        System.out.println("met ref : " + sayi.stream().reduce(Integer::sum));
    }

    // Task : List'teki cift elemanlarin carpimini  yazdiriniz.
    public static void ciftCarpim(List<Integer> sayi) {
        int carpim = sayi.stream().filter(Lambda01::ciftBul).reduce(1, (a, b) -> a * b);
        System.out.println(carpim); //--expression

        //Method ref
        System.out.println(sayi.stream().filter(Lambda01::ciftBul).reduce(Math::multiplyExact));
    }

    // Task : List'teki elemanlardan en kucugunu 4 farklı yontem ile print ediniz.
    public static void minBul(List<Integer> sayi) {
        //1. yontem Method Reference --> Integer class
        Optional<Integer> minSayiInteger = sayi.stream().reduce(Integer::min);
        System.out.println("Min sayi integer : " + minSayiInteger);
        //2. yontem Method Reference --> Math class
        Optional<Integer> minSayiMath = sayi.stream().reduce(Math::min);
        System.out.println("Min sayi Math : " + minSayiMath);
        //3. yontem Lambda Expression
        int minSayiLambda = (sayi.stream().reduce(Integer.MAX_VALUE, (x, y) -> x < y ? x : y));
        System.out.println("Min sayi lambda : " + minSayiLambda);
        //4. yontem Method Reference --> Haluk class
        Optional<Integer> minSayiHaluk = sayi.stream().reduce(Lambda02::byHalukMin);
        System.out.println("Min sayi Haluk : " + minSayiHaluk);
    }

    public static int byHalukMin(int a, int b) {
        return a < b ? a : b;  //bu method kendisine verilen iki int degerin en kücügünü return eder
    }

    // Task : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.
    public static void bestenBüyükenKücükTek(List<Integer> sayi) {
        System.out.println(sayi.stream().filter(t -> t > 5 && t % 2 != 0).reduce(Lambda02::byHalukMin));
    }

    // Task : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.
    public static void ciftElemanKücüktenBüyüge(List<Integer> sayi) {
        sayi.stream().filter(Lambda01::ciftBul).map(t -> t * t).sorted().forEach(Lambda01::yazdir);
        //sorted() => Doğal düzene göre sıralanmış, bu akışın elemanlarında oluşan bir akış döndürür.
        //Sorted() methodu tekrarlı kullanılırsa en son kullanılan aktif olur.

        /*
        sorted() --> ici bos olursa default siralar
        sorted(Comperator.reverseOrder()) --> girilen veriye/methoda göre siralar
         */

    }
    // Task : list'in tek  elemanlarinin kareleri ni buykten kucuge  print ediniz.
    public static void tekKareBkPrint(List<Integer> sayi) {
        sayi.//akıs kaynagı
                stream().//akısa alındı
                filter(t -> t % 2 != 0).//tek elemnlar fitrlenedi
                map(t -> t * t).//fitrelenen cift sayı karesi alındı
                sorted(Comparator.reverseOrder()).//karesi alınan elemanlar ters(b->k) sıralandı
                forEach(Lambda01::yazdir);//print edildi
    }
}
