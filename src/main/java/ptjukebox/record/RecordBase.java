package ptjukebox.record;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemRecord;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ptjukebox.PTJukebox;
import ptjukebox.Reference;

public class RecordBase extends ItemRecord {

	public RecordBase(String name, SoundEvent soundIn) {
		super(name, soundIn);
		this.setUnlocalizedName(name);
		this.setRegistryName(Reference.MOD_ID + ":" + name);
		this.setCreativeTab(PTJukebox.tabRecords);
		
//		RecordItems.RECORDS.add(this);
	}

}
