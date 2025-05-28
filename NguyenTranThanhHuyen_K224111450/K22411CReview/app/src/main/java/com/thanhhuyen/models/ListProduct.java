package com.thanhhuyen.models;

import java.util.ArrayList;

public class ListProduct {
    private ArrayList<Product> products;

    public ListProduct() {
        products = new ArrayList<>();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void generateSampleProducts() {
        products.add(new Product(1, "P001", "Bạn Đang Nghịch Gì Với Đời Mình?", 95480, "https://salt.tikicdn.com/cache/750x750/ts/product/a6/b7/be/52db290e9e27761ba539e7c8003347ed.jpg.webp"));
        products.add(new Product(2, "P002", "Bí Mật - The Secret", 280120, "https://salt.tikicdn.com/cache/750x750/ts/product/3b/59/32/667be9bea9c9eb4abd92efc040404ec0.jpg.webp"));
        products.add(new Product(3, "P003", "Sức Mạnh Của Hiện Tại", 134400, "https://salt.tikicdn.com/cache/750x750/ts/product/b0/2c/c3/ae5e3accdc47334cf5315fea5470ae33.jpg.webp"));
        products.add(new Product(4, "P004", "Khuyến học", 129360, "https://salt.tikicdn.com/cache/750x750/ts/product/2a/9b/19/2e743d211b37cf35d65cd420eaef6b7c.jpeg.webp"));
        products.add(new Product(5, "P005", "Đời Ngắn Đừng Ngủ Dài", 71250, "https://salt.tikicdn.com/cache/750x750/ts/product/18/10/10/79938aa995315bda5f9b2be2fed6dee4.jpg.webp"));
        products.add(new Product(6, "P006", "Tôi Tự Học", 120000, "https://salt.tikicdn.com/cache/750x750/ts/product/25/b4/6e/9d4ec9d8e4338dd20fcc6e43e8b9debb.jpg.webp"));
        products.add(new Product(7, "P007", "Đọc Sách, Điểm Sách", 46800, "https://salt.tikicdn.com/cache/750x750/ts/product/fb/53/4d/bfd696121b6799bc5795a6fad914da56.jpg.webp"));
        products.add(new Product(8, "P008", "Phương Pháp Đọc Sách Hiệu Quả", 143000, "https://salt.tikicdn.com/cache/750x750/ts/product/03/2f/f4/0ef098806b32d2341876a139ba748d2c.png.webp"));
        products.add(new Product(9, "P009", "Sách Tâm Lý Học Thành Công", 159198, "https://salt.tikicdn.com/cache/750x750/ts/product/70/d6/61/4676e18328ad93f016debd246e7d750e.jpg.webp"));
        products.add(new Product(10, "P010", "Trí Tuệ Do Thái", 151000, "https://salt.tikicdn.com/cache/750x750/ts/product/c0/d7/f9/068077a60abe46580802b30e6e499ee6.png.webp"));
        products.add(new Product(11, "P011", "Siêu Trí Nhớ", 111000, "https://salt.tikicdn.com/cache/750x750/ts/product/32/08/2f/503a8fda6cfacb877af4334fdeb9ce55.png.webp"));
        products.add(new Product(12, "P012", "Quẳng Gánh Lo Đi Và Vui Sống", 79000, "https://salt.tikicdn.com/cache/750x750/ts/product/5a/c7/9d/447d1a2d6727aca3bd7b24702cb7eb47.png.webp"));
        products.add(new Product(13, "P013", "7 Thói Quen Hiệu Quả Cho Bạn Trẻ", 84240, "https://salt.tikicdn.com/cache/750x750/ts/product/db/10/08/d25301cf75ca275c665d44d296069067.jpg.webp"));
        products.add(new Product(14, "P014", "Vị Tu Sĩ Bán Chiếc Ferrari", 172800, "https://salt.tikicdn.com/cache/750x750/ts/product/03/2c/a3/012789d13f1dce879d4bd6095380a450.jpg.webp"));
        products.add(new Product(15, "P015", "Thiên Nga Đen", 10000, "https://salt.tikicdn.com/cache/750x750/ts/product/f5/88/00/e06654f818f6ff84c2e977a7257e9191.jpeg.webp"));
        products.add(new Product(16, "P016", "Đường Mây Qua Xứ Tuyết", 94400, "https://salt.tikicdn.com/cache/750x750/ts/product/e6/58/00/0ff97bd5678ef1d974b8d694de7467ef.jpg.webp"));
        products.add(new Product(17, "P017", "Chữa Lành nỗi đau", 56600, "https://salt.tikicdn.com/cache/750x750/ts/product/26/6a/87/8e3d9c8156f64b9c910e5754d1f50bfd.jpg.webp"));
        products.add(new Product(18, "P018", "Sách Nghệ Thuật Tư Duy Rành Mạch", 127000, "https://salt.tikicdn.com/cache/750x750/ts/product/05/16/29/bb4543d510e915b77be77512a832e6ea.png.webp"));
        products.add(new Product(19, "P019", "Chiến Thắng Con Quỷ Trong Bạn", 118000, "https://salt.tikicdn.com/cache/750x750/ts/product/3b/57/46/5a1df26f22d74298a969f4b97d7dfd25.jpeg.webp"));
        products.add(new Product(20, "P020", "Vận Hành Tinh Gọn", 99000, "https://salt.tikicdn.com/cache/750x750/ts/product/fb/89/ca/2b71ea661741af14d76c20b91bc39938.jpg.webp"));
    }
}
