package taverncraft;

import cpw.mods.fml.common.Loader;

public class Proxy
{

    public void registerRenderInformation ()
    {

    }

    public void addNames ()
    {
    }

    public static String getMinecraftVersion ()
    {
        return Loader.instance().getMinecraftModContainer().getVersion();
    }
}