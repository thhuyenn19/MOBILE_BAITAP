package com.example.models;

import java.util.ArrayList;

public class ListCategory {
    private ArrayList<Category> categories;


    public ListCategory() {
        categories = new ArrayList<>();
    }

    public ArrayList<Category> getCatagories() {
        return categories;
    }

    public void setCatagories(ArrayList<Category> catagories) {
        this.categories = catagories;
    }
    public void generate_sample_product_dataset() {
        Category c1 = new Category(110, "Soft Drink", 1);
        Product p1 = new Product(1, "Coca Cola", 100, 9.99, 201);
        p1.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Product p2 = new Product(2, "Pepsi", 100, 9.99, 202);
        p2.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Product p3 = new Product(3, "7Up", 100, 9.99, 203);
        p3.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Product p4 = new Product(4, "Fanta", 100, 9.99, 204);
        p4.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Product p5 = new Product(5, "Sprite", 100, 9.99, 205);
        p5.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Category c2 = new Category(111, "Cake", 1);
        Product p6 = new Product(6, "Chocolate Cake", 100, 9.99, 206);
        p6.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Product p7 = new Product(7, "Cheesecake", 100, 9.99, 207);
        p7.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Product p8 = new Product(8, "Carrot Cake", 100, 9.99, 208);
        p8.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Product p9 = new Product(9, "Tiramisu", 100, 9.99, 209);
        p9.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Product p10 = new Product(10, "Pineapple Cake", 100, 9.99, 210);
        p10.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Category c3 = new Category(112, "Fastfood", 1);
        Product p11 = new Product(11, "Burger", 100, 9.99, 211);
        p11.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Product p12 = new Product(12, "Fried Chicken", 100, 9.99, 212);
        p12.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Product p13 = new Product(13, "Pizza", 100, 9.99, 213);
        p13.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Product p14 = new Product(14, "Hotdog", 100, 9.99, 214);
        p14.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Product p15 = new Product(15, "French Fries", 100, 9.99, 215);
        p15.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Category c4 = new Category(113, "Beer", 1);
        Product p16 = new Product(16, "Heineken", 100, 9.99, 216);
        p16.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Product p17 = new Product(17, "Tiger", 100, 9.99, 217);
        p17.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Product p18 = new Product(18, "Budweiser", 100, 9.99, 218);
        p18.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Product p19 = new Product(19, "Larue", 100, 9.99, 219);
        p19.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Product p20 = new Product(20, "Saigon Beer", 100, 9.99, 220);
        p20.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Category c5 = new Category(114, "Seafood", 1);
        Product p21 = new Product(21, "Grilled Squid", 100, 9.99, 221);
        p21.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Product p22 = new Product(22, "Fried Shrimp", 100, 9.99, 222);
        p22.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Product p23 = new Product(23, "Oyster", 100, 9.99, 223);
        p23.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Product p24 = new Product(24, "Lobster", 100, 9.99, 224);
        p24.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Product p25 = new Product(25, "Fish Fillet", 100, 9.99, 225);
        p25.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Category c6 = new Category(115, "Vegetarian", 1);
        Product p26 = new Product(26, "Tofu Soup", 100, 9.99, 226);
        p26.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Product p27 = new Product(27, "Stir-fried Vegetables", 100, 9.99, 227);
        p27.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Product p28 = new Product(28, "Veggie Burger", 100, 9.99, 228);
        p28.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Product p29 = new Product(29, "Vegetarian Pizza", 100, 9.99, 229);
        p29.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Product p30 = new Product(30, "Mushroom Hotpot", 100, 9.99, 230);
        p30.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Category c7 = new Category(116, "Fruit", 1);
        Product p31 = new Product(31, "Apple", 100, 9.99, 231);
        p31.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Product p32 = new Product(32, "Banana", 100, 9.99, 232);
        p32.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Product p33 = new Product(33, "Mango", 100, 9.99, 233);
        p33.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Product p34 = new Product(34, "Orange", 100, 9.99, 234);
        p34.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Product p35 = new Product(35, "Grapes", 100, 9.99, 235);
        p35.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Category c8 = new Category(117, "Snack", 1);
        Product p36 = new Product(36, "Potato Chips", 100, 9.99, 236);
        p36.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Product p37 = new Product(37, "Popcorn", 100, 9.99, 237);
        p37.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Product p38 = new Product(38, "Rice Crackers", 100, 9.99, 238);
        p38.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Product p39 = new Product(39, "Nuts Mix", 100, 9.99, 239);
        p39.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Product p40 = new Product(40, "Choco Bar", 100, 9.99, 240);
        p40.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Category c9 = new Category(118, "Coffee", 1);
        Product p41 = new Product(41, "Espresso", 100, 9.99, 241);
        p41.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Product p42 = new Product(42, "Cappuccino", 100, 9.99, 242);
        p42.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Product p43 = new Product(43, "Latte", 100, 9.99, 243);
        p43.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Product p44 = new Product(44, "Black Coffee", 100, 9.99, 244);
        p44.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Product p45 = new Product(45, "Iced Coffee", 100, 9.99, 245);
        p45.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Category c10 = new Category(119, "Ice Cream", 1);
        Product p46 = new Product(46, "Vanilla", 100, 9.99, 246);
        p46.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Product p47 = new Product(47, "Chocolate", 100, 9.99, 247);
        p47.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Product p48 = new Product(48, "Strawberry", 100, 9.99, 248);
        p48.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Product p49 = new Product(49, "Matcha", 100, 9.99, 249);
        p49.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        Product p50 = new Product(50, "Mango Sorbet", 100, 9.99, 250);
        p50.setDescription("This product is crafted using the finest ingredients to ensure top-notch quality and flavor.  Perfect for daily use or special occasions, it offers an exceptional experience in both taste and presentation.  Loved by customers around the globe, this product stands out due to its consistent excellence, value for money,  and trusted brand reputation. Suitable for all ages and available year-round, it’s a must-have in any household.");
        c1.addProduct(p1);
        c1.addProduct(p2);
        c1.addProduct(p3);
        c1.addProduct(p4);
        c1.addProduct(p5);
        categories.add(c1);
        c2.addProduct(p6);
        c2.addProduct(p7);
        c2.addProduct(p8);
        c2.addProduct(p9);
        c2.addProduct(p10);
        categories.add(c2);
        c3.addProduct(p11);
        c3.addProduct(p12);
        c3.addProduct(p13);
        c3.addProduct(p14);
        c3.addProduct(p15);
        categories.add(c3);
        c4.addProduct(p16);
        c4.addProduct(p17);
        c4.addProduct(p18);
        c4.addProduct(p19);
        c4.addProduct(p20);
        categories.add(c4);
        c5.addProduct(p21);
        c5.addProduct(p22);
        c5.addProduct(p23);
        c5.addProduct(p24);
        c5.addProduct(p25);
        categories.add(c5);
        c6.addProduct(p26);
        c6.addProduct(p27);
        c6.addProduct(p28);
        c6.addProduct(p29);
        c6.addProduct(p30);
        categories.add(c6);
        c7.addProduct(p31);
        c7.addProduct(p32);
        c7.addProduct(p33);
        c7.addProduct(p34);
        c7.addProduct(p35);
        categories.add(c7);
        c8.addProduct(p36);
        c8.addProduct(p37);
        c8.addProduct(p38);
        c8.addProduct(p39);
        c8.addProduct(p40);
        categories.add(c8);
        c9.addProduct(p41);
        c9.addProduct(p42);
        c9.addProduct(p43);
        c9.addProduct(p44);
        c9.addProduct(p45);
        categories.add(c9);
        c10.addProduct(p46);
        c10.addProduct(p47);
        c10.addProduct(p48);
        c10.addProduct(p49);
        c10.addProduct(p50);
        categories.add(c10);
    }
}
