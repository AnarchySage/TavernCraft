package taverncraft.WorldGeneration.Tavern;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

//check biome decorates - lemming

public class TavernSpawnGen extends WorldGenerator
{

    public TavernSpawnGen()
    {

    }

    // public static final WeightedRandomChestContent[] underwaterChestContents
    // = new WeightedRandomChestContent[] { new
    // WeightedRandomChestContent(Item.diamond.itemID, 0, 1, 3, 3) };
    /*
     * When using the mithion structure program, its a bit dated.
     * http://www.minecraftforum
     * .net/topic/1336152-132-updated-metadata-support-simpleschematic
     * -to-java-file-converter/ make sure to use an updated file set(updating it
     * as i go) here, https://dl.dropboxusercontent.com/u/126429646
     * /SchematicToJavaConverter_1.7/Config/textureMappings.ini place into
     * folder/config/ over the old one. when using blocks with multi
     * directions(Stairs/pistons/etc) remember its Block.name, direction,
     * metadata) stair directions, 6 is corner(upside down), 5 is east(upside
     * down), 4 is west(upside down), 3 is south(upwards), 2 is north(upwards),
     * 1 is east(upwards), 0 is west(upwards) keep in mind i dunno how the
     * (area) works, just stating what i seen.
     * 
     * on wool, its block.name, metadata, dunno)
     */
    public boolean generate (World world, Random rand, int x, int y, int z)
    {
        //the abreviations are Directionplacement
        world.setBlock(x, y - 1, z, Block.blockGold.blockID, 0, 0); // middle
        world.setBlock(x + 1, y - 1, z, Block.stone.blockID, 0, 0); // floor east pillar
        world.setBlock(x - 1, y - 1, z, Block.stone.blockID, 0, 0); // floor west pillar
        world.setBlock(x, y - 1, z + 1, Block.stone.blockID, 0, 0); // floor south pillar
        world.setBlock(x, y - 1, z - 1, Block.stone.blockID, 0, 0); // floor south pillar

        world.setBlock(x, y + 3, z, Block.blockLapis.blockID, 0, 0); // middle top

        world.setBlock(x - 2, y + 0, z, Block.stone.blockID, 0, 0); //wfb
        world.setBlock(x - 2, y + 1, z, Block.stone.blockID, 0, 0); //wfm
        world.setBlock(x - 1, y + 2, z, Block.stone.blockID, 0, 0); //wft

        world.setBlock(x, y + 0, z - 2, Block.stone.blockID, 0, 0); //nfb
        world.setBlock(x, y + 1, z - 2, Block.stone.blockID, 0, 0); //nfm
        world.setBlock(x, y + 2, z - 1, Block.stone.blockID, 0, 0); //nft

        world.setBlock(x + 2, y + 0, z, Block.stone.blockID, 0, 0); //efb
        world.setBlock(x + 2, y + 1, z, Block.stone.blockID, 0, 0); //efm
        world.setBlock(x + 1, y + 2, z, Block.stone.blockID, 0, 0); //eft

        world.setBlock(x, y + 0, z + 2, Block.stone.blockID, 0, 0); //sfb
        world.setBlock(x, y + 1, z + 2, Block.stone.blockID, 0, 0); //sfm
        world.setBlock(x, y + 2, z + 1, Block.stone.blockID, 0, 0); //sft

        return false;
    }
}
