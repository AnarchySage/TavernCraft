package taverncraft;

import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.common.registry.VillagerRegistry;

//import Vanityblocks.Proxy;

public class ProxyClient extends Proxy
{

    @Override
    public void registerRenderInformation ()
    {
        if (Config.enablevillagetavern) {
            VillagerRegistry.instance().registerVillagerSkin(54365, new ResourceLocation("taverncraft", "textures/mob/bartender.png"));
        }
    }

    @Override
    public void addNames ()
    {
    }
}