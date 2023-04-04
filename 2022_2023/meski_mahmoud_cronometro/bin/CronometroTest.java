public class CronometroTest {
    public static void main(String[] args) {
        CronometroView view = new CronometroView();
        CronometroModel model = new CronometroModel();
        CronometroController controller = new CronometroController(view, model);
        }
}
