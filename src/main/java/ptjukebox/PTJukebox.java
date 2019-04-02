package ptjukebox;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ptjukebox.Reference;
import ptjukebox.blocks.BlockJukebox;
import ptjukebox.blocks.TileEntityJukebox;
import ptjukebox.gui.GuiHandler;
import ptjukebox.network.PacketHandler;
import ptjukebox.proxy.IProxy;
import ptjukebox.render.RenderingRegistry;

@Mod(modid = Reference.MOD_ID, version = Reference.VERSION, dependencies = Reference.DEPEND, updateJSON = Reference.UPDATEURL)
public class PTJukebox {

	@Instance
	public static PTJukebox instance = new PTJukebox();

	public static final CreativeTabs tabRecords = (new CreativeTabs("RecordsTab") {

		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(Items.RECORD_13);
		}
	});	
	
	public static BlockJukebox jukebox = new BlockJukebox("jukebox");

	@SidedProxy
	public static CommonProxy proxy;
	public static IProxy iProxy;


	@EventHandler
	public void preinit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerRenders();
		proxy.preInit(event);

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	}
	
	@EventHandler
	public void serverLoad(FMLServerStartingEvent event) {
	}
	@SubscribeEvent
	public void textureStich(TextureStitchEvent.Pre event) {

		event.getMap().registerSprite(new ResourceLocation("jukebox:gui/record"));
	}

	@SideOnly(Side.CLIENT)
	private static void registerBlock() {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(jukebox), 0,
				new ModelResourceLocation("jukebox:jukebox", "inventory"));
	}

	public static class ClientProxy extends CommonProxy {
		@Override
		public void init(FMLInitializationEvent e) {
			super.init(e);

		}

		@Override
		public void preInit(FMLPreInitializationEvent e) {
			super.preInit(e);
			registerBlock();
			MinecraftForge.EVENT_BUS.register(new PTJukebox());

		}
	}

	public static class CommonProxy {
		public void init(FMLInitializationEvent e) {
			NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());

		}

		public void postInit(FMLPostInitializationEvent e) {

		}

		public void preInit(FMLPreInitializationEvent e) {
			jukebox.setRegistryName(new ResourceLocation(Reference.MOD_ID, "jukebox"));
			ForgeRegistries.BLOCKS.register(jukebox);
			ItemBlock jukeboxItem = new ItemBlock(jukebox);
			jukeboxItem.setRegistryName(new ResourceLocation(Reference.MOD_ID, "jukebox"));
			ForgeRegistries.ITEMS.register(jukeboxItem);
			GameRegistry.registerTileEntity(TileEntityJukebox.class, "jb_jukebox");
			PacketHandler.registerMessages("jukebox");
		}
	}

	public static class ServerProxy extends CommonProxy {

	}
}
