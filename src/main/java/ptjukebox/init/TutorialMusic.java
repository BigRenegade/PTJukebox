package ptjukebox.init;

import ptjukebox.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@ObjectHolder(Reference.MOD_ID)
public class TutorialMusic {
	
	public static SoundEvent perspectives;
	public static SoundEvent kissthis;
	public static SoundEvent kissass;
	
	public static void registerSounds() {
		perspectives = registerSound("perspectives");
		kissthis = registerSound("kissthis");
		kissass = registerSound("kissass");
	}
	
	private static SoundEvent registerSound(String soundName) {
		final SoundEvent sound = new SoundEvent(new ResourceLocation(Reference.MOD_ID, soundName)).setRegistryName(new ResourceLocation(Reference.MOD_ID, soundName));
		ForgeRegistries.SOUND_EVENTS.register(sound);
		return (sound);
	}
	
}
