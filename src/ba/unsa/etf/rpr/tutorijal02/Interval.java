package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double pocetna, krajnja;
    private boolean pocetnaPripada, krajnjaPripada;


    public double getPocetna() {
        return pocetna;
    }

    public Interval(double pocetna, double krajnja, boolean pocetnaPripada, boolean krajnjaPripada) {
        if(pocetna > krajnja) throw new IllegalArgumentException("Pocetna veca od krajnje");
        this.pocetna = pocetna; this.krajnja = krajnja; this.pocetnaPripada = pocetnaPripada; this.krajnjaPripada = krajnjaPripada;
    }
    public Interval() {
        this.pocetna = 0; this.krajnja = 0; this.pocetnaPripada = false; this.krajnjaPripada = false;
    }

    public double getKrajnja() {
        return krajnja;
    }

    public boolean isPocetnaPripada() {
        return pocetnaPripada;
    }

    public boolean isKrajnjaPripada() {
        return krajnjaPripada;
    }

    public boolean isNull() {
        if(getPocetna()==0 && getKrajnja() == 0 &&  !isKrajnjaPripada() && !isPocetnaPripada())
            return true;
        return false;
    }
    public boolean isIn(double tacka) {
       if(isPocetnaPripada() && isKrajnjaPripada() && tacka >= getPocetna() && tacka <= getKrajnja()) {
           return true;
       }
       else if(isPocetnaPripada() && !isKrajnjaPripada() && tacka >= getPocetna() && tacka < getKrajnja()) {
           return true;
       }
       else if(!isPocetnaPripada() && isKrajnjaPripada() && tacka > getPocetna() && tacka <= getKrajnja())
           return true;

       else if(!isPocetnaPripada() && !isKrajnjaPripada() && tacka > getPocetna() && tacka < getKrajnja())
           return true;
        return false;
    }
    @Override
    public String toString() {
        String s1, s2;
        if(pocetnaPripada) s1 = "[";
        else s1 = "(";
        if(krajnjaPripada) s2 = "]";
        else s2 = ")";
        if (isNull()) return "()";
        return s1 + getPocetna() + "," + getKrajnja() + s2;
    }
    @Override
    public boolean equals(Object o) {
        Interval i1 = (Interval) o;
        return (this.getPocetna() == i1.getPocetna() && this.getKrajnja() == i1.getKrajnja()
                && this.isPocetnaPripada() == i1.isPocetnaPripada() && this.isKrajnjaPripada() == i1.isKrajnjaPripada());

    }
    public Interval intersect (Interval i) {
        double pocetna3, krajnja3;
        boolean pocetnaPripada, krajnjaPripada;
        if(this.getPocetna() < i.getPocetna()) {
            pocetna3 = i.getPocetna();
            pocetnaPripada = i.isPocetnaPripada();
        }
        else {
            pocetna3 = this.getPocetna();
            pocetnaPripada = this.isPocetnaPripada();
        }
        if(this.getKrajnja() < i.getKrajnja()) {
            krajnja3 = this.getKrajnja();
            krajnjaPripada = this.isKrajnjaPripada();
        }
        else {
            krajnja3 = i.getKrajnja();
            krajnjaPripada = i.isKrajnjaPripada();
        }
        Interval i3 = new Interval(pocetna3,krajnja3,pocetnaPripada,krajnjaPripada);
        return i3;
    }
    public static Interval intersect (Interval i1, Interval i2) {
        double pocetna3, krajnja3;
        boolean pocetnaPripada, krajnjaPripada;
        if(i1.getPocetna() < i2.getPocetna()) {
            pocetna3 = i2.getPocetna();
            pocetnaPripada = i2.isPocetnaPripada();
        }
        else {
            pocetna3 = i1.getPocetna();
            pocetnaPripada = i1.isPocetnaPripada();
        }
        if(i1.getKrajnja() < i2.getKrajnja()) {
            krajnja3 = i1.getKrajnja();
            krajnjaPripada = i1.isKrajnjaPripada();
        }
        else {
            krajnja3 = i2.getKrajnja();
            krajnjaPripada = i2.isKrajnjaPripada();
        }
        Interval i3 = new Interval(pocetna3,krajnja3,pocetnaPripada,krajnjaPripada);
        return i3;
    }




}
