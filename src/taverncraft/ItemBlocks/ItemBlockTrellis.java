package taverncraft.ItemBlocks;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockTrellis extends ItemBlock
{

    private final static String[] subNames = { "Grape Trellis", "", "", "", "",
            "", "", "", "", "", "", "", "", "", "", "" };

    public ItemBlockTrellis(int id)
    {
        super(id);
        setHasSubtypes(true);
    }

    @Override
    public int getMetadata (int i)
    {
        return i;
    }

    @Override
    public String getUnlocalizedName (ItemStack itemstack)
    {
        return subNames[itemstack.getItemDamage()];
    }
}