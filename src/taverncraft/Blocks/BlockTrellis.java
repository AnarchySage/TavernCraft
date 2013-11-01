package taverncraft.Blocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import taverncraft.TavernCraft;
import taverncraft.Renders.BlockTrellisRender;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

public class BlockTrellis extends Block
{

    public BlockTrellis (int id){
        super(id, Material.rock);
        setResistance(2.0F);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.375F, 1.0F, 0.625F);
        setCreativeTab(TavernCraft.taverncrafttab);
    }
    
    @Override
    public boolean renderAsNormalBlock ()
    {
        return false;
    }

    @Override
    public boolean isOpaqueCube ()
    {
        return false;
    }

    @Override
    public boolean shouldSideBeRendered (IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        return true;
    }

    public boolean getBlocksMovement(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        return false;
    }
    private Icon[] iconBuffer;

    @Override
    public void registerIcons (IconRegister par1IconRegister)
    {
        iconBuffer = new Icon[1];

        iconBuffer[0] = par1IconRegister.registerIcon("taverncraft:Trellis_1");

    }

    @Override
    // public Icon getBlockTextureFromSideAndMetadata (int side, int metadata) {
    public Icon getIcon (int side, int metadata)
    {

        if (metadata == 0)
        {
            return iconBuffer[0];
        }
        return blockIcon;
    }
    
    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return BlockTrellisRender.trellisModelID;
    }
    
    public static int limitToValidMetadata(int par0)
    {
        return par0 & 3;
    }    
    @SuppressWarnings("unchecked")
    @SideOnly(Side.CLIENT)
    public void getSubBlocks (int par1, CreativeTabs tab, List subItems)
    {
        for (int ix = 0; ix < 2; ix++)
        {
            subItems.add(new ItemStack(this, 1, ix));
        }
    }
}
