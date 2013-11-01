package taverncraft.Registrations;

import net.minecraft.item.Item;
import taverncraft.Items.TavernDesertSpawn;
import taverncraft.Items.TavernSpawn;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class GeneralItemRegistrations
{
    public static void generalItemRegistrations ()
    {
        // redstonelampdimconfig = Storageprops.redstonelampdimconfig;
        // RedstoneLampDim = new RedstonedimLamps(redstonelampdimconfig, false);

        // redstonelamplitconfig = Storageprops.redstonelamplitconfig;
        // RedstoneLampLit = new RedstonelitLamps(redstonelamplitconfig, true);

        /* ##### Dim Lamps ##### */
        // GameRegistry.registerBlock(RedstoneLampDim,
        // RedstoneLampDimItemBlock.class, "Redstone Lamp Dim");
        // LanguageRegistry.addName(new ItemStack(RedstoneLampDim, 1, 0),
        // "Dim Black Redstone Lamp");
        /*
         * tavernspawn = new TavernSpawn(19500).setUnlocalizedName("tavernspawn");
        LanguageRegistry.addName(tavernspawn, "Tavern spawn Test Item");
        taverndesertspawn = new TavernDesertSpawn(19501).setUnlocalizedName("taverndesertspawn");
        LanguageRegistry.addName(taverndesertspawn, "Desert Tavern spawn Test Item");
         */
    }

    public static void addRecipes ()
    {
    }

    public static Item tavernspawn;
    public static Item taverndesertspawn;
}
