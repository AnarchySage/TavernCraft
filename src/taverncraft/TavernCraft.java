package taverncraft;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import taverncraft.Registrations.BlockRegistrations;
import taverncraft.Registrations.GeneralItemRegistrations;
import taverncraft.Renders.BlockTrellisRender;
import taverncraft.WorldGeneration.Tavern.TavernHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;

@Mod(modid = "TavernCraft", name = "taverncraft", version = "1.6.4")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class TavernCraft
{

    @Instance("TavernCraft")
    public static TavernCraft instance;
    public static final String modid = "taverncraft";

    // public static final String LANGUAGE_PATH = "assets/taverncraft/lang/";
    // private static final String[] LANGUAGES_SUPPORTED = new String[] {
    // "en_US" };

    @SidedProxy(clientSide = "taverncraft.ProxyClient", serverSide = "taverncraft.Proxy")
    public static Proxy proxy;

    // public static void checkVersion (Side side)
    // {
    // VersionCheck.startCheck(side);
    // }

    @EventHandler
    public void preInit (FMLPreInitializationEvent event)
    {
        // Main part of mod
        Config.initProps(event.getModConfigurationDirectory());
    }

    @EventHandler
    public void load (FMLInitializationEvent event)
    {
        proxy.registerRenderInformation();
        proxy.addNames();

        BlockRegistrations.blockRegistrations();
        BlockRegistrations.addRecipes();
        GeneralItemRegistrations.generalItemRegistrations();
        RenderingRegistry.registerBlockHandler(new BlockTrellisRender());
        
        /* Creative tab related */
        LanguageRegistry.instance().addStringLocalization("itemGroup.taverncraft", "en_US", "TavernCraft");
        
        
        if (Config.enablevillagetavern)
        {        
            //RelatedAVillageTrades trades = new AVillageTrades();

            // adds to the villager spawner egg
            VillagerRegistry.instance().registerVillagerId(54365);
            //VillagerRegistry.instance().registerVillageTradeHandler(54365, new BartenderVillageTrades());
            GameRegistry.registerWorldGenerator(new TavernHandler());
            //try
            //{
            //    if (new CallableMinecraftVersion(null).minecraftVersion().equals("1.6.4"))
            //    {
            //        MapGenStructureIO.func_143031_a(StructureTavern.class, "TavernCraft:TavernStructure");
            //    }
            //}
            //catch (Throwable e)
            //{
//
 //           }
      } 

    }

    public static CreativeTabs taverncrafttab = new CreativeTabs("taverncraft")
    {
        public ItemStack getIconItemStack ()
        {
            // return new
            // ItemStack(vanityblocks.Registrations.VanityBlocksRegistration.VanityDesignblock,
            // 1, 0);
            return new ItemStack(Block.stoneBrick);
        }
    };

    @EventHandler
    public void postInit (FMLPostInitializationEvent event)
    {
        FMLLog.info("[Taverncraft] Seems to have loaded well!");
    }

    @EventHandler
    public void serverInit (FMLServerStartedEvent event)
    {
    }

    @EventHandler
    public static void serverStarting (FMLServerStartingEvent event)
    {
    }
}
