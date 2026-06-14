public class Lab_DZ_6 {

    static class NumberThread extends Thread {
        private final String number;
        private final int delay;

        public NumberThread(String number, int delay) {
            this.number = number;
            this.delay = delay;
        }

        @Override
        public void run() {
            try {
                for (int i = 1; i <= 10; i++) {
                    System.out.println("Потік " + number +
                            " | Вивід №" + i);
                    Thread.sleep(delay);
                }
            } catch (InterruptedException e) {
                System.out.println("Потік " + number + " перервано.");
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("=== Домашнє завдання: Потоки ===");

        NumberThread t1 = new NumberThread("1", 1000);
        NumberThread t2 = new NumberThread("2", 2000);
        NumberThread t3 = new NumberThread("3", 3000);

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("=== Роботу завершено ===");
    }
}