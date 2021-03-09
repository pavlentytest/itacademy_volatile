package ru.samsung.itschool.mdev;

public class Main {

    // волатильность - изменчивость
    private volatile boolean flag = false;

    // эмуляция интерфейса
    Runnable ui = () -> {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("Интерфейс остановлен!");
    };

    // логика игры
    Runnable game = new Runnable() {
        @Override
        public void run() {
            while(!flag) {
                // логика игры
            }
            System.out.println("Игра остановлена!");
        }
    };

    public void startThreads() {
        new Thread(ui).start();
        System.out.println("Интерфейс запущен!");
        new Thread(game).start();
        System.out.println("Игра запущена!");
    }

    public static void main(String[] args) {
        new Main().startThreads();
    }
}
