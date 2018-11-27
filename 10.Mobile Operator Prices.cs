using System;

namespace MobileOperatorPrices
{
    class MobileOperatorPrices
    {
        static void Main(string[] args)
        {
            try
            {
                Console.Write("Enter term of the contract - \"1 year\" or \"2 years\": ");
                string termOfContract = Console.ReadLine().ToLower();
                while (!("1 year".Equals(termOfContract)) && !("2 years".Equals(termOfContract)))
                {
                    Console.Write("Invalid input! The acceptable options are \"1 year\" or \"2 years\": ");
                    termOfContract = Console.ReadLine().ToLower();
                }

                Console.Write("Enter type of the contract - \"Small\", \"Middle\", \"Large\" or \"ExtraLarge\": ");
                string typeOfContract = Console.ReadLine().ToLower();
                while (!("small".Equals(typeOfContract)) && !("middle".Equals(typeOfContract)) &&
                !("large".Equals(typeOfContract)) && !("extralarge".Equals(typeOfContract)))
                {
                    Console.Write("Invalid input! The acceptable options are \"Small\", \"Middle\", \"Large\" or \"ExtraLarge\": ");
                    typeOfContract = Console.ReadLine().ToLower();
                }

                Console.Write("Is internet added - \"Yes\" or \"No\": ");
                String internet = Console.ReadLine().ToLower();
                while (!("yes".Equals(internet)) && !("no".Equals(internet)))
                {
                    Console.Write("Invalid input! The acceptable options are \"Yes\" or \"No\": ");
                    internet = Console.ReadLine().ToLower();
                }

                Console.Write("Enter number of months (1 - 24): ");
                byte numberOfMonths = byte.Parse(Console.ReadLine());
                while (numberOfMonths < 1 || numberOfMonths > 24)
                {
                    Console.Write("Invalid input! The number of months could be from 1 to 24: ");
                    numberOfMonths = byte.Parse(Console.ReadLine());
                }

                double price = 0;

                //price without internet
                switch (termOfContract)
                {
                    case "1 year":
                        switch (typeOfContract)
                        {
                            case "small": price = 9.98; break;
                            case "middle": price = 18.99; break;
                            case "large": price = 25.98; break;
                            case "extralarge": price = 35.99; break;
                        }
                        break;

                    case "2 years":
                        switch (typeOfContract)
                        {
                            case "small": price = 8.58; break;
                            case "middle": price = 17.09; break;
                            case "large": price = 23.59; break;
                            case "extralarge": price = 31.79; break;
                        }
                        break;
                }

                //internet added
                if ("yes".Equals(internet))
                {
                    if (price <= 10)
                    {
                        price += 5.50;
                    }
                    else if (price > 10 && price <= 30)
                    {
                        price += 4.35;
                    }
                    else if (price > 30)
                    {
                        price += 3.85;
                    }
                }

                //discount for 2 years
                if ("2 years".Equals(termOfContract))
                {
                    price -= 0.0375 * price;
                }

                //total price
                price *= numberOfMonths;

                Console.WriteLine($"The price the customer should pay: BGN {price:F2}");

            } catch
            {
                Console.WriteLine("Invalid input! Sorry, start from the beginning!");
            }

        }
    }
}