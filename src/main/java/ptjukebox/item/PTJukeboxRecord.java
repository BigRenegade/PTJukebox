package ptjukebox.item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemRecord;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ptjukebox.Reference;

public class PTJukeboxRecord extends ItemRecord {

	public PTJukeboxRecord(String name, SoundEvent soundIn) {
		super(name, soundIn);
		this.setUnlocalizedName(name);
		this.setRegistryName(Reference.MOD_ID + ":" + name);
	}

}
