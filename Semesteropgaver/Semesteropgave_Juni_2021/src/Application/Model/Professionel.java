package Application.Model;

public class Professionel extends Spiller {
    private double kampHonorar;

    public Professionel(String navn, int årgang, double kampHonorar) {
        super(navn, årgang);
        this.kampHonorar = kampHonorar;
    }

    public double getKampHonorar() {
        return kampHonorar;
    }

    @Override
    public double kampHonorar() {
        double afbud = 0;
        for (Deltagelse deltagelse : super.getDeltagelser()) {
            if (deltagelse.isAfbud()) {
                afbud++;
            }
        }
        return (afbud/super.getDeltagelser().size())*kampHonorar;
    }
}
