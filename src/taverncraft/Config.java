package taverncraft;

import java.io.File;
import java.io.IOException;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class Config
{

    public static void initProps (File location)
    {
        /* Here we will set up the config file for the mod 
         * First: Create a folder inside the config folder
         * Second: Create the actual config file
         * Note: Configs are a pain, but absolutely necessary for every mod.
         */
        File newFile = new File(location + "/TavernCraft.cfg");

        /* Some basic debugging will go a long way */
        try
        {
            newFile.createNewFile();
        }
        catch (IOException e)
        {
            FMLLog.info("[TavernCraft] Could not create configuration file. Reason:");
            FMLLog.info(e.getLocalizedMessage());
        }

        /* [Forge] Configuration class, used as config method */
        Configuration config = new Configuration(newFile);
        cfglocation = location;
        /* Load the configuration file */
        config.load();

        /* Define the mod's IDs. 
         * Avoid values below 4096 for items and in the 250-450 range for blocks
         */
        String category0 = "What to enable/disable";
        enablevillagetavern = config.get(category0, "Enable the villager registration and generation?", true).getBoolean(true);
        enabletrellis = config.get(category0, "Enable the Trellis?(Required for grape vines)", true).getBoolean(true);
        
        String category1 = "Block Id's";
        trellisconfig = config.get(category1, "Trellis ID?",3765).getInt(3765);
        vineGrapeID = config.get(category1, "Vine Grape ID?", 3766).getInt(3765);
        
        String worldgenchances = "World Gen Chances";
        tavernchance = config.get(worldgenchances, "Tavern Chance out of 10 to spawn", 1).getInt(1);
        
        
        //Property conTexMode = config.get("Looks", "Connected Textures Enabled", true);
        //conTexMode.comment = "0 = disabled, 1 = enabled, 2 = enabled + ignore stained glass meta";
        //connectedTexturesMode = conTexMode.getInt(2);

        /* Save the configuration file */
        config.save();
    }

    public static File cfglocation;
    
    //Booleans
    public static boolean enablevillagetavern;
    public static boolean enabletrellis;
    
    
    //Blocks
    public static int trellisconfig;
    public static int vineGrapeID;
    
    //Values
    public static int tavernchance;
    //these are left as an example, ints for id's, booleans for if we want it to happen or not
    //public static int ids;
    //public static boolean ifs;
    //Looks
    //public static int connectedTexturesMode;
}
