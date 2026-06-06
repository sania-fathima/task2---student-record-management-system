public class AutoSaveThread extends Thread {

    private StudentManager manager;

    public AutoSaveThread(StudentManager manager) {
        this.manager = manager;
    }

    @Override
    public void run() {

        while (true) {

            try {

                manager.saveToFile();

                Thread.sleep(30000);

            } catch (InterruptedException e) {

                System.out.println(
                        "Auto-save stopped.");
                return;
            }
        }
    }
}
