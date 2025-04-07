import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.*;

public class ZooManager {
    private static Map<String, Integer> speciesCounter = new HashMap<>();
    private static Map<String, Queue<String>> nameMap = new HashMap<>();
    private static Map<String, List<animalTraits>> habitatMap = new HashMap<>();

    public static void main(String[] args) {
        readNames("animalNames.txt");
        processAnimals("arrivingAnimals.txt");
        writeReport("zooPopulation.txt");
    }

    public static void readNames(String fileName) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            for (String line : lines) {
                String[] parts = line.split(":");
                if (parts.length != 2) continue;
                String species = parts[0].trim().toLowerCase();
                Queue<String> names = new LinkedList<>(Arrays.asList(parts[1].split(",")));
                Queue<String> trimmedNames = new LinkedList<>();
                for (String name : names) {
                    trimmedNames.add(name.trim());
                }
                nameMap.put(species, trimmedNames);
            }
        } catch (IOException e) {
            System.out.println("Error reading names: " + e.getMessage());
        }
    }

    public static void processAnimals(String fileName) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            for (String line : lines) {
                String[] tokens = line.split(",\\s*");
                if (tokens.length < 6) continue;

                // Parsing attributes from description
                String ageToken = tokens[0];
                String sex = tokens[1].split(" ")[1].toLowerCase();
                String species = tokens[2].trim().toLowerCase();
                String color = tokens[3].replace(" color", "").trim();
                int weight = Integer.parseInt(tokens[4].replace(" pounds", "").trim());
                String origin = tokens[5].replace("from ", "").trim();

                int age = Integer.parseInt(ageToken.split(" ")[0]);
                LocalDate birthday = genBirthDay(age, tokens[0]);
                String id = genUniqueID(species);
                String name = getName(species);
                String arrivalDate = LocalDate.now().toString();

                animalTraits animal = new Animal(age, weight, name, birthday.toString(), origin, color, sex, arrivalDate, id);

                // Determine habitat and group
                String habitat = getHabitat(species);
                habitatMap.computeIfAbsent(habitat, k -> new ArrayList<>()).add(animal);
            }
        } catch (IOException e) {
            System.out.println("Error processing animals: " + e.getMessage());
        }
    }

    public static LocalDate genBirthDay(int age, String ageToken) {
        LocalDate baseDate = LocalDate.now().minusYears(age);
        if (ageToken.toLowerCase().contains("spring")) {
            return LocalDate.of(baseDate.getYear(), 3, 21);
        } else if (ageToken.toLowerCase().contains("summer")) {
            return LocalDate.of(baseDate.getYear(), 6, 21);
        } else if (ageToken.toLowerCase().contains("fall")) {
            return LocalDate.of(baseDate.getYear(), 9, 21);
        } else if (ageToken.toLowerCase().contains("winter")) {
            return LocalDate.of(baseDate.getYear(), 12, 21);
        } else {
            return baseDate;
        }
    }

    public static String genUniqueID(String species) {
        String abbrev = species.substring(0, 2).toUpperCase();
        int count = speciesCounter.getOrDefault(species, 0) + 1;
        speciesCounter.put(species, count);
        return abbrev + String.format("%02d", count);
    }

    public static String getName(String species) {
        Queue<String> names = nameMap.get(species);
        return (names != null && !names.isEmpty()) ? names.poll() : "NoName";
    }

    public static String getHabitat(String species) {
        return switch (species.toLowerCase()) {
            case "hyena" -> "Hyena Habitat";
            case "lion" -> "Lion Habitat";
            case "bear" -> "Bear Habitat";
            case "sloth" -> "Sloth Habitat";
            default -> "Unknown Habitat";
        };
    }

    public static void writeReport(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String habitat : habitatMap.keySet()) {
                writer.write(habitat + ":\n");
                for (animalTraits animal : habitatMap.get(habitat)) {
                    writer.write(animal.toString() + "\n");
                }
                writer.write("\n");
            }
            System.out.println("zooPopulation.txt written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing report: " + e.getMessage());
        }
    }
}
