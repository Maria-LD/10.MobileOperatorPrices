import java.util.Scanner;

public class MobileOperatorPrices {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter term of the contract - \"1 year\" or \"2 years\": ");
            String termOfContract = scanner.nextLine().toLowerCase();
            while (!("1 year".equals(termOfContract)) && !("2 years".equals(termOfContract))) {
                System.out.print("Invalid input! The acceptable options are \"1 year\" or \"2 years\": ");
                termOfContract = scanner.nextLine().toLowerCase();
            }

            System.out.print("Enter type of the contract - \"Small\", \"Middle\", \"Large\" or \"ExtraLarge\": ");
            String typeOfContract = scanner.nextLine().toLowerCase();
            while (!("small".equals(typeOfContract)) && !("middle".equals(typeOfContract)) &&
                    !("large".equals(typeOfContract)) && !("extralarge".equals(typeOfContract))) {
                System.out.print("Invalid input! The acceptable options are \"Small\", \"Middle\", \"Large\" or \"ExtraLarge\": ");
                typeOfContract = scanner.nextLine().toLowerCase();
            }

            System.out.print("Is internet added - \"Yes\" or \"No\": ");
            String internet = scanner.nextLine().toLowerCase();
            while (!("yes".equals(internet)) && !("no".equals(internet))) {
                System.out.print("Invalid input! The acceptable options are \"Yes\" or \"No\": ");
                internet = scanner.nextLine().toLowerCase();
            }

            System.out.print("Enter number of months (1 - 24): ");
            byte numberOfMonths = Byte.parseByte(scanner.nextLine());
            while (numberOfMonths < 1 || numberOfMonths > 24) {
                System.out.print("Invalid input! The number of months could be from 1 to 24: ");
                numberOfMonths = Byte.parseByte(scanner.nextLine());
            }

            double price = 0;

            //price without internet
            if ("1 year".equals(termOfContract)) {
                if ("small".equals(typeOfContract)) {
                    price = 9.98;
                } else if ("middle".equals(typeOfContract)) {
                    price = 18.99;
                } else if ("large".equals(typeOfContract)) {
                    price = 25.98;
                } else if ("extralarge".equals(typeOfContract)) {
                    price = 35.99;
                }


            } else if ("2 years".equals(termOfContract)) {
                if ("small".equals(typeOfContract)) {
                    price = 8.58;
                } else if ("middle".equals(typeOfContract)) {
                    price = 17.09;
                } else if ("large".equals(typeOfContract)) {
                    price = 23.59;
                } else if ("extralarge".equals(typeOfContract)) {
                    price = 31.79;
                }
            }

            //internet added
            if ("yes".equals(internet)) {
                if (price <= 10) {
                    price += 5.50;
                } else if (price <= 30) {
                    price += 4.35;
                } else if (price > 30) {
                    price += 3.85;
                }
            }

            //discount for 2 years
            if ("2 years".equals(termOfContract)) {
                price -= 0.0375 * price;
            }

            //total price
            price *= numberOfMonths;

            System.out.printf("The price the customer should pay: BGN %.2f\n", price);

        } catch (Exception ex) {
            System.out.println("Invalid input! Sorry, start from the beginning!");
        }
    }
}