package com.example.t0216081.Mock;

import com.example.t0216081.Model.Food;

public class MockFood {
    public static String[] foodStringArr = { "Nasi Goreng Biasa", "Nasi Goreng Telor", "Nasi Goreng Ayam",
            "Nasi Goreng Sapi", "Nasi Goreng Seafood", "Mie Goreng Biasa", "Mie Goreng Telor", "Mie Goreng Ayam",
            "Mie Goreng Sapi", "Mie Goreng Seafood", "Baso", "Baso", "Baso", "Baso", "Baso", "Baso", "Baso", "Baso" };

    public static Food[] foodObjectArr = {
            new Food("Nasi Goreng","pake nasi"),
            new Food("Mie Goreng","pake mie"),
            new Food("Makanan 1","detail makanan 1"),
            new Food("Makanan 2","detail makanan 2"),
            new Food("Makanan 3","detail makanan 3"),
            new Food("Makanan 4","detail makanan 4"),
            new Food("Makanan 5","detail makanan 5")
    };
}
