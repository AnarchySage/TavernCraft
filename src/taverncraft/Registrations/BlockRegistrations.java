package taverncraft.Registrations;

import net.minecraft.block.Block;
import taverncraft.Config;
import taverncraft.Blocks.BlockTrellis;
import taverncraft.Blocks.BlockVineGrape;
import taverncraft.ItemBlocks.ItemBlockTrellis;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockRegistrations
{
        public static void blockRegistrations ()
        {
            if (Config.enabletrellis){
            trellisconfig = Config.trellisconfig;
            trellisblock = new BlockTrellis(trellisconfig);
            GameRegistry.registerBlock(trellisblock, ItemBlockTrellis.class, "Trellis Blocks");
            }
            
            vineGrape = new BlockVineGrape(Config.vineGrapeID).setUnlocalizedName("Vine.Grape");
            GameRegistry.registerBlock(vineGrape, "Vine.Grape");
        }

        public static void addRecipes ()
        {
        }
                
        public static Block trellisblock;
        public static Block vineGrape;
        
        
        public static int trellisconfig;
}
