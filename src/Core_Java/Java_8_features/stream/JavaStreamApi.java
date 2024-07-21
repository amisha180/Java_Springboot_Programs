package Core_Java.Java_8_features.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class Product{
        int id;
        String name;
        float price;
        public Product(int id, String name, float price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }
    }

    public class JavaStreamApi{
        public static void main(String[] args) {
            List<Product> productsList = new ArrayList<Product>();
            //Adding Products
            productsList.add(new Product(1,"HP Laptop",25f));
            productsList.add(new Product(2,"Dell Laptop",3f));
            productsList.add(new Product(3,"Lenevo Laptop",28f));
            productsList.add(new Product(4,"Sony Laptop",2f));
            productsList.add(new Product(5,"Apple Laptop",90f));

            List<Float> productPriceList2 = productsList.stream().filter(x->x.price>25000f).map(x->x.price).sorted().collect(Collectors.toList());
            System.out.println(productPriceList2);

            List<Product> productList2 = productsList.stream().filter(x->x.price>30000f).collect(Collectors.toList());
            productList2.stream().forEach((n)->System.out.println(n.name));

            float totalPrice = productsList.stream().map(x->x.price).reduce(0f,(sum,price)->sum+price);
            System.out.println(totalPrice);

            double totalP = productsList.stream().collect(Collectors.summingDouble(x->x.price));
            System.out.println(totalP);

            Product A = productsList.stream().max((p1,p2)->p1.price>p2.price?1:-1).get();
            System.out.println(A.price);

            Product B = productsList.stream().min((p1,p2)->p1.price> p2.price?1:-1).get();
            System.out.println(B.price);

            long count = productsList.stream().count();
            System.out.println(count);

            Set<Float> set = productsList.stream().map(x->x.price).collect(Collectors.toSet());
            System.out.println(set);

            Map<String, Float> productPriceMap = productsList.stream().collect(Collectors.toMap(x->x.name, x->x.price));
            System.out.println(productPriceMap);

            List<String> names = productsList.stream().map(x->x.name).map(String::toUpperCase).collect(Collectors.toList());
            System.out.println(names);

        }
    }
