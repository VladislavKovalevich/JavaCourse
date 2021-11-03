package epam.java.chapter4.task3;

import epam.java.chapter4.task3.action.CountryAction;
import epam.java.chapter4.task3.entity.City;
import epam.java.chapter4.task3.entity.Country;
import epam.java.chapter4.task3.entity.District;
import epam.java.chapter4.task3.entity.Region;

/**
 * Создать объект класса Государство, используя классы Область, Район, Город. Методы: вывести на консоль
 * столицу, количество областей, площадь, областные центры.
 */
public class Main {
    public static void main(String[] args) {
        Country country;
        CountryAction countryAction;
        Region[] regions;

        regions = new Region[]{
                new Region("Минская область", new City("Минск"),
                        new District[]{
                                new District(new City("Молодечно")),
                                new District(new City("Вилейка")),
                                new District(new City("Слуцк")),
                        }),
                new Region("Гродненская облсать", new City("Гродно"),
                        new District[]{
                                new District(new City("Лида")),
                                new District(new City("Слоним")),
                                new District(new City("Волковыск")),
                        }),
                new Region("Брестская область", new City("Брест"),
                        new District[]{
                                new District(new City("Кобрин")),
                                new District(new City("Барановичи")),
                                new District(new City("Иваново")),
                        }),
                new Region("Витебская область", new City("Витебск"),
                        new District[]{
                                new District(new City("Полоцк")),
                                new District(new City("Поставы")),
                                new District(new City("Докшищы")),
                        }),
        };

        country = new Country("Беларусь", new City("Минск"), regions, 207000);
        countryAction = new CountryAction();

        System.out.println("Площадь страны: " + countryAction.getCountrySquare(country) + "\n");
        System.out.println("Столица: " + countryAction.getCapital(country) + "\n");
        System.out.println("Количство областей: " + countryAction.getRegionCount(country) + "\n");

        StringBuilder stringBuilder = new StringBuilder();

        for (City c: countryAction.getRegionCenterCities(country)) {
            stringBuilder.append(" - ").append(c.getName()).append("\n");
        }

        System.out.println("Областные центры:\n" + stringBuilder);
    }
}
