package gregblockutils;

import gregblockutils.Items.Chunks;
import gregblockutils.Items.GBMetaItems;
import gregblockutils.Machines.GBTileEntities;
import gregblockutils.Recipes.GBMachineRecipes;
import gregblockutils.Recipes.GBRecipeAddition;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = GregBlockUtils.MODID,
        name = GregBlockUtils.NAME,
        version = GregBlockUtils.VERSION,
        dependencies = "required-after:gtadditions"
)
public class GregBlockUtils {
    public static final String MODID = "gregblockutils";
    public static final String NAME = "GregBlock Utilities";
    public static final String VERSION = "@VERSION@";

    @SidedProxy(
            modId = MODID,
            clientSide = "gregblockutils.ClientProxy",
            serverSide = "gregblockutils.CommonProxy"
    )
    public static CommonProxy proxy;

    private static Logger logger;

    public GregBlockUtils() {
        Chunks.preInit();
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        GBMetaItems.preInit();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        GBTileEntities.init();
        GBMachineRecipes.init();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit();
        GBRecipeAddition.postInit();
    }
}
