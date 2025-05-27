// Name: AHMAD FIKRI NABIL BIN ZAMRI A24CS0035

@FunctionalInterface
interface shapeService {
    double calculate(double s);
}

@FunctionalInterface
interface printService {
    void execute(double s, shapeService v, shapeService a);
}

public class App {

    public static void cetak(int s, shapeService ac, shapeService vc) {
        System.out.printf("\nVolume : %.2f\nTotal area : %.2f\n", vc.calculate(s), ac.calculate(s));
    }

    public static void main(String[] args) throws Exception {
        shapeService volume = (s) -> s * s * s;
        shapeService area = (s) -> s * s * 6;

        shapeService volumeSphere = (s) -> 4.0/3.0 * Math.PI * Math.pow(s, 3.0);
        shapeService areaSphere = (s) -> 4.0  * Math.PI * Math.pow(s, 2);

        shapeService areaTetra = (s) -> Math.sqrt(3) * Math.pow(s, 2);
        shapeService volumeTetra = (s) -> Math.pow(s, 3) / (6 * Math.sqrt(2));

        printService printing = (s, ac, vc) -> {
             System.out.printf("\nVolume : %.2f\nTotal area : %.2f\n", vc.calculate(s), ac.calculate(s));
        };

        printing.execute(12, volume, area);

        cetak(12, area, volume);
        cetak(11, areaSphere, volumeSphere);
        cetak(23 , areaTetra, volumeTetra);


    }
}
