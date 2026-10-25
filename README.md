# Vehicle Fleet Management System

## Project Objective

The objective of this project is to apply fundamental Java and Object-Oriented Programming concepts by developing a console application capable of managing vehicles and storing their data in a text file.

## Features

The application provides the following options:

1. **List Vehicles** — displays all registered vehicles.
2. **Add Vehicle** — allows users to add a car or a motorcycle to the fleet.
3. **Remove Vehicle** — removes a vehicle using its registration number.
4. **Search by Brand** — searches for vehicles from a specific brand.
5. **Calculate Total Maintenance Cost** — calculates the total maintenance cost of the registered vehicles.
0. **Exit** — terminates the application.

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- Abstract classes and inheritance
- Polymorphism and method overriding (`@Override`)
- Collections (`ArrayList` and `List`)
- File handling using `Scanner`, `File`, and `PrintWriter`

## Project Structure

- `Veiculo.java` — abstract base class for vehicles.
- `Carro.java` — class representing cars.
- `Mota.java` — class representing motorcycles.
- `Frota.java` — class responsible for managing vehicles and file operations.
- `Main.java` — contains the menu and user interaction.
- `veiculos.txt` — file used to store vehicle data.

## File Format

Vehicle data is stored in a text file `veiculos.txt`, using a semicolon (;) as the field separator.

Example:

```text
Carro;AA-20-AA;Renault;Clio;250.0;150.0
Moto;BB-25-BB;Yamaha;MT-07;0.6;800.0
Carro;ZZ-30-QQ;Volkswagen;Golf;350.0;220.0
```

The fields are arranged as follows:

- **Car:** type; registration number; brand; model; base maintenance cost; annual insurance cost.
- **Motorcycle:** type; registration number; brand; model; cost per kilometre; kilometres travelled.

## How to Run

1. Install a compatible Java Development Kit (JDK).
2. Run `Main.java`.
3. Use the console menu to select the desired operations.
