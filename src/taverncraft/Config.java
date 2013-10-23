package taverncraft;

import java.io.File;
import java.io.IOException;

import cpw.mods.fml.common.FMLLog;

import net.minecraftforge.common.Configuration;

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
        String enabled = "What to enable/disable";
        enablemod = config.get(enabled, "Enable the mod?", true).getBoolean(true);
        enabletavernvillagers = config.get(enabled, "Enable the villager registration and generation?", true).getBoolean(true);
        
        
        
        //Property conTexMode = config.get("Looks", "Connected Textures Enabled", true);
        //conTexMode.comment = "0 = disabled, 1 = enabled, 2 = enabled + ignore stained glass meta";
        //connectedTexturesMode = conTexMode.getInt(2);

        /* Save the configuration file */
        config.save();
    }

    public static File cfglocation;
    public static boolean enablemod;
    public static boolean enabletavernvillagers;

    //these are left as an example, ints for id's, booleans for if we want it to happen or not
    //public static int ids;
    //public static boolean ifs;
    //Looks
    //public static int connectedTexturesMode;
}
