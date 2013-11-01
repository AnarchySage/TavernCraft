package taverncraft.WorldGeneration.Tavern;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import taverncraft.Config;
import cpw.mods.fml.common.IWorldGenerator;

public class TavernHandler implements IWorldGenerator
{
    public void generate (Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        switch (world.provider.dimensionId)
        {
        case 0:
            generateTavern(world, random, chunkX * 16, chunkZ * 16);
        }
    }

    private void generateTavern (World world, Random rand, int y, int z)
    {
        // for (int i = 0; i < Storageprops.ruinrarity; i++)
        if (rand.nextInt(Config.tavernchance) == 1)
        {
            if (world.getWorldChunkManager().getBiomeGenAt(y, z).biomeName.equals("Desert") || world.getWorldChunkManager().getBiomeGenAt(y, z).biomeName.equals("DesertHills"))
            {
                //rand.nextInt(10)==1 the 10 stands for a 1 in 10 chance
                int RandPosX = y + rand.nextInt(16);
                int RandPosZ = z + rand.nextInt(16);
                for (int height = 70; height > 0; height--)
                {
                    if (world.getBlockId(RandPosX, height, RandPosZ) == Block.grass.blockID)
                    {
                        (new StructureDesertTavern()).generate(world, rand, RandPosX, height - 13, RandPosZ);
                        //testing purposes                  (new StructureUnderWaterRuin()).generate(world, rand, RandPosX, 64 , RandPosZ); 
                        break;
                    }
                }

            }
            else {
                int RandPosX = y + rand.nextInt(16);
                int RandPosZ = z + rand.nextInt(16);
                for (int height = 70; height > 0; height--)
                {
                    if (world.getBlockId(RandPosX, height, RandPosZ) == Block.grass.blockID)
                    {
                        (new StructureTavern()).generate(world, rand, RandPosX, height - 13, RandPosZ);
                        //testing purposes                  (new StructureUnderWaterRuin()).generate(world, rand, RandPosX, 64 , RandPosZ); 
                        break;
                    }
                }                
            }
        }
    }
}