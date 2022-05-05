package lambdaTutorial;

import java.util.stream.IntStream;

public class Lambda05 {
    public static void main(String[] args) {
        System.out.println("TASK 01 -->" + uzunTopla(10));
        System.out.println("TASK 01 -->" + kisaTopla(10));
        System.out.println("   ***   ");

        System.out.println("TASK 02 -->" + ciftTopla(5));
        System.out.println("   ***   ");

        System.out.println("TASK 03 -->" + ilkXCiftSayi(10));
        System.out.println("   ***   ");

        System.out.println("TASK 04 -->" + ilkXTekSayi(10));
        System.out.println("   ***   ");

        System.out.println("TASK 05 -->");
        ilkXKuvveti(7);
        System.out.println("   ***   ");

        System.out.println("TASK 06 -->");
        istenenSayininIlkXKuvveti(2, 5);
        System.out.println("   ***   ");

        System.out.println("TASK 07 -->");
        faktoriyel(3);
        System.out.println("   ***   ");

        System.out.println("TASK 08 -->");
        System.out.println(xKuvveti(2, 5));
        System.out.println("   ***   ");

    }

    //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar tamsayilari toplayan bir program create ediniz.

    //Structured(AMELE) Programming
    public static int uzunTopla(int x) {
        int toplam = 0;
        for (int i = 1; i < x; i++) {
            toplam += i;
        }
        return toplam;
    }

    //Functional(cincix Programming
    public static int kisaTopla(int x) {
        return IntStream.range(1, x + 1).sum();
    }


    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.
    public static int ciftTopla(int x) {
        return IntStream.rangeClosed(1, x).filter(Lambda01::ciftBul).sum();

    }


    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.
    public static int ilkXCiftSayi(int x) {
        return IntStream.iterate(2, t -> t + 2). //2den sonsuza kadar elemnalari 2 arttirarak akisa alir
                limit(x).sum();

        //iterate(seed, repeat action) --> seed'den başlayarak repeat action'a göre  sonsuza kadar elemanları akısa koy
    }

    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.
    public static int ilkXTekSayi(int x) {
        return IntStream.iterate(1, t -> t + 2).limit(x).sum();
    }

    //TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void ilkXKuvveti(int x) {
        IntStream.iterate(2, t -> t * 2).limit(x).forEach(Lambda01::yazdir);
    }

    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void istenenSayininIlkXKuvveti(int istenenSayi, int x) {
        IntStream.iterate(istenenSayi, t -> t * istenenSayi).limit(x).forEach(Lambda01::yazdir);
    }

    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.
    public static void faktoriyel(int x) {
        System.out.println(IntStream.rangeClosed(1, x).
                // reduce(Math::multiplyExact);
                        reduce(1, (a, b) -> a * b));

    }

    //TASK 08 --> Istenilen bir sayinin  x. kuvvetini ekrana yazdiran programi  create ediniz.
    public static int xKuvveti (int istenenSayi, int x) {
        return IntStream.
                iterate(istenenSayi,t-> t*istenenSayi).
                limit(x).skip(x-1).reduce(0,(t,u)->u);

    }
}


