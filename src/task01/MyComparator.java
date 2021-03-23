package task01;

import java.util.Comparator;


public class MyComparator {
    // сортировка по доп параметру
    public static Comparator<Car> CarAddParamCompare = new Comparator<Car>() {
        @Override
        public int compare(Car o1, Car o2) {
            int nameDiff = o1.getAddParam().compareTo(o2.getAddParam());
            return nameDiff;
        }
    };

    // сортировка по пробегу
    public static Comparator<Car> carMileageCompare = new Comparator<Car>() {
        @Override
        public int compare(Car o1, Car o2) {
            if ((o1.getMileage()-o2.getMileage() > 0))
                return 1;

            return -1;
        }
    };
}
