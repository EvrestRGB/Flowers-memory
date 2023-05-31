import java.util.Random;

public class Flower {

    private static final Random random = new Random();

    private final FlowerType type;
    private final int x;
    private final int y;
    private final int z;

    public Flower(FlowerType type, int x, int y, int z) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public FlowerType getType() {
        return type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public static void generateFlowers(World world, int x, int y, int z) {
        // Get the biome at the specified coordinates.
        Biome biome = world.getBiome(x, y, z);

        // Get the list of flowers that can be generated in this biome.
        List<FlowerType> flowerTypes = biome.getFlowerTypes();

        // If there are no flowers that can be generated in this biome, return.
        if (flowerTypes.isEmpty()) {
            return;
        }

        // Choose a random flower type.
        FlowerType flowerType = flowerTypes.get(random.nextInt(flowerTypes.size()));

        // Generate a flower at the specified coordinates.
        new Flower(flowerType, x, y, z);
    }

}
