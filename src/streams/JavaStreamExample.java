package streams;

import java.util.*;
import java.util.stream.Collectors;

class Product {
    int id;
    String name;
    float price;
    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
public class JavaStreamExample {
    public static void main(String[] args) throws Exception {
        List<Product> productsList = new ArrayList<Product>();
        //Adding Products
        productsList.add(new Product(1,"HP Laptop",25000f));
        productsList.add(new Product(2,"Dell Laptop",30000f));
        productsList.add(new Product(3,"Lenevo Laptop",28000f));
        productsList.add(new Product(4,"Sony Laptop",29000f));
        productsList.add(new Product(5,"Apple Laptop",90000f));
        List<Float> productPriceList = new ArrayList<Float>();
        for(Product product: productsList){

            // filtering data of list
            if(product.price<30000){
                productPriceList.add(product.price);    // adding price to a productPriceList
            }
        }
        //System.out.println(productPriceList);   // displaying data

        List<Integer> productPriceList2 = new ArrayList<>();

        productPriceList2 = productsList.stream()
                .filter(product -> product.price < 30000)
                .map(product -> (int)product.price)
                .skip(2)
                .collect(Collectors.toList());

        productsList.stream()
                .filter(prod -> prod.price == 30000)
                        .forEach(prod -> System.out.println(prod.name));

        List<String> letters = Arrays.asList("a", "b", "c", "d", "e");
        System.out.println(letters.stream()
                .reduce("", (str, letter)-> str + letter.toUpperCase()));

        System.out.println(letters.stream()
                .reduce("", String::concat));

        //sum by map and reduce
        float su = productsList.stream()
                .map(prod -> prod.price)
                .reduce(0.0f, (sum, price)-> sum + price);
        System.out.println(su);

        //sum by
        float su2 = productsList.stream()
                .reduce(0.0f, (sum, prod) -> sum + prod.price ,Float::sum);
        System.out.println(su2);
        //System.out.println(productPriceList2);

        List<Integer> ages = Arrays.asList(25, 30, 45, 28, 32);
        System.out.println(ages.stream()
                .reduce(0, Integer::sum));

        List<Integer> listOfIntegers = Arrays.asList(1, 2, 3, 4, 56, 7, 89, 10);
        Integer a = listOfIntegers.stream()
                .mapToInt(no -> no)
                .max().orElseThrow(Exception::new);
        System.out.println(a);

        Integer min = listOfIntegers.stream()
                .mapToInt(v -> v)
                .min().orElseThrow(Exception::new);
        System.out.println(min);

        Integer b = listOfIntegers.stream()
                .max((prod1, prod2) -> prod1 > prod2 ? 1 : -1)
                .get();

        System.out.println(b);

        Set<Integer> set = productsList.stream()
                .filter(prod->prod.price<=30000)
                .map(prod -> (int)prod.price)
                .collect(Collectors.toSet());
        System.out.println(set);


        productsList.stream()
                .filter(prod->prod.price<=30000)
                .forEach(prod -> System.out.println(prod.name));

        Map<String, Integer> map = productsList.stream()
                .filter(prod->prod.price<=30000)
                .collect(Collectors.toMap(prod->prod.name, prod->(int)prod.price));
        System.out.println(map);
    }
}