package ptjukebox.proxy;

import ptjukebox.Tutorial;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ClientProxy implements IProxy {

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		
	}

	@Override
	public void init(FMLInitializationEvent event) {
		
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		
	}

	@Override
	public void serverStarting(FMLServerStartingEvent event) {}

	@Override
	public EntityPlayerSP getPlayerFromContext(MessageContext ctx) {
		return (ctx.side.isClient() ? Minecraft.getMinecraft().player : Tutorial.proxy.getPlayerFromContext(ctx));
	}

	@Override
	public WorldClient getWorldFromContext(MessageContext ctx) {
		return (ctx.side.isClient() ? Minecraft.getMinecraft().world : Tutorial.proxy.getWorldFromContext(ctx));
	}

	@Override
	public void addRunnableFromContext(MessageContext ctx, Runnable task) {
		if(ctx.side.isClient()) Minecraft.getMinecraft().addScheduledTask(task);
		else Tutorial.proxy.addRunnableFromContext(ctx, task);
	}
}
