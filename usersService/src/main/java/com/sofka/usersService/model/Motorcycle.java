package com.sofka.usersService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Motorcycle {
    private String brand;
    private String model;
    private int userId;
}
