import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

    // Task : Functional Programming ile listin cift elemanlarinin   karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz
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

}
