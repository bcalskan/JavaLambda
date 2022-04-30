package lambdaTutorial;

public class Üniversite {
    /*
    TASK :
    fields --> Universite (String)
               bolum (String)
               ogrcSayisi (int)
               notOrt (int)
               olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.
     */


    private String üniversite;
    private String bölüm;
    private int ögrcSayisi;
    private int notOrt;

    public Üniversite() {
    }

    public Üniversite(String üniversite, String bölüm, int ögrcSayisi, int notOrt) {
        this.üniversite = üniversite;
        this.bölüm = bölüm;
        this.ögrcSayisi = ögrcSayisi;
        this.notOrt = notOrt;
    }

    @Override
    public String toString() {
        return "Üniversite{" +
                "üniversite='" + üniversite + '\'' +
                ", bölüm='" + bölüm + '\'' +
                ", ögrcSayisi=" + ögrcSayisi +
                ", notOrt=" + notOrt +
                '}';
    }

    public String getÜniversite() {
        return üniversite;
    }

    public void setÜniversite(String üniversite) {
        this.üniversite = üniversite;
    }

    public String getBölüm() {
        return bölüm;
    }

    public void setBölüm(String bölüm) {
        this.bölüm = bölüm;
    }

    public int getÖgrcSayisi() {
        return ögrcSayisi;
    }

    public void setÖgrcSayisi(int ögrcSayisi) {
        this.ögrcSayisi = ögrcSayisi;
    }

    public int getNotOrt() {
        return notOrt;
    }

    public void setNotOrt(int notOrt) {
        this.notOrt = notOrt;
    }
}
