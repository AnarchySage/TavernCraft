package taverncraft.WorldGeneration.VillageRelated;

import java.util.List;
import java.util.Random;

import net.minecraft.world.gen.structure.ComponentVillageStartPiece;
import net.minecraft.world.gen.structure.StructureVillagePieceWeight;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageCreationHandler;

public class VillageTavernHandler implements IVillageCreationHandler
{
    @Override
    public StructureVillagePieceWeight getVillagePieceWeight (Random random, int i)
    {
        return new StructureVillagePieceWeight(ComponentTavern.class, 100, i);
    }

    @Override
    public Class<?> getComponentClass ()
    {
        return ComponentTavern.class;
    }

    @Override
    public Object buildComponent (StructureVillagePieceWeight villagePiece, ComponentVillageStartPiece startPiece, List pieces, Random random, int p1, int p2, int p3, int p4, int p5)
    {
        return ComponentTavern.func_74912_a(startPiece, pieces, random, p1, p2, p3, p4, p5);
    }
}