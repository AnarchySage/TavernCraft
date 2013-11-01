package taverncraft.Renders;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class BlockTrellisRender implements ISimpleBlockRenderingHandler
{
    public static int trellisModelID = RenderingRegistry.getNextAvailableRenderId();

    @Override
    public void renderInventoryBlock (Block block, int metadata, int modelID, RenderBlocks renderer)
    {
        if (modelID == trellisModelID)
        {
            if (metadata == 0)
            {
                // Bar rod east-west
                renderer.setRenderBounds(0.0F, 0.85F, 0.375F, 1.0F, 1.0F, 0.625F);
                renderStandardInvBlock(renderer, block, metadata);
                // 8 line
                renderer.setRenderBounds(0F, 0F, 0.5F, 0.125F, 1F, 0.57F);
                renderStandardInvBlock(renderer, block, metadata);
            }
        }
    }

    @Override
    public boolean renderWorldBlock (IBlockAccess world, int x, int y, int z, Block block, int modelID, RenderBlocks renderer)
    {
        int metadata = world.getBlockMetadata(x, y, z);
        if (modelID == trellisModelID)
        {
            if (metadata == 0)
            {
                // This render is east-west
                // int metadata = world.getBlockMetadata(x, y, z);
                /*
                 * 0.0F - Higher it is, goes farther on x+ to x- - right
                 * side0.75F - higher it is, higher it is on the y axis from top
                 * down0.0F - higher it is, farther right it is on the z axis
                 * positive1.0F - higher, longer it is going negative on left
                 * side1.0F - higher it is, higher from bottom up on y axis1.0F
                 * - negative to postive on z axis minX, minY, minZ, maxX, maxY,
                 * maxZ
                 */
                // from right to left
                // Bar rod east-west
                renderer.setRenderBounds(0.0F, 0.85F, 0.375F, 1.0F, 1.0F, 0.625F);
                renderer.renderStandardBlock(block, x, y, z);
                // 8 line
                renderer.setRenderBounds(0F, -1F, 0.5F, 0.125F, 1F, 0.57F);
                renderer.renderStandardBlock(block, x, y, z);
            }
        }
        return true;
    }

    @Override
    public boolean shouldRender3DInInventory ()
    {
        return true;
    }

    @Override
    public int getRenderId ()
    {
        return trellisModelID;
    }

    public static void renderStandardInvBlock (RenderBlocks renderblocks, Block block, int meta)
    {
        Tessellator tessellator = Tessellator.instance;
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, -1F, 0.0F);
        renderblocks.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(0, meta));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        renderblocks.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(1, meta));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, -1F);
        renderblocks.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(2, meta));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        renderblocks.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(3, meta));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(-1F, 0.0F, 0.0F);
        renderblocks.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(4, meta));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        renderblocks.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(5, meta));
        tessellator.draw(); 
        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
    }
}
