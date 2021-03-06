package ptjukebox.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.oredict.OreDictionary;
import ptjukebox.Reference;
import ptjukebox.record.RecordBase;
import ptjukebox.record.RecordSoundsBase;

@ObjectHolder(Reference.MOD_ID)
public class RecordItems {
	
//	public static final List<Item> RECORDS = new ArrayList<Item>();
	
	
	public static final Item KISSTHIS_RECORD = new RecordBase("kissthis", RecordSoundsBase.kissthis);
	public static final Item PERSPECTIVES_RECORD = new RecordBase("perspectives", RecordSoundsBase.perspectives);
	public static final Item KISSASS_RECORD = new RecordBase("kissass", RecordSoundsBase.kissass);
	public static final Item D5150_RECORD = new RecordBase("dierksbentley5150", RecordSoundsBase.DierksBentley5150);
	
	
	public static void makeRecordList () {

//		for(final Item item : RECORDS) {
//			event.getRegistry().register(item);
//			item.addInformation(item.getUnlocalizedName(), worldIn, item.getUnlocalizedName(), true);
//			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
//			ITEMS.add(item);
//		}
		
	}
	
	
	@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
	public static class ItemRegistration {
		public static final NonNullList<Item> ITEMS = NonNullList.<Item>create();
		
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
	
			final Item[] items = {
					KISSTHIS_RECORD,
					PERSPECTIVES_RECORD,
					KISSASS_RECORD,
					D5150_RECORD
			};

//			 World worldIn;
			 
			for(final Item item : items) {
				event.getRegistry().register(item);
//				item.addInformation(item.getUnlocalizedName(), worldIn, item.getUnlocalizedName(), true);
				ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
				ITEMS.add(item);
			}
		}
	       	
	}

}