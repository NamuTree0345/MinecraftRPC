package namuTree0345.MCRPC;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;

public class MCDiscord {
	
	public static DiscordRPC lib;
	public static DiscordEventHandlers handlers;
	
	public static void RpcCreate(String appID, String details, String state, String bigImageCode, String smallImageCode, String bigImageHoverText, String smallImageHoverText) {
		 lib = DiscordRPC.INSTANCE;
	        String applicationId = appID;
	        //String steamId = "";
	        
	        handlers = new DiscordEventHandlers();
	        handlers.ready = (user) -> System.out.println("Ready!");
	        //lib.Discord_Initialize(applicationId, handlers, true, steamId);
	        lib.Discord_Initialize(applicationId, handlers, false, null);
	        
	        DiscordRichPresence presence = new DiscordRichPresence();
	        presence.startTimestamp = System.currentTimeMillis() / 1000; // epoch second
	        presence.details = details;
	        presence.state = state;
	        presence.largeImageKey = bigImageCode;
	        presence.largeImageText = bigImageHoverText;
	        presence.smallImageKey = smallImageCode;
	        presence.smallImageText = smallImageHoverText;

	        lib.Discord_UpdatePresence(presence);
	        
	        // in a worker thread
	        new Thread(() -> {
	            while (!Thread.currentThread().isInterrupted()) {
	                lib.Discord_RunCallbacks();
	                try {
	                    Thread.sleep(2000);
	                } catch (InterruptedException ignored) {}
	            }
	        }, "RPC-Callback-Handler").start();
	}
	
	public static void RpcClear() {
		lib.Discord_ClearPresence();
	}

}
