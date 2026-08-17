import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Cars> automobile = new ArrayList<>();
        System.out.println("Здравствуйте :) Вы попали в программу \"24 часа Ле-Мана\"," +
                "которое рассчитывает победителя гонки зная скорость." +
                "\nРасчет происходит по 3 автомобилям.");
        for(int i = 1; i < 4; i++) {
            Scanner scanner = new Scanner(System.in);
            String name;
            Cars car;
            while(true) {
                System.out.println("Введите название " + i + "-го автомобиля:");
                name = scanner.nextLine();
                if (!name.isEmpty()) {
                    car = new Cars(name);
                    break;
                } else {
                    System.out.print("Вы ничего не ввели, попробуйте снова.\n");
                }
            }
            int speed;
            while (true) {
                System.out.println("Введите скорость " + i + "-го автомобиля (" +
                        "скорость не должна быть ниже 1 и выше 250):");
                //Подсмотрел обработку некорректного ввода чисел (текст) у ИИ
                //не помню, чтобы такое объясняли в курсе, все остальное сделал сам
                if(scanner.hasNextInt()){
                    speed = scanner.nextInt();
                    if (speed <= 0 || speed > 250) {
                        System.out.println("Неверно введена скорость, попробуйте еще раз");
                    }else {
                        break;
                    }
                }else {
                    System.out.println("Неверно введена скорость, попробуйте еще раз");
                }
            }
            car.setSpeed(speed);
            automobile.add(car);
        }

        Track arrival = new Track(automobile);
        System.out.println("Победитель: " + arrival.getWiner());
    }

    public static class Cars{
        private final String name;
        private int speed;

        Cars(String name){
            this.name = name;
        }

        void setSpeed(int speed){
            this.speed = speed;
        }
        int getSpeed(){
            return this.speed;
        }

        String getName(){return this.name; }
    }

    public static  class Track{
        private final String Winer;

        Track(ArrayList<Cars> cars){
            String winer = "";
            int speed = 0;
            for(Cars car : cars){
                if(car.getSpeed() >= speed){
                    winer = car.getName();
                }
            }

            this.Winer = winer;
        }

        String getWiner(){
            return this.Winer;
        }
    }
}