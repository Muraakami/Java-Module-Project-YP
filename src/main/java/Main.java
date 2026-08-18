import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Здравствуйте :) Вы попали в программу \"24 часа Ле-Мана\"," +
                "которое рассчитывает победителя гонки зная скорость." +
                "\nРасчет происходит по 3 автомобилям.");
        Track arrival = new Track();
        Cars firstCar = new Cars(inputName(1), inputSpeed(1));
        arrival.setWiner(firstCar);
        Cars secondCar = new Cars(inputName(2), inputSpeed(2));
        arrival.setWiner(secondCar);
        Cars thirdCar = new Cars(inputName(3), inputSpeed(3));
        arrival.setWiner(thirdCar);

        System.out.println("Победитель: " + arrival.getWiner());
    }

    static String inputName(int number){
        Scanner scanner = new Scanner(System.in);
        String name = "";
        while(name.isEmpty()) {
            System.out.println("Введите название " + number + "-го автомобиля:");
            name = scanner.nextLine();
            if(name.isEmpty()){
                System.out.print("Вы ничего не ввели, попробуйте снова.\n");
            }else{
                break;
            }
        }
        return name;
    }

    static int inputSpeed(int number){
        Scanner scanner = new Scanner(System.in);
        int speed = -1;
        while (speed <= 0 || speed > 250) {
            System.out.println("Введите скорость " + number + "-го автомобиля (" +
                    "скорость не должна быть ниже 1 и выше 250):");
            //Подсмотрел обработку некорректного ввода чисел (текст) у ИИ
            //не помню, чтобы такое объясняли в курсе, все остальное сделал сам
            if(scanner.hasNextInt()){
                speed = scanner.nextInt();
                if (speed <= 0 || speed > 250) {
                    System.out.println("Неверно введена скорость, попробуйте еще раз");
                }
            }else {
                System.out.println("Неверно введена скорость, попробуйте еще раз");
            }
        }
        return speed;
    }

    public static class Cars{
        private final String name;
        private final int speed;

        Cars(String name, int speed){
            this.name = name;
            this.speed = speed;
        }
        int getSpeed(){
            return this.speed;
        }
        String getName(){
            return this.name;
        }
    }

    public static  class Track{
        private String Winer;
        private int speed;

        Track(){
            this.Winer = "";
            this.speed = -1;
        }

        void setWiner(Cars car){
            if(car.getSpeed() >= this.speed){
                this.Winer = car.getName();
                this.speed = car.getSpeed();
            }
        }

        String getWiner(){
            return this.Winer;
        }
    }
}