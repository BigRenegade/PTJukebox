package ptjukebox.network;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import ptjukebox.network.PacketSendPrevious.Handler;

public class PacketHandler {
	private static int packetId = 0;

	public static SimpleNetworkWrapper INSTANCE = null;

	public static int nextID() {
		return packetId++;
	}

	public static void registerMessages() {
		INSTANCE.registerMessage(PacketSendNext.Handler.class, PacketSendNext.class, nextID(), Side.SERVER);
		INSTANCE.registerMessage(PacketSendPrevious.Handler.class, PacketSendPrevious.class, nextID(), Side.SERVER);
		INSTANCE.registerMessage(PacketSendPause.Handler.class, PacketSendPause.class, nextID(), Side.SERVER);
	}

	public static void registerMessages(String channelName) {
		INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(channelName);
		registerMessages();
	}

	public PacketHandler() {
	}
}
