package logic;

import cars.Car;

import java.util.*;

public class Method {
    public void addCar(List<Car> list, String mark, String model, int year, int price, String number) {
        Car car = new Car(mark, model, year, price, number);
        list.add(car);
    }
    public void removeCar(int carToDelete, List<Car> list) {
        if (list.isEmpty()) {
            return;
        }
        boolean remove = list.removeIf(car -> car.getId() == carToDelete);
        if (!remove) {
            return;
        }
    }

    public void showAllCars(List<Car> list) {
        if (list.isEmpty()) {
            return;
        }
        list.forEach(System.out::println);
    }

    public List<Car> searchMarkAndSortYear(String mark, List<Car> list) {
        if (list.isEmpty()) {
            return null;
        }
        List<Car> tempList = new ArrayList<>();
        list.forEach(car -> {
            if (car.getMark().equals(mark))
                tempList.add(car);
        });
        Collections.sort(tempList, Comparator.comparingInt(Car::getYear));
        return tempList;

    }

    public List<Car> searchMarkAndYear(String mark, List<Car> list, int year) {
        if (list.isEmpty()) {
            return null;
        }
        List<Car> tempList = new ArrayList<>();
        list.forEach(car -> {
            int now  = 2022;
            int minus = now - car.getYear();
            if (car.getMark().equals(mark)) {
                if(minus > year) {
                    tempList.add(car);
                }
            }
        });
        return tempList;
    }

    public List<Car> searchYearAndPrice(List<Car> list, int enterY, int enterP) {
        if (list.isEmpty()) {
            return null;
        }
        List<Car> tempList = new ArrayList<>();
        list.forEach(car -> {
            if (enterY == car.getYear()) {
                if(car.getPrice() > enterP)
                    tempList.add(car);
            }
        });
        return tempList;
    }

    public boolean inputValidate(String input) {
        if (input.contains(" ") || input.contains("\n") ||
                input.contains("\t") || input.isEmpty()) {
            return false;
        }
        return true;
    }

    public List<Car> printSortPriceAndYear(List<Car> list){
        list.sort(null);
        for(Car car : list ){
            System.out.println(car);
        }

        return null;
    }

    public static <T> List<T> convertToList(T[] arr)
    {
        List<T> list = new ArrayList<>();
        for (T i: arr) {
            list.add(i);
        }
        return list;
    }

    public static List<Car> markSort(List<Car> list){
        Map<String, List<Car>> carMap = new HashMap<>();
        for (Car car : list) {
            String mark = car.getMark();
            if (!carMap.containsKey(mark)) {
                carMap.put(mark, new ArrayList<>());
            }
            carMap.get(mark).add(car);
        }

        for (String mark : carMap.keySet()) {
            System.out.println("Mark: " + mark);
            List<Car> carList = carMap.get(mark);
            for (Car car : carList) {
                System.out.println("Car{" +
                        "id=" + car.getId() + ", model='" + car.getModel() + '\'' + ", year=" + car.getYear() + ", price=" + car.getPrice() + "$" + ", number=" + car.getNumber() + '}');
            }
            System.out.println();
        }

        return list;
    }



}
